package com.letscode.moviesbattleapi.resources;

import com.letscode.moviesbattleapi.model.Sessao;
import com.letscode.moviesbattleapi.model.Usuario;
import com.letscode.moviesbattleapi.repository.SessaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcus
 */
@RestController
@RequestMapping(value = "/api/sessao")
@Api(value = "MoviesBattle APIRest")
@CrossOrigin(origins = "*")
public class SessaoResource {
    
    @Autowired
    SessaoRepository sessaoRepository1;
    
    @GetMapping("/{usuarioId}")
    @ApiOperation(value = "Consulta a sessão atual de um usuário")
    public ResponseEntity<Sessao>consultaSessaoUsuario(@PathVariable Long usuarioId){
        Sessao sessaoUsuario = sessaoRepository1.findByUsuarioId(usuarioId);
        
        if(sessaoUsuario != null){
            Sessao sessaoUsuarioResposta = new Sessao();
            sessaoUsuarioResposta.setId(sessaoUsuario.getId());
            sessaoUsuarioResposta.setUsuario(new Usuario(sessaoUsuario.getUsuario().getId(), 
                    sessaoUsuario.getUsuario().getNomeUsuario(), null));
            
            return ResponseEntity.status(HttpStatus.OK).body(sessaoUsuarioResposta);
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @DeleteMapping("/encerra")
    @ApiOperation(value = "Encerra uma sessão de usuário")
    public void encerraSessao(@RequestBody Sessao sessao1){
        sessaoRepository1.delete(sessao1);
    }
    
}
