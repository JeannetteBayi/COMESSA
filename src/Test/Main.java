package Test;

import Controller.WordlCupController;
import Middleware.DatabaseOperations;
import model.Team;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("with dynamic web project!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		// TODO Auto-generated method stub
		Team myTeam = new Team ();
		//System.out.println (myTeam.toString());
		WordlCupController WordlCupController = new WordlCupController();

		//team registration
		//WordlCupController.registerTeam ( 1,  "alternateName", "fifaCode", "groupId", "groupLetter",  "country" );

		//answers
		//get best rank team
		System.out.println("Best ranked Team is "+WordlCupController.getBestRankTeamDetails());


		//getting goals for a given team name
		System.out.println("Goals for Argentina are: "+WordlCupController.getTeamGoal("Argentina"));

		//getting losses for a given team name
		System.out.println("losses for Argentina are: "+WordlCupController.getTeamGoal("Argentina"));

		//getting wins for a given team name
		System.out.println("wins for Argentina are: "+WordlCupController.getWins("Argentina"));
		
		//getting wins for a given team name
	System.out.println("best team within this group is: "+WordlCupController.getBestRankTeamDetailsByTeam("D"));
	}
}


