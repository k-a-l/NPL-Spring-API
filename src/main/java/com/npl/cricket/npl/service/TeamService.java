package com.npl.cricket.npl.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.npl.cricket.npl.entity.Team;

public interface TeamService {
	List<Team> getAllTeam();

	Optional<Team> getTeamById(Long id);

	Team addTeam(Team team);

	Team updateTeam(Long id,Team Team);

	ResponseEntity<Map<String, String>> deleteTeam(Long id);
	

}
