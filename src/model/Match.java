package model;

import java.util.Date;

public class Match {
	
private String venue;
private String location;
private Date dateTime;
private String Status;
private String fifaId;
private String winner;
private String homeTeamStatistics;
private String  awayTeamStatistics;
//private String +homeTeamStatistics: Object
//private String  awayTeamStatistics:Object

public String getVenue() {
	return venue;
}
public void setVenue(String venue) {
	this.venue = venue;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Date getDateTime() {
	return dateTime;
}
public void setDateTime(Date dateTime) {
	this.dateTime = dateTime;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public String getFifaId() {
	return fifaId;
}
public void setFifaId(String fifaId) {
	this.fifaId = fifaId;
}
public String getWinner() {
	return winner;
}
public void setWinner(String winner) {
	this.winner = winner;
}
public String getHomeTeamStatistics() {
	return homeTeamStatistics;
}
public void setHomeTeamStatistics(String homeTeamStatistics) {
	this.homeTeamStatistics = homeTeamStatistics;
}
public String getAwayTeamStatistics() {
	return awayTeamStatistics;
}
public void setAwayTeamStatistics(String awayTeamStatistics) {
	this.awayTeamStatistics = awayTeamStatistics;
}


public String toString() {
	return "Match [venue=" + venue + ", location=" + location + ", dateTime="
			+ dateTime + ", Status=" + Status + ", fifaId=" + fifaId
			+ ", winner=" + winner + ", homeTeamStatistics="
			+ homeTeamStatistics + ", awayTeamStatistics=" + awayTeamStatistics
			+ "]";
}


}
