package com.letscode.moviesbattleapi.repository;

import com.letscode.moviesbattleapi.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Marcus
 */
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    
}
