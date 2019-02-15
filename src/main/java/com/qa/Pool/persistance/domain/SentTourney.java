package com.qa.Pool.persistance.domain;

public class SentTourney {
	private Long TourneyId;
	private String TourneyName;
	private String TourneyDate;
	private String TourneyTime;
	private String MaxPlayers;
	
	public SentTourney() {
		
	}
	
	public SentTourney(Tourney tourney) {
		this.TourneyId = tourney.getTourneyId();
		this.TourneyTime = tourney.getTourneyName();
		this.TourneyDate = tourney.getTourneyDate();
		this.TourneyId = tourney.getTourneyId();
		this.MaxPlayers = tourney.getMaxPlayers();
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
