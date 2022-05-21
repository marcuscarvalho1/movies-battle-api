package com.letscode.moviesbattleapi.repository;

import com.letscode.moviesbattleapi.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Marcus
 */
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    
}
