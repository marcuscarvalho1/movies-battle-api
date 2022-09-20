package com.letscode.moviesbattleapi.resources;

import com.letscode.moviesbattleapi.input.EscolhaFilmeForm;
import com.letscode.moviesbattleapi.model.Filme;
import com.letscode.moviesbattleapi.model.Partida;
import com.letscode.moviesbattleapi.model.Sessao;
import com.letscode.moviesbattleapi.model.Usuario;
import com.letscode.moviesbattleapi.repository.FilmeRepository;
import com.letscode.moviesbattleapi.repository.PartidaRepository;
import com.letscode.moviesbattleapi.repository.RankingRepository;
import com.letscode.moviesbattleapi.repository.SessaoRepository;
import com.letscode.moviesbattleapi.repository.UsuarioRepository;
import java.util.Optional;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Marcus
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PartidaResourcesTests {
    
    @InjectMocks
    PartidaResource partidaResource;
    
    @Mock
    PartidaRepository partidaRepository1;
    
    @Mock
    SessaoRepository sessaoRepository1;
    
    @Mock
    RankingRepository rankingRepository1;
    
    @Mock
    UsuarioRepository usuarioRepository1;
    
    @Mock
    FilmeRepository filmeRepository1;
    
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    @Order(1)
    public void testConsultaPorId(){
        Partida partida1 = new Partida();
        partida1.setEncerrada(true);
        partida1.setErros(0);
        partida1.setId(Long.MIN_VALUE);
        partida1.setPontos(0);
        partida1.setUsuarioLogadoId(Long.MAX_VALUE);
        Optional<Partida> oPartida = Optional.of(partida1);
        doReturn(oPartida).when(partidaRepository1).findById(Mockito.anyLong());
        
        assertEquals(partidaResource.consultaPorId(0L).getBody(), ((Partida)partida1));
    }
    
    @Test
    @Order(2)
    public void testAbrePartida_sessaoNotNull(){
        Partida partida1 = new Partida();
        partida1.setEncerrada(true);
        partida1.setErros(0);
        partida1.setId(Long.MIN_VALUE);
        partida1.setPontos(0);
        partida1.setUsuarioLogadoId(Long.MAX_VALUE);
        ResponseEntity<Partida> rPartida = ResponseEntity.ok(partida1);
        Usuario usuario1 = new Usuario(0L, "nome", "senha");
        Sessao sessao1 = new Sessao(0L, usuario1);
        doReturn(sessao1).when(sessaoRepository1).findByUsuarioId(Mockito.anyLong());
        doReturn(partida1).when(partidaRepository1).save(Mockito.any(Partida.class));
        
        assertEquals(partidaResource.abrePartida(partida1), rPartida);
    }
    
    @Test
    @Order(3)
    public void testAbrePartida_sessaoNull(){
        Partida partida1 = new Partida();
        partida1.setEncerrada(true);
        partida1.setErros(0);
        partida1.setId(Long.MIN_VALUE);
        partida1.setPontos(0);
        partida1.setUsuarioLogadoId(Long.MAX_VALUE);
        ResponseEntity<Partida> rPartida = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        assertEquals(partidaResource.abrePartida(partida1), rPartida);
    }
    
    @Test
    @Order(4)
    public void testEscolheFilme_respostaCerta(){
        doReturn(1L).when(sessaoRepository1).count();
        Partida partida1 = new Partida();
        partida1.setEncerrada(false);
        partida1.setErros(0);
        partida1.setId(10L);
        partida1.setPontos(0);
        partida1.setUsuarioLogadoId(Long.MAX_VALUE);
        Optional<Partida> oPartida = Optional.of(partida1);
        doReturn(oPartida).when(partidaRepository1).findById(Mockito.anyLong());
        
        EscolhaFilmeForm escolhaFilmeForm1 = new EscolhaFilmeForm();
        escolhaFilmeForm1.setFilme1Id(1L);
        escolhaFilmeForm1.setFilme2Id(2L);
        escolhaFilmeForm1.setFilmeEscolhidoId(1L);
        escolhaFilmeForm1.setPartidaId(Long.MIN_VALUE);
        
        Filme filme1 = new Filme();
        filme1.setId(0L);
        filme1.setVotosImdb(1234L);
        filme1.setAvaliacaoImdb(1234L);
        Filme filme2 = new Filme();
        filme2.setId(1L);
        filme2.setVotosImdb(1235L);
        filme2.setAvaliacaoImdb(1235L);
        Filme[] filmes = new Filme[]{filme1, filme2};
        doReturn(filmes).when(filmeRepository1).findDuplaFilmes(Mockito.anyLong(), Mockito.anyLong());
        
        Partida partida2 = new Partida(partida1);
        partida2.setPontos(1);
        ResponseEntity<Partida> rPartida = ResponseEntity.ok(partida2);
        
        assertEquals(partidaResource.escolheFilme(escolhaFilmeForm1), rPartida);
    }
}
