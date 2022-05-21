package com.letscode.moviesbattleapi.resources;

import com.letscode.moviesbattleapi.model.Filme;
import com.letscode.moviesbattleapi.output.TamanhoCatalogo;
import com.letscode.moviesbattleapi.repository.FilmeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna o filme dado um id")
    public ResponseEntity<Filme>consultaPorId(@PathVariable Long id){
        return ResponseEntity.ok(filmeRepository1.findById(id).get());
    }
    
    @GetMapping("/tamanho-catalogo")
    @ApiOperation(value = "Retorna a quantidade de filmes do catálogo")
    public TamanhoCatalogo consultaTamanhoCatalogo(){
        return new TamanhoCatalogo(filmeRepository1.count());
    }
}
