package com.letscode.moviesbattleapi.repository;

import com.letscode.moviesbattleapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Marcus
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    @Query("SELECT u FROM Usuario u WHERE u.nomeUsuario=?1 AND u.senha=?2")
    public Usuario pesquisaLogin(String nomeUsuario, String senha);
    
    @Query("SELECT u FROM Usuario u WHERE u.nomeUsuario=?1")
    public Usuario pesquisaNomeUsuarioRepetido(String nomeUsuario);
    
}
