package model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import Middleware.DatabaseOperations;


public class Team {
	
	
	//fields
	private Integer Id;
	private String alternateName;
	private String fifaCode;
	private String groupId ;
	private String groupLetter ;
	private String country;
	
	private DatabaseOperations database;
	
	public Team(){
		
	}
	
	public Team(int Id,  String alternateName,String fifaCode, String groupId , String groupLetter, String country) {
		setId(Id);
		setAlternateName(alternateName);
		setFifaCode(fifaCode);
		setGroupId(groupId);
		setGroupLetter(groupLetter);
		setCountry(country);
	}

	
	
	
	//getters and setters
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public String getAlternateName() {
		return alternateName;
	}
	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}
	
	
	public String getFifaCode() {
		return fifaCode;
	}
	public void setFifaCode(String fifaCode) {
		this.fifaCode = fifaCode;
	}
	
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	

	public String getGroupLetter() {
		return groupLetter;
	}
	public void setGroupLetter(String groupLetter) {
		this.groupLetter = groupLetter;
	}
	
	//other function
	public String RegisterTeam (){
		//communicate with database
		System.out.println ("Registration in model''''''''");
		database = new DatabaseOperations();
		database.RegisterTeam(this);
		return "welldone";
	}

	public Integer getTeamGoal(String TeamName){
		database =  new DatabaseOperations(); 
		return database.getTeamGoal(TeamName);
	}

	//getting the list of all team
	public Team[] getAllTeams() {
		database =  new DatabaseOperations(); 
		return database.getAllTeams();
	
	}

	
	//tostring function
	public String toString() {
		return "Team [Id=" + Id + ", country=" + country + ", alternateName="
				+ alternateName + ", fifaCode=" + fifaCode + ", groupId="
				+ groupId + ", groupLetter=" + groupLetter + "]";
	}

	

}
