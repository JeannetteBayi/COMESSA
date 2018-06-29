package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Middleware.DatabaseOperations;

public class MatchResult {
	private String country;
	private Integer id;
	private String fifaCode;
	private Integer groupId;
	private String groupLetter;
	private Integer goalsFor;
	private Integer goalsAgainst;
	private Double point;
	private Integer gamesPlayed;
	private Double points;
	private Integer wins;
	private Integer losses;
	private DatabaseOperations database;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFifaCode() {
		return fifaCode;
	}

	public void setFifaCode(String fifaCode) {
		this.fifaCode = fifaCode;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupLetter() {
		return groupLetter;
	}

	public void setGroupLetter(String groupLetter) {
		this.groupLetter = groupLetter;
	}

	public Integer getGoalsFor() {
		return goalsFor;
	}

	public void setGoalsFor(Integer goalsFor) {
		this.goalsFor = goalsFor;
	}

	public Integer getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(Integer goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	// getting the best rank team
	public Team getBestRankTeamDetails() {
		database = new DatabaseOperations();
		return database.getBestRankTeamDetails();
	}

	public Team getBestRankTeamDetailsByTeam(String teamName) {
		database = new DatabaseOperations();
		return database.getBestRankTeamDetailsByTeam(teamName);

	}

	// getting Team goals

	public Integer getTeamGoal(String TeamName) {
		database = new DatabaseOperations();
		return database.getTeamGoal(TeamName);
	}

	// getting team losses
	public Integer getlosses(String TeamName) {
		database = new DatabaseOperations();
		return database.getlosses(TeamName);
	}

	// getting wins

	public Integer getWins(String teamName) {
		// TODO Auto-generated method stub
		database = new DatabaseOperations();
		return database.getWins(teamName);
	}

	// getting best team by group

	public String toString() {
		return "MatchResult [country=" + country + ", id=" + id + ", fifaCode="
				+ fifaCode + ", groupId=" + groupId + ", groupLetter="
				+ groupLetter + ", goalsFor=" + goalsFor + ", goalsAgainst="
				+ goalsAgainst + ", point=" + point + ", gamesPlayed="
				+ gamesPlayed + ", points=" + points + ", wins=" + wins
				+ ", losses=" + losses + "]";
	}

}
