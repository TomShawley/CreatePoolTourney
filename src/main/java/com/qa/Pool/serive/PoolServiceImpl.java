package com.qa.Pool.serive;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.Pool.persistance.domain.Tourney;
import com.qa.Pool.persistance.reposistory.PoolRepository;
import com.qa.Pool.util.exceptions.AccountNotFoundException;


@Service
public class PoolServiceImpl implements PoolService {

	@Autowired
    private PoolRepository repo;

    public List<Tourney> getTourneys() {
        return repo.findAll();
    }

    public Tourney getTourney(Long id) {
        Optional<Tourney> account = repo.findById(id);
        return account.orElseThrow(() -> new AccountNotFoundException(id.toString()));
    }

    public Tourney addTourney(Tourney tourney) {
        return repo.save(tourney);
    }

    @Override
    public ResponseEntity<Object> deleteTourney(Long id) {
        if(accountExists(id)){
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Object> updateTourney(Tourney tourney, Long id) {
        if(accountExists(id)){
            tourney.setTourneyId(id);
            repo.save(tourney);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    private boolean accountExists(Long id){
        Optional<Tourney> accountOptional = repo.findById(id);
        return accountOptional.isPresent();
    }

	
}
