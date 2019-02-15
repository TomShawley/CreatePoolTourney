package com.qa.Pool.persistance.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tourney {
	
	@Id
	@GeneratedValue
	private Long TourneyId;
	private String TourneyName;
	private String TourneyDate;
	private String TourneyTime;
	private String MaxPlayers;
	
	
	public Tourney() {
		
	}
	
	public Tourney(Long TourneyId, String TourneyName, String TourneyDate, String TourneyTime, String MaxPlayers){
		this.TourneyId = TourneyId;
		this.TourneyDate = TourneyDate;
		this.TourneyTime = TourneyTime;
		this.TourneyName = TourneyName;
		this.MaxPlayers = MaxPlayers;
	}

	public Long getTourneyId() {
		return TourneyId;
	}

	public void setTourneyId(Long tourneyId) {
		TourneyId = tourneyId;
	}

	public String getTourneyName() {
		return TourneyName;
	}

	public void setTourneyName(String tourneyName) {
		TourneyName = tourneyName;
	}

	public String getTourneyDate() {
		return TourneyDate;
	}

	public void setTourneyDate(String tourneyDate) {
		TourneyDate = tourneyDate;
	}

	public String getTourneyTime() {
		return TourneyTime;
	}

	public void setTourneyTime(String tourneyTime) {
		TourneyTime = tourneyTime;
	}

	public String getMaxPlayers() {
		return MaxPlayers;
	}

	public void setMaxPlayers(String maxPlayers) {
		MaxPlayers = maxPlayers;
	}

	
	
	
	

}
