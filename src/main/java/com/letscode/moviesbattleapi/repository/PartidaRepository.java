package com.letscode.moviesbattleapi.repository;

import com.letscode.moviesbattleapi.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Marcus
 */
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    
    @Query("SELECT p FROM Partida p WHERE p.usuarioLogadoId=?1")
    public Partida findByUsuarioLogadoId(Long usuarioLogadoId);
}
