package ai.cliff.assessment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ai.cliff.assessment.exception.ResourceNotFoundException;
import ai.cliff.assessment.model.Player;
import ai.cliff.assessment.model.Team;
import ai.cliff.assessment.repository.PlayerRepository;
import ai.cliff.assessment.service.PlayerService;
@Service
public class PlayerServiceImpl implements PlayerService {

	private PlayerRepository playerRepository;
	
	
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		super();
		this.playerRepository = playerRepository;
	}

	//implemntation to save players		
	@Override
	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}

	//implementation to get players with pagination and sorting order
	@Override
	public Page<Player> getPlayers(int offset, int pageSize, String field) {
		Page<Player> players= playerRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
		return players;
	}

	//implementation to get players by id
	@Override
	public Player getPlayerById(int Id) {
		// TODO Auto-generated method stub
		Optional<Player> player = playerRepository.findById(Id);
		if(player.isEmpty()) {
			throw new ResourceNotFoundException("Player", "ID", Id);
		}else {
			return player.get();
		}
	}

	//implementation update players
	@Override
	public Player updatePlayer(Player player, int Id) {
		//checking team with given id exists or not
		Player exisitingPlayer = playerRepository.findById(Id).orElseThrow(
				() -> new ResourceNotFoundException("Player", "id", Id));
		if(player.getPlayername()!=null){
				exisitingPlayer.setPlayername(player.getPlayername());
		}
		if(player.getUpdatedat()!=null) {
			exisitingPlayer.setUpdatedat(player.getUpdatedat());
		}
		if(player.getCreatedat()!=null) {
			exisitingPlayer.setCreatedat(player.getCreatedat());
		}
		if(player.getPlayerage()!=0) {
			exisitingPlayer.setPlayerage(player.getPlayerage());
		}
		if(player.getPteamId()!=0) {
			exisitingPlayer.setPteamId(player.getPteamId());
		}
		//saving exisiting team to DB
		playerRepository.save(exisitingPlayer);
		return exisitingPlayer;
	
	}

	//implementation to delte players
	@Override
	public void deletePlayer(int id) {
		//checking if team exists in DB
				playerRepository.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("Player", "Id", id));
				playerRepository.deleteById(id);
	}


//	@Override
//	public List<Player> findbypteamid(int pteamid) {
//		// TODO Auto-generated method stub
//		if(pteamid!=0) {
//			return playerRepository.findbyteamid(pteamid);
//		}
//		return playerRepository.findbyteamid(pteamid);
//	}


}
