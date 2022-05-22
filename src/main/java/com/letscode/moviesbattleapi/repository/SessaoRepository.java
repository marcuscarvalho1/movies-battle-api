package com.letscode.moviesbattleapi.repository;

import com.letscode.moviesbattleapi.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Marcus
 */
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    @Query("SELECT s FROM Sessao s WHERE s.usuario.id=?1")
    public Sessao findByUsuarioId(Long usuarioId);
}
