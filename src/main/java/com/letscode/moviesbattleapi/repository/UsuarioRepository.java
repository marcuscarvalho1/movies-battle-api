package com.letscode.moviesbattleapi.repository;

import com.letscode.moviesbattleapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Marcus
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
