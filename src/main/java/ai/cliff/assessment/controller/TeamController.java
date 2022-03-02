package ai.cliff.assessment.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.cliff.assessment.model.Team;
import ai.cliff.assessment.repository.TeamRepository;
import ai.cliff.assessment.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/teams")
@Api(value = "/api/teams" ,tags = "teamsfunction")
public class TeamController {
	
	private TeamService teamservice;
	public TeamController(TeamService teamservice) {
		super();
		this.teamservice = teamservice;
	}

	
	
	//-----------------
	
	
	//REST API to add teams
	@PostMapping()
	public ResponseEntity<Team> saveTeam(@RequestBody Team team){
		return new ResponseEntity<Team>(teamservice.saveTeam(team), HttpStatus.CREATED);
	}
	
	
	//REST API to get all teams with pagination and required ascending order
	@GetMapping("/getTeams/{offset}/{pageSize}/{field}")
	public Page<Team> fetchTeams(@PathVariable int offset, @PathVariable int pageSize ,@PathVariable String field){
		Page<Team> teams = teamservice.getTeams(offset, pageSize, field);
		return teams;
	}
	
	
	//REST API to get team by ID
	@GetMapping("{id}")
	public ResponseEntity<Team> fetchTeambyId(@PathVariable("id") int Id) {
		return new ResponseEntity<Team>(teamservice.getTeamById(Id),HttpStatus.OK);
	}
	
	//REST API to update teaminfo
	@PutMapping("{Id}")
	public ResponseEntity<Team> updateTeam(@PathVariable("Id") int id
																,@RequestBody Team team){
		return new ResponseEntity<Team>(teamservice.updateTeam(team, id), HttpStatus.OK);
		
	}
	
	//REST API to delete team info
	@DeleteMapping("{Id}")
	public ResponseEntity<String> deleteTeam(@PathVariable("Id") int id){
		teamservice.deleteTeam(id);
		return new ResponseEntity<String>("Team deleted Successfully",HttpStatus.OK);
	}
	
}
