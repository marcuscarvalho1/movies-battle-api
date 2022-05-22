package com.letscode.moviesbattleapi.resources;

import com.letscode.moviesbattleapi.model.Sessao;
import com.letscode.moviesbattleapi.model.Usuario;
import com.letscode.moviesbattleapi.output.UsuarioOutput;
import com.letscode.moviesbattleapi.repository.SessaoRepository;
import com.letscode.moviesbattleapi.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcus
 */
@RestController
@RequestMapping(value = "/api/usuario")
@Api(value = "MoviesBattle APIRest")
@CrossOrigin(origins = "*")
public class UsuarioResource {
    
    @Autowired
    private UsuarioRepository usuarioRepository1;
    
    @Autowired
    private SessaoRepository sessaoRepository1;
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Consulta um usuário dado o seu id")
    public UsuarioOutput consultaPorId(@PathVariable Long id){
        Usuario usuario1 = ResponseEntity.ok(usuarioRepository1.findById(id).get()).getBody();
        if(usuario1 != null){
            return new UsuarioOutput(usuario1.getId(), usuario1.getNomeUsuario());
        }
        
        return null;
    }
    
    @PostMapping("/insere")
    @ApiOperation(value = "Insere um novo usuário")
    public UsuarioOutput insereUsuario(@RequestBody Usuario usuario1){
        Usuario novoUsuario = usuarioRepository1.save(usuario1);
        if(novoUsuario != null){
            return new UsuarioOutput(novoUsuario.getId(), novoUsuario.getNomeUsuario());
        }
        
        return null;
    }
    
    @PostMapping("/autentica")
    @ApiOperation(value = "Autentica um usuário, dado um logine uma senha")
    public ResponseEntity<UsuarioOutput> autenticaUsuario(@RequestBody Usuario usuario1){
        Usuario usuarioLogado = usuarioRepository1.pesquisaLogin(usuario1.getNomeUsuario(), usuario1.getSenha());
        if(usuarioLogado != null){
            //Abre a sessão do usuário
            Sessao sessao1 = new Sessao(null, new Usuario(usuarioLogado.getId(), usuarioLogado.getNomeUsuario(), null));
            sessaoRepository1.save(sessao1);
            
            //Encapsula o usuário para ir para o front
            UsuarioOutput usuarioOutputLogado = new UsuarioOutput(usuarioLogado.getId(), usuarioLogado.getNomeUsuario());
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOutputLogado);
        }
        
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
