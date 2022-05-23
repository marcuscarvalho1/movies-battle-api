package com.letscode.moviesbattleapi.resources;

import com.letscode.moviesbattleapi.input.EscolhaFilmeForm;
import com.letscode.moviesbattleapi.model.Filme;
import com.letscode.moviesbattleapi.model.Partida;
import com.letscode.moviesbattleapi.model.Ranking;
import com.letscode.moviesbattleapi.model.Sessao;
import com.letscode.moviesbattleapi.repository.FilmeRepository;
import com.letscode.moviesbattleapi.repository.PartidaRepository;
import com.letscode.moviesbattleapi.repository.RankingRepository;
import com.letscode.moviesbattleapi.repository.SessaoRepository;
import com.letscode.moviesbattleapi.repository.UsuarioRepository;
import com.letscode.moviesbattleapi.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcus
 */
@RestController
@RequestMapping(value = "/api/partida")
@Api(value = "MoviesBattle APIRest")
@CrossOrigin(origins = "*")
public class PartidaResource {
    
    @Autowired
    private PartidaRepository partidaRepository1;
    
    @Autowired
    private SessaoRepository sessaoRepository1;
    
    @Autowired
    private RankingRepository rankingRepository1;
    
    @Autowired
    private UsuarioRepository usuarioRepository1;
    
    @Autowired
    private FilmeRepository filmeRepository1;
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna os números da partida dado um id")
    public ResponseEntity<Partida>consultaPorId(@PathVariable Long id){
        return ResponseEntity.ok(partidaRepository1.findById(id).get());
    }
    
    @PostMapping("/inicia")
    @ApiOperation(value = "Abre uma nova partida")
    public ResponseEntity<Partida> abrePartida(@RequestBody Partida partida1){
        //Verifica se usuário está em uma sessão válida
        Sessao sessao1 = sessaoRepository1.findByUsuarioId(partida1.getUsuarioLogadoId());
        if(sessao1 != null){
            return ResponseEntity.ok(partidaRepository1.save(partida1));
        }else
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    
    @PostMapping("/escolhe-filme")
    @ApiOperation(value = "Resolve uma tentativa do jogador de responder o quiz")
    public ResponseEntity<Partida> escolheFilme(@RequestBody EscolhaFilmeForm escolhaFilmeForm1){
        if(sessaoRepository1.count() > 0){
            Optional<Partida> OPartida = partidaRepository1.findById(escolhaFilmeForm1.getPartidaId());
            if(!OPartida.isEmpty()){
                Partida partida1 = OPartida.get();
                if(partida1 != null && !partida1.isEncerrada()){
                    Filme[] filmes = filmeRepository1.findDuplaFilmes(escolhaFilmeForm1.getFilme1Id(), escolhaFilmeForm1.getFilme2Id());
                    Double pontuacaoFilme1 = filmes[0].getVotosImdb() * filmes[0].getAvaliacaoImdb();
                    Double pontuacaoFilme2 = filmes[1].getVotosImdb() * filmes[1].getAvaliacaoImdb();
                    Long filmeMelhorPontuacao = Double.compare(pontuacaoFilme1, pontuacaoFilme2) > 0 ? filmes[0].getId() : filmes[1].getId();
                    //Caso tenha acertado, atualiza a pontuação da partida.
                    if(filmeMelhorPontuacao.equals(escolhaFilmeForm1.getFilmeEscolhidoId())){
                        partida1.setPontos(partida1.getPontos() + 1);
                        partidaRepository1.save(partida1);

                        return ResponseEntity.status(HttpStatus.OK).body(partida1);
                    //Caso tenha errado, atualiza os erros da partida. Caso tenha atingido 3 erros, encerra a partida e atualiza o ranking
                    }else{
                        partida1.setErros(partida1.getErros() + 1);
                        partidaRepository1.save(partida1);

                        if(partida1.getErros() == 3){
                            return encerraPartida(partida1.getId());
                        }
                    }

                    return ResponseEntity.status(HttpStatus.OK).body(partida1);
                }else{
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
                }
            }else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
    
    @GetMapping("/encerra/{id}")
    @ApiOperation(value = "Encerra uma partida")
    public ResponseEntity<Partida> encerraPartida(@PathVariable Long id){
        if(sessaoRepository1.count() > 0){
            Optional<Partida> OPartida1 = partidaRepository1.findById(id);
            if(!OPartida1.isEmpty()){
                Partida partida1 = OPartida1.get();
                partida1.setEncerrada(true);
                partidaRepository1.save(partida1);
                
                //Pesquisa se é a melhor posição já alcançada pelo jogador, e reposiciona o ranking nesse caso
                Ranking rankingAtual = rankingRepository1.findByUsuarioId(partida1.getUsuarioLogadoId());
                Ranking ranking1 = new Ranking();
                boolean reordenarRanking = true;
                if(rankingAtual != null){
                    if(rankingAtual.getPontos() < partida1.getPontos()){
                        ranking1 = new Ranking(rankingAtual);
                        ranking1.setPontos(partida1.getPontos());
                    }else{
                        reordenarRanking = false;
                    }
                }else{
                    ranking1 = new Ranking();
                    ranking1.setPontos(partida1.getPontos());
                    ranking1.setPosicao(0);
                    ranking1.setUsuario(usuarioRepository1.findById(partida1.getUsuarioLogadoId()).get());
                }
                if(reordenarRanking){
                    if(ranking1.getId() == null){
                        ranking1.setId(rankingRepository1.count() + 1);
                    }
                    rankingRepository1.save(ranking1);
                    List<Ranking>rankingListaOrdenada = Util.reordenaRanking(rankingRepository1.findAllByOrderByPontosDesc());
                    rankingRepository1.deleteAll();
                    rankingRepository1.saveAll(rankingListaOrdenada);
                }
                
                return ResponseEntity.status(HttpStatus.OK).body(partida1);
            }else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }else
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    
}
