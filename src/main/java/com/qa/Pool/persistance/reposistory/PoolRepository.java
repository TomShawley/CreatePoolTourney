package com.qa.Pool.persistance.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.qa.Pool.persistance.domain.Tourney;


@Repository
public interface PoolRepository extends JpaRepository<Tourney, Long> {

}
