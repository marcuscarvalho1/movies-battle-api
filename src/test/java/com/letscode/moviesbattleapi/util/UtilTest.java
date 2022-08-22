package com.letscode.moviesbattleapi.util;

import com.letscode.moviesbattleapi.model.Ranking;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Order;

/**
 *
 * @author Marcus
 */
public class UtilTest {
    @Test
    @Order(1)
    public void testDevolveDuplaValoresAleatorios(){
        Long valorMaximo = 50L;
        assertTrue(Util.devolveDuplaValoresAleatorios(valorMaximo)[0] >= 1L);
        assertTrue(Util.devolveDuplaValoresAleatorios(valorMaximo)[1] >= 1L);
        assertTrue(Util.devolveDuplaValoresAleatorios(valorMaximo)[0] <= valorMaximo);
        assertTrue(Util.devolveDuplaValoresAleatorios(valorMaximo)[1] <= valorMaximo);
    }
    
    @Test
    @Order(2)
    public void testReordenaRanking(){
        List<Ranking>rankingLista =  new ArrayList<>();
        Ranking ranking1 = new Ranking();
        ranking1.setId(0L);
        ranking1.setPosicao(5);
        rankingLista.add(ranking1);
        ranking1 = new Ranking();
        ranking1.setId(1L);
        ranking1.setPosicao(1);
        rankingLista.add(ranking1);
        ranking1 = new Ranking();
        ranking1.setId(2L);
        ranking1.setPosicao(3);
        rankingLista.add(ranking1);
        ranking1 = new Ranking();
        ranking1.setId(3L);
        ranking1.setPosicao(4);
        rankingLista.add(ranking1);
        ranking1 = new Ranking();
        ranking1.setId(4L);
        ranking1.setPosicao(2);
        rankingLista.add(ranking1);
        
        List<Ranking> listaRankingResposta = Util.reordenaRanking(rankingLista);
        assertTrue(listaRankingResposta.get(0).getPosicao() < listaRankingResposta.get(1).getPosicao());
        assertTrue(listaRankingResposta.get(1).getPosicao() < listaRankingResposta.get(2).getPosicao());
        assertTrue(listaRankingResposta.get(2).getPosicao() < listaRankingResposta.get(3).getPosicao());
        assertTrue(listaRankingResposta.get(3).getPosicao() < listaRankingResposta.get(4).getPosicao());
    }
}
