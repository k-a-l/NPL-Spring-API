package com.npl.cricket.npl.controller;

import java.util.List;
import java.util.Optional;

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

import com.npl.cricket.npl.dto.PlayerDTO;
import com.npl.cricket.npl.entity.Player;
import com.npl.cricket.npl.search.PlayerSearchCriteriaDTO;
import com.npl.cricket.npl.service.PlayerService;

@RestController
@RequestMapping(value = "/api/npl")
public class PlayerController {

	private PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;

	}

	@GetMapping(path = "/players")
	public List<Player> getAllPlayer() {
		return playerService.getAllPlayers();
	}

	@GetMapping(path = "/players/{id}")
	public Optional<Player> getPlayerById(@PathVariable Long id) {
		return playerService.getPlayerById(id);

	}

	@PostMapping(path = "/players/add")
	public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
		player.setId(null);
		Player savedPlayer = playerService.addPlayer(player);
		return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
	}

	@PutMapping(path = "/players/update/{id}")
	public Player updatePlayers(@RequestBody Player player, @PathVariable Long id) {
		return playerService.updatePlayer(id, player);

	}

	@DeleteMapping(path = "/players/delete/{id}")
	public ResponseEntity<String> deletePlayers(@PathVariable Long id) {
		boolean isDeleted = playerService.deletePlayer(id);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to delete");

		}

	}

	@GetMapping(path = "/player-team")
	public List<PlayerDTO> getPlayerTeam() {
		return playerService.getAllPlayerTeam();
	}

	@GetMapping(path = "/players/marquee")
	public List<PlayerDTO> getMarqueePlayer() {
		return playerService.findAllMarqueePlayer();
	}
	
	@GetMapping(path = "/players/foreign")
	public List<PlayerDTO> getForeignPlayer() {
		return playerService.findAllForeignPlayer();
	}
	
	@PostMapping("/players/search")
	public ResponseEntity<List<PlayerSearchCriteriaDTO>> searchPlayer(@RequestBody PlayerSearchCriteriaDTO criteria){
		List<PlayerSearchCriteriaDTO> searchPlayer = playerService.searchPlayer(criteria);
		return ResponseEntity.ok(searchPlayer);
	}

}
