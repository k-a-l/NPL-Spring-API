package com.npl.cricket.npl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npl.cricket.npl.entity.Team;
import com.npl.cricket.npl.service.TeamService;

@RestController
@RequestMapping(value = "/api/npl")
public class TeamController {
	private TeamService teamService;
	
	public TeamController(TeamService teamService) {
		super();
		this.teamService = teamService;
	}

	@GetMapping(path = "/team")
	public List<Team> getAllTeam() {
		return teamService.getAllTeam();		
		
	}
	
	@GetMapping(path = "/team/{id}")
	public Optional<Team> getTeamById(@PathVariable Long id){
		return teamService.getTeamById(id);
	}
	
	@PostMapping(path = "team/add")
	public Team addTeam(@RequestBody Team team) {
		team.setId(null);
		return teamService.addTeam(team);
	}
	
	@PutMapping(path = "team/update/{id}")
	public Team updateTeam(@PathVariable Long id,@RequestBody Team team) {
		return teamService.updateTeam(id, team);
		
	}
	
	@DeleteMapping(path = "team/delete/{id}")
	public void deleteTeam(@PathVariable Long id) {
		teamService.deleteTeam(id);
	}
	

}
