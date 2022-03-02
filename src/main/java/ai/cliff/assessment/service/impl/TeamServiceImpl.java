package ai.cliff.assessment.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import ai.cliff.assessment.exception.ResourceNotFoundException;
import ai.cliff.assessment.model.Team;
import ai.cliff.assessment.repository.TeamRepository;
import ai.cliff.assessment.service.TeamService;
@Service
public class TeamServiceImpl implements TeamService {

	private TeamRepository teamRepository;
	
	
	
	
	public TeamServiceImpl(TeamRepository teamRepository) {
		super();
		this.teamRepository = teamRepository;
	}



	//IMPLEMENTATION OF ALL TEAM METHODS______________________________________

	
	//saving teams
	@Override
	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}
	
	//finding teams with pagination and sorting order
	@Override
	public Page<Team> getTeams(int offset, int pageSize, String field) {
		Page<Team> teams= teamRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
		return teams;
	}

	//finding team by team id
	@Override
	public Team getTeamById(int Id) {
		Optional<Team> team = teamRepository.findById(Id);
		if(team.isEmpty()) {
			throw new ResourceNotFoundException("Team", "ID", Id);
		}else {
			return team.get();
		}
	}

	//updating teams, only one field can also be updated
	@Override
	public Team updateTeam(Team team, int Id) {
		//checking team with given id exists or not
		Team exisitingTeam = teamRepository.findById(Id).orElseThrow(
				() -> new ResourceNotFoundException("Team", "id", Id));
		if(team.getTeamname()!=null){
				exisitingTeam.setTeamname(team.getTeamname());
		}
		if(team.getTeamlocation()!=null){
			exisitingTeam.setTeamlocation(team.getTeamlocation());
			}
		if(team.getTeamname()!=null){
			exisitingTeam.setTeamname(team.getTeamname());
	}
		if(team.getCreatedat()!=null){
			exisitingTeam.setCreatedat(team.getCreatedat());
			}
		if(team.getCreatedat()!=null){
			exisitingTeam.setCreatedat(team.getCreatedat());
	}
	
		//saving exisiting team to DB
		teamRepository.save(exisitingTeam);
		return exisitingTeam;
		
	}

	//deleting teams by ID
	@Override
	public void deleteTeam(int id) {
		//checking if team exists in DB
		teamRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Team", "Id", id));
		teamRepository.deleteById(id);
		
	}

	
}
