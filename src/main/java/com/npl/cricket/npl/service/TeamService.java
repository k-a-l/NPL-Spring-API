package com.npl.cricket.npl.service;

import java.util.List;
import java.util.Optional;

import com.npl.cricket.npl.entity.Team;

public interface TeamService {
	List<Team> getAllTeam();

	Optional<Team> getTeamById(int id);

	Team addTeam(Team team);

	Team updateTeam(int id,Team Team);

	void deleteTeam(int id);
	

}
