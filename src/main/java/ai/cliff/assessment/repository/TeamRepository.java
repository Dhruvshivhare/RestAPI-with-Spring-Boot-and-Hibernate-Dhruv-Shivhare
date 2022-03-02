package ai.cliff.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.cliff.assessment.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
