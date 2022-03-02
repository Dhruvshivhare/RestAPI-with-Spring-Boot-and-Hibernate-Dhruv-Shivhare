package ai.cliff.assessment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import ai.cliff.assessment.model.Player;

public interface PlayerService {
	//Declearing all players Methods
	Player savePlayer(Player player);
	Page<Player> getPlayers(int offset ,int pageSize, String field);
	Player getPlayerById(int Id);
	Player updatePlayer(Player team, int Id);
	void deletePlayer(int id);
	
//	@Query("SELECT p from players p WHERE p.pteamid ")
//	List<Player> findbypteamid(int pteamid);
	
}
