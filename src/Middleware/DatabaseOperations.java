package Middleware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import model.Team;

public class DatabaseOperations {

	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/worldcup";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private Connection connection;
	private Properties properties;
	private static final String MAX_POOL = "250";
	Team team ;

	// create properties
	private Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			properties.setProperty("user", USERNAME);
			properties.setProperty("password", PASSWORD);
			properties.setProperty("MaxPooledStatements", MAX_POOL);
		}
		return properties;
	}

	public Connection connect() {
		if (connection == null) {
			try {
				Class.forName(DATABASE_DRIVER);
				connection = DriverManager.getConnection(DATABASE_URL,
						getProperties());
				System.out.println("connecting ............................");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	// Teams registration
	public String RegisterTeam(Team team) {

		System.out.println("Registration in database!!!!!!!!!!!!!");
		System.out.println("Registration in database!!!!!!!!!!!!!"
				+ team.getGroupId());

		String query = " insert into team (Id, alternateName, fifaCode, groupId, groupLetter, country)"
				+ " values (?, ?, ?, ?, ?,?)";

		try {
			// create the mysql insert preparedstatement
			Connection connection = connect();
			java.sql.PreparedStatement preparedStmt = connection
					.prepareStatement(query);
			preparedStmt.setInt(1, team.getId());
			preparedStmt.setString(2, team.getAlternateName());
			preparedStmt.setString(3, team.getFifaCode());
			preparedStmt.setString(4, team.getGroupId());
			preparedStmt.setString(5, team.getGroupLetter());
			preparedStmt.setString(6, team.getCountry());

			// execute the preparedstatement

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// disconnecting from databse
		disconnect();

		return "well Done";

	}

	public Team getBestRankTeamDetails() {

		
		// connecting to database
		Connection connection = connect();
		try {
			java.sql.Statement stmt = connection.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT * FROM matchresult  WHERE  points = (SELECT MAX(points)  FROM matchresult)");

			while (rs.next()) {

				// create a team object and return it
				team =  new Team (rs.getInt("Id"),rs.getString("groupLetter"), rs.getString("fifaCode"), rs.getString("groupId"),rs.getString("groupLetter"), rs.getString("country")  );
				// ************************a query to get details for this
				// country**************
			}
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return team;

	}

	public Team getBestRankTeamDetailsByTeam(String teamName) {
		Team team = new Team();
		// connecting to database
		Connection connection = connect();
		try {
			java.sql.Statement stmt = connection.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT * FROM matchresult  WHERE groupLetter='"
							+ teamName
							+ "' AND  points = (SELECT MAX(points)  FROM matchresult)");

			while (rs.next()) {
				
				team.setCountry(rs.getString("country"));
			

			}
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return team;
	}

	// disconnect database
	public void disconnect() {
		if (connection != null) {
			try {
				System.out
						.println("disconnecting ............................");
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Integer getTeamGoal(String teamName) {
		int goals = 0;
		Connection connection = connect();
		// TODO Auto-generated method stub

		try {
			java.sql.Statement stmt = connection.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT * FROM matchresult  WHERE  country ='"
							+ teamName + "'");

			while (rs.next()) {

				// create a team object and return it

				goals += rs.getInt("goalsFor");

				// ************************a query to get details for this
				// country**************
			}
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return goals;
	}

	// getting losses for a given team
	public Integer getlosses(String teamName) {
		// TODO Auto-generated method stub

		int losses = 0;
		Connection connection = connect();
		// TODO Auto-generated method stub

		try {
			java.sql.Statement stmt = connection.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT * FROM matchresult  WHERE  country ='"
							+ teamName + "'");

			while (rs.next()) {

				// create a team object and return it

				losses += rs.getInt("losses");

				// ************************a query to get details for this
				// country**************
			}
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return losses;
	}

	public Integer getWins(String teamName) {
		// TODO Auto-generated method stub

		int wins = 0;
		Connection connection = connect();
		// TODO Auto-generated method stub

		try {
			java.sql.Statement stmt = connection.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT * FROM matchresult  WHERE  country ='"
							+ teamName + "'");

			while (rs.next()) {

				// create a team object and return it

				wins += rs.getInt("wins");

				// ************************a query to get details for this
				// country**************
			}
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wins;
	}

	// getting the list of all teams
	public Team[] getAllTeams() {
		Team teams[] = null   ;
		int index = 0;
		// connecting to database
		Connection connection = connect();
		try {
			java.sql.Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM team");

			while (rs.next()) {
				teams[index] = new Team(rs.getInt(1),
						rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				index++;
				System.out.println(rs.getString("alternateName"));
				

			}
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teams;
	}

}
