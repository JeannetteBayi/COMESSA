package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import model.MatchResult;
import model.Team;

@RestController
@EnableWebMvc
public class WordlCupController  {
	
	
	private Team team ;

	
	private MatchResult  matchResult;
	
	public void registerTeam ( Integer Id,  String alternateName, String fifaCode, String groupId, String groupLetter,  String country ){
		//some logic to check if the team is registered already

		//register the team if not registered

		//

		team = new Team ();
		team.setId(Id);
		team.setAlternateName(alternateName);
		team.setFifaCode(fifaCode);
		team.setGroupId(groupId);
		team.setGroupLetter(groupLetter);
		team.setCountry(country);
		team.RegisterTeam();


	}


	//getting detaills of the overall best team
	@RequestMapping(value = "/teams/best", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE} )
	@ResponseBody 
	public Team getBestRankTeamDetails(){
		matchResult = new MatchResult();
		System.out.println("In controller"+matchResult.getBestRankTeamDetails());
		return matchResult.getBestRankTeamDetails();

	}


	//getting best team by group
	@RequestMapping(value = "/teams/{groupId}/best", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE} )
	@ResponseBody 
	public Team getBestRankTeamDetailsByTeam( @PathVariable(value="groupId") final String groupId){
		matchResult = new MatchResult();
		return matchResult.getBestRankTeamDetailsByTeam(groupId);

	}


	//getting goals for a given team name
	@RequestMapping(value = "/teams/{teamName}/goals", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE} )
	@ResponseBody 
	public Integer getTeamGoal(@PathVariable(value="teamName") final String teamName){
		matchResult = new MatchResult();
		return matchResult.getTeamGoal(teamName);
	}

	//getting losses for a given team name
	@RequestMapping(value = "/teams/{teamName}/losses", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE} )
	@ResponseBody 
	public Integer getLosses(@PathVariable(value="teamName") final String teamName){
		matchResult = new MatchResult();
		return matchResult.getlosses(teamName);
	}

	//getting wins for a given team name
	@RequestMapping(value = "/teams/{teamName}/wins", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE} )
	@ResponseBody 
	public Integer getWins(@PathVariable(value="teamName") final String teamName){
		matchResult = new MatchResult();
		return matchResult.getWins(teamName);
	}
	
	
	//gettings all teams
	//getting wins for a given team name
		@RequestMapping(value = "/teams", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE} )
		@ResponseBody 
		public Team [] getAllTeams(){
			team = new Team();
			return team.getAllTeams();
		}
}
