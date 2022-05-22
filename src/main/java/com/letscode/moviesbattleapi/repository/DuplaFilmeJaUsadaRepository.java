package com.letscode.moviesbattleapi.repository;

import com.letscode.moviesbattleapi.model.DuplaFilmeJaUsada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Marcus
 */
public interface DuplaFilmeJaUsadaRepository extends JpaRepository<DuplaFilmeJaUsada, Long> {
    
    @Query("SELECT dfju FROM DuplaFilmeJaUsada dfju "
         + "WHERE (dfju.idFilme1 = ?1 AND idFilme2 = ?2) OR (dfju.idFilme2 = ?1 AND idFilme1 = ?2)")
    DuplaFilmeJaUsada pesquisaPorFilme1EFilme2(Long idFilme1, Long idFilme2);
    
}
