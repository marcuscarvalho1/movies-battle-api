package com.letscode.moviesbattleapi.resources;

import com.letscode.moviesbattleapi.model.DuplaFilmeJaUsada;
import com.letscode.moviesbattleapi.model.Filme;
import com.letscode.moviesbattleapi.output.FilmeOutput;
import com.letscode.moviesbattleapi.output.TamanhoCatalogo;
import com.letscode.moviesbattleapi.repository.DuplaFilmeJaUsadaRepository;
import com.letscode.moviesbattleapi.repository.FilmeRepository;
import com.letscode.moviesbattleapi.util.Util;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Marcus
 */
@RestController
@RequestMapping(value = "/api/filme")
@Api(value = "MoviesBattle APIRest")
@CrossOrigin(origins = "*")
public class FilmeResource {
    
    @Autowired
    private FilmeRepository filmeRepository1;
    
    @Autowired
    private DuplaFilmeJaUsadaRepository duplaFilmeJaUsadaRepository1;
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna o filme dado um id")
    public ResponseEntity<Filme>consultaPorId(@PathVariable Long id){
        return ResponseEntity.ok(filmeRepository1.findById(id).get());
    }
    
    @GetMapping("/dois-filmes-aleatorios")
    @ApiOperation(value = "Retorna dois filmes aleatórios (e que já não tenham sido retornados na partida)")
    public ResponseEntity<FilmeOutput[]>puxaDoisFilmesAleatorios(){
        boolean achouDuplaNaoRepetida = false;
        Long[] doisValoresAleatorios = {0L,0L};
        while(!achouDuplaNaoRepetida){
            doisValoresAleatorios = Util.devolveDuplaValoresAleatorios(filmeRepository1.count());
            DuplaFilmeJaUsada duplaFilmeJaUsada1 = 
                    duplaFilmeJaUsadaRepository1.pesquisaPorFilme1EFilme2(doisValoresAleatorios[0], doisValoresAleatorios[1]);
            if(duplaFilmeJaUsada1 == null){
                achouDuplaNaoRepetida = true;
            }
        }
        //Encapsula os filmes para que possam ser mandados para o front
        Filme filme1 = filmeRepository1.findById(doisValoresAleatorios[0]).get();
        FilmeOutput filmeOutput1 = new FilmeOutput();
        filmeOutput1.setId(filme1.getId());
        filmeOutput1.setTitulo(filme1.getTitulo());
        filmeOutput1.setAno(filme1.getAno());
        filmeOutput1.setGenero(filme1.getGenero());
        filmeOutput1.setDiretor(filme1.getDiretor());
        filmeOutput1.setPosterUrl(filme1.getPosterUrl());
        Filme filme2 = filmeRepository1.findById(doisValoresAleatorios[1]).get();
        FilmeOutput filmeOutput2 = new FilmeOutput();
        filmeOutput2.setId(filme2.getId());
        filmeOutput2.setTitulo(filme2.getTitulo());
        filmeOutput2.setAno(filme2.getAno());
        filmeOutput2.setGenero(filme2.getGenero());
        filmeOutput2.setDiretor(filme2.getDiretor());
        filmeOutput2.setPosterUrl(filme2.getPosterUrl());
        
        //Salva na tabela tb_dupla_filme_ja_usada o conjunto de filmes
        duplaFilmeJaUsadaRepository1.save(new DuplaFilmeJaUsada(null, filmeOutput1.getId(), filmeOutput2.getId()));
        FilmeOutput[] resposta = {filmeOutput1, filmeOutput2};
        
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }
    
    @GetMapping("/tamanho-catalogo")
    @ApiOperation(value = "Retorna a quantidade de filmes do catálogo")
    public TamanhoCatalogo consultaTamanhoCatalogo(){
        return new TamanhoCatalogo(filmeRepository1.count());
    }
}
