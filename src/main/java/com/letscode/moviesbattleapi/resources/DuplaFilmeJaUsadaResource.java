package com.letscode.moviesbattleapi.resources;

import com.letscode.moviesbattleapi.input.DuplaFilmeJaUsadaForm;
import com.letscode.moviesbattleapi.model.DuplaFilmeJaUsada;
import com.letscode.moviesbattleapi.repository.DuplaFilmeJaUsadaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcus
 */
@RestController
@RequestMapping(value = "/api/dupla")
@Api(value = "MoviesBattle APIRest")
@CrossOrigin(origins = "*")
public class DuplaFilmeJaUsadaResource {
    
    @Autowired
    DuplaFilmeJaUsadaRepository duplaFilmeJaUsadaRepository1;
    
    @PostMapping("/ja-usada")
    @ApiOperation(value = "Retorna se a referida combinação de filmes já foi utilizada nesta partida")
    public DuplaFilmeJaUsada pesquisaDuplaFilmeJaUsada(@RequestBody DuplaFilmeJaUsadaForm duplaFilmeJaUsadaForm1){
        return duplaFilmeJaUsadaRepository1.pesquisaPorFilme1EFile2(duplaFilmeJaUsadaForm1.getIdFilme1(), 
                duplaFilmeJaUsadaForm1.getIdFilme2());
    }
    
    @PostMapping("/insere")
    @ApiOperation(value = "Registra que uma dupla de filmes já foi usada nesta partida")
    public DuplaFilmeJaUsada insereDuplaFilmeJaUsada(@RequestBody DuplaFilmeJaUsada duplaFilmeJaUsada1){
        return duplaFilmeJaUsadaRepository1.save(new DuplaFilmeJaUsada(duplaFilmeJaUsada1));
    }
    
    @DeleteMapping("/limpa")
    @ApiOperation(value = "Exclui todas as duplas registradas na partida")
    public void limpaTabelaDuplaFilmeJaUsada(){
        duplaFilmeJaUsadaRepository1.deleteAll();
    }
}
