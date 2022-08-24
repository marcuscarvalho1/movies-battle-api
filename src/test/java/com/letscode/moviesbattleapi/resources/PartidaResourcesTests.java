package com.letscode.moviesbattleapi.resources;

import com.letscode.moviesbattleapi.model.Partida;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

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
        Optional<Partida> optional = Optional.of(partida1);
        doReturn(optional).when(partidaRepository1).findById(Mockito.anyLong());
        
        assertTrue(partidaResource.consultaPorId(0L).getBody() == ((Partida)partida1));
    }
    
}
