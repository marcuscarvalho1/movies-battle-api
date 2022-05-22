package com.letscode.moviesbattleapi.util;

import com.letscode.moviesbattleapi.model.Ranking;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Marcus
 */
public class Util {
    
    public static Long[] devolveDuplaValoresAleatorios(Long maximo){
        //Devolve dois Id's aleatórios de filmes, dado o tamanho do catálogo de filmes
        Long[] duplaValoresAleatorios = {ThreadLocalRandom.current().nextLong(0, maximo), 
            ThreadLocalRandom.current().nextLong(0, maximo)};
        
        return duplaValoresAleatorios;
    }
    
    public static List<Ranking> reordenaRanking(List<Ranking> rankingLista){
        //Recebe uma lista de ranking com os atributos "posição" embaralhados, e os devolve ordenados por pontuação
        List<Ranking>rankingResposta = new ArrayList<>();
        int i = 1;
        for(Ranking ranking1: rankingLista){
            ranking1.setPosicao(i);
            rankingResposta.add(ranking1);
            i++;
        }
        
        return rankingResposta;
    }
    
}
