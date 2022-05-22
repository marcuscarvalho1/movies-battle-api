package com.letscode.moviesbattleapi.repository;

import com.letscode.moviesbattleapi.model.Ranking;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Marcus
 */
public interface RankingRepository extends JpaRepository<Ranking, Long>{
    
    public List<Ranking>findAllByOrderByPontosDesc();
    
    @Query("SELECT r FROM Ranking r WHERE r.usuario.id=?1")
    public Ranking findByUsuarioId(Long usuarioId);
}
