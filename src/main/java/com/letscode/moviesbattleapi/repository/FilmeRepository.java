package com.letscode.moviesbattleapi.repository;

import com.letscode.moviesbattleapi.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Marcus
 */
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    
    @Query("SELECT f FROM Filme f WHERE f.id IN (?1, ?2)")
    public Filme[] findDuplaFilmes(Long filme1Id, Long filme2Id);
    
}
