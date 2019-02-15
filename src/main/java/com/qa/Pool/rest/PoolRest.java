package com.qa.Pool.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.Pool.persistance.domain.SentTourney;
import com.qa.Pool.persistance.domain.Tourney;
import com.qa.Pool.serive.PoolService;






@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class PoolRest {

	@Autowired
    private PoolService service;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    
    
    @GetMapping("${path.getTourneys}")
    public List<Tourney> getTourneys() {
        return service.getTourneys();
    }

    @GetMapping("${path.getTourneyById}")
    public Tourney getTourney(@PathVariable Long id) {
        return service.getTourney(id);
    }

    @DeleteMapping("${path.deleteTourney}")
    public ResponseEntity<Object> deleteTourney(@PathVariable Long id) {
        return service.deleteTourney(id);
    }

    @PutMapping("${path.updateTourney}")
    public ResponseEntity<Object> updateTourney(@RequestBody Tourney tourney, @PathVariable Long id) {
        return service.updateTourney(tourney, id);
    }
    
    @PostMapping("${path.createTourney}")
    public Tourney createAccount(@RequestBody Tourney tourney) {
        sendToQueue(tourney);
    	return service.addTourney(tourney);
    }
    

    private void sendToQueue(Tourney tourney){
        SentTourney tourneyToStore =  new SentTourney(tourney);
        jmsTemplate.convertAndSend("TourneyQueue",tourneyToStore);
    }
}
