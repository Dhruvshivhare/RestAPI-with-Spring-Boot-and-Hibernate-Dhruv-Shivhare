package ai.cliff.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ai.cliff.assessment.model.Player;
import ai.cliff.assessment.model.Team;
import ai.cliff.assessment.repository.PlayerRepository;
import ai.cliff.assessment.service.PlayerService;

@RestController
@RequestMapping("api/players")
public class PlayerController {
	
	private PlayerService playerService;
	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}
	
	//rest api to save players
	@PostMapping
	public ResponseEntity<Player> savePlayer(@RequestBody Player player){
			return new ResponseEntity<Player>(playerService.savePlayer(player), HttpStatus.CREATED);
	}
	
	//find record with pagination and sorting
	@GetMapping("/getPlayers/{offset}/{pageSize}/{field}")
	public Page<Player> fetchPlayers(@PathVariable int offset, @PathVariable int pageSize ,@PathVariable String field){
		Page<Player> players = playerService.getPlayers(offset, pageSize, field);
		return players;
	}

	//REST API to get players by ID
		@GetMapping("{id}")
		public ResponseEntity<Player> fetchPlayerbyId(@PathVariable("id") int Id) {
			return new ResponseEntity<Player>(playerService.getPlayerById(Id),HttpStatus.OK);
		}
		
		
		//REST API to update teaminfo
		@PutMapping("{Id}")
		public ResponseEntity<Player> updatePlayer(@PathVariable("Id") int id
																	,@RequestBody Player player){
			return new ResponseEntity<Player>(playerService.updatePlayer(player, id), HttpStatus.OK);
			
		}
		//REST API to delete team info
		@DeleteMapping("{Id}")
		public ResponseEntity<String> deletePlayer(@PathVariable("Id") int id){
			playerService.deletePlayer(id);
			return new ResponseEntity<String>("Player deleted Successfully",HttpStatus.OK);
		}

		
		
}
