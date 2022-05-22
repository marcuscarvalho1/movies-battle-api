package com.letscode.moviesbattleapi.resources;

import com.letscode.moviesbattleapi.model.Ranking;
import com.letscode.moviesbattleapi.model.Usuario;
import com.letscode.moviesbattleapi.repository.RankingRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcus
 */
@RestController
@RequestMapping(value = "/api/ranking")
@Api(value = "MoviesBattle APIRest")
@CrossOrigin(origins = "*")
public class RankingResource {
    
    @Autowired
    RankingRepository rankingRepository1;
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Consulta o ranking de um usuário dado o seu id")
    public ResponseEntity<Ranking>consultaPorId(@PathVariable Long id){
        return ResponseEntity.ok(rankingRepository1.findById(id).get());
    }
    
    @GetMapping("/consulta")
    @ApiOperation(value = "Retorna as posições atuais do ranking")
    public List<Ranking>consultaRanking(){
        List<Ranking>rankingLista = rankingRepository1.findAllByOrderByPontosDesc();
        List<Ranking>rankingListaResposta = new ArrayList<>();
        for(Ranking ranking1: rankingLista){
            Ranking rankingOutput = new Ranking();
            rankingOutput.setId(ranking1.getId());
            rankingOutput.setPontos(ranking1.getPontos());
            rankingOutput.setPosicao(ranking1.getPosicao());
            rankingOutput.setUsuario(new Usuario(ranking1.getUsuario().getId(), ranking1.getUsuario().getNomeUsuario(), null));
            
            rankingListaResposta.add(rankingOutput);
        }
        
        return rankingListaResposta;
    }
    
    @PostMapping("/insere")
    @ApiOperation(value = "Insere um usuário no ranking")
    public Ranking insereRanking(@RequestBody Ranking ranking1){
        return rankingRepository1.save(new Ranking(ranking1));
    }
    
    @PutMapping("/atualiza")
    @ApiOperation(value = "Atualiza o ranking de um usuário")
    public void atualizaRanking(@RequestBody Ranking ranking1){
        rankingRepository1.save(ranking1);
    }
    
}
