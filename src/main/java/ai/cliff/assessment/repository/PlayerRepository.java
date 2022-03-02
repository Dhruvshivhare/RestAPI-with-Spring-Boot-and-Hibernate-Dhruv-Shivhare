package ai.cliff.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ai.cliff.assessment.model.Player;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
