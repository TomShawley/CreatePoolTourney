package com.qa.Pool.serive;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.qa.Pool.persistance.domain.Tourney;





public interface PoolService {
	
	List<Tourney> getTourneys();

    Tourney getTourney(Long id);

    Tourney addTourney(Tourney account);

    ResponseEntity<Object> deleteTourney(Long id);

    ResponseEntity<Object> updateTourney(Tourney account, Long id);
}
