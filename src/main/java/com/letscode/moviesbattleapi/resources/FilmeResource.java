package com.letscode.moviesbattleapi.resources;

import com.letscode.moviesbattleapi.model.Filme;
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
@RequestMapping(value = "/api")
@Api(value = "MoviesBattle APIRest")
@CrossOrigin(origins = "*")
public class FilmeResource {
    
    @Autowired
    private FilmeRepository filmeRepository1;
    
    @GetMapping("/filme/{id}")
    public ResponseEntity<Filme>consultaPorId(@PathVariable Long imdbId){
        return ResponseEntity.ok(filmeRepository1.findById(imdbId).get());
    }
    
}
