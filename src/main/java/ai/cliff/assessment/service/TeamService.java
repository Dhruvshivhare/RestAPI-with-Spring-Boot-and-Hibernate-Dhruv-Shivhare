package ai.cliff.assessment.service;


import org.springframework.data.domain.Page;

import ai.cliff.assessment.model.Team;

public interface TeamService {
	//Declearing all teams Methods
	Team saveTeam(Team team);
	Page<Team> getTeams(int offset ,int pageSize, String field); 
	Team getTeamById(int Id);
	Team updateTeam(Team team, int Id);
	void deleteTeam(int id);
	
}
