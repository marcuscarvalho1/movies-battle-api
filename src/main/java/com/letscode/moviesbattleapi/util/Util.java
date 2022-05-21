package com.letscode.moviesbattleapi.util;

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
    
}
