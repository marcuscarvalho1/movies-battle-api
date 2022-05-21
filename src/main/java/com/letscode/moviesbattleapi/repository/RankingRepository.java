package com.letscode.moviesbattleapi.repository;

import com.letscode.moviesbattleapi.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Marcus
 */
public interface RankingRepository extends JpaRepository<Ranking, Long>{
    
}
