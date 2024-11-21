package com.npl.cricket.npl.service.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.npl.cricket.npl.entity.Team;
import com.npl.cricket.npl.repository.TeamJpaRepository;
import com.npl.cricket.npl.service.TeamService;

@Service
public class TeamServiceImplementation implements TeamService {
private TeamJpaRepository teamJpaRepository;

	public TeamServiceImplementation(TeamJpaRepository teamJpaRepository) {
	super();
	this.teamJpaRepository = teamJpaRepository;
}

	@Override
	public List<Team> getAllTeam() {
		return teamJpaRepository.findAll();
	}

	@Override
	public Optional<Team> getTeamById(Long id) {
		return teamJpaRepository.findById(id);
	}

	@Override
	public Team addTeam(Team team) {
		
		return teamJpaRepository.save(team);
	}

	@Override
	public Team updateTeam(Long id, Team team) {
		Optional<Team> existingTeam=teamJpaRepository.findById(id);
		if(existingTeam.isPresent()) {
			Team updatedTeam=existingTeam.get();
			
			updatedTeam.setCity(team.getCity());
			updatedTeam.setName(team.getName());
			updatedTeam.setOwnershipName(team.getOwnershipName());
			
			return teamJpaRepository.save(updatedTeam);
			
		}
		return null;
	}

	@Override
	public ResponseEntity<Map<String, String>> deleteTeam(Long id) {
		teamJpaRepository.deleteById(id);
		Map<String, String> response=new HashMap<>();
		return ResponseEntity.ok(response);
		
		
	}

}
