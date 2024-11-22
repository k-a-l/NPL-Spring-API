package com.npl.cricket.npl.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.npl.cricket.npl.dto.PlayerDTO;
import com.npl.cricket.npl.entity.Player;
import com.npl.cricket.npl.repository.PlayerJpaRepository;
import com.npl.cricket.npl.search.PlayerSearchCriteriaDTO;
import com.npl.cricket.npl.search.PlayerSpecification;
import com.npl.cricket.npl.service.PlayerService;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;

@Service
public class PlayerServiceImplementation implements PlayerService {

	private PlayerJpaRepository playerJpaRepository;

	public PlayerServiceImplementation(PlayerJpaRepository playerJpaRepository) {
		super();
		this.playerJpaRepository = playerJpaRepository;
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerJpaRepository.findAll();
	}

	@Override
	public Optional<Player> getPlayerById(Long id) {
		return playerJpaRepository.findById(id);
	}

	@Override
	public Player addPlayer(Player player) {
		return playerJpaRepository.save(player);
	}

	@Override
	public Player updatePlayer(Long id, Player player) {
		Optional<Player> existingPlayer = playerJpaRepository.findById(id);
		if (existingPlayer.isPresent()) {
			Player updatedPlayer = existingPlayer.get();

			updatedPlayer.setName(player.getName());
			updatedPlayer.setAge(player.getAge());
			updatedPlayer.setTeam(player.getTeam());
			updatedPlayer.setPrice(player.getPrice());
			updatedPlayer.setRole(player.getRole());
			updatedPlayer.setNationality(player.getNationality());
			updatedPlayer.setMarquee(player.isMarquee());
			updatedPlayer.setForeignPlayer(player.isForeignPlayer());

			// Save the updated player and return it
			return playerJpaRepository.save(updatedPlayer);
		}
		return null;
	}

	@Override
	public boolean deletePlayer(Long id) {
		Optional<Player> playerAvailable = playerJpaRepository.findById(id);
		if (playerAvailable.isPresent()) {
			playerJpaRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<PlayerDTO> getAllPlayerTeam() {
		return playerJpaRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());

	}

	private PlayerDTO convertEntityToDto(Player player) {
		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setId(player.getId());
		playerDTO.setName(player.getName());
//        playerDTO.setAge(player.getAge());
		playerDTO.setTeamName(player.getTeam().getName()); // Map team name
//        playerDTO.setPrice(player.getPrice());
		playerDTO.setRole(player.getRole());
		playerDTO.setNationality(player.getNationality());
		// playerDTO.setMarquee(player.isMarquee());

		return playerDTO;
	}

//	private PlayerDTO convertEntityToDtoForMarquee(Player player) {
//		PlayerDTO playerDTO = new PlayerDTO();
//		playerDTO.setId(player.getId());
//		playerDTO.setName(player.getName());
////        playerDTO.setAge(player.getAge());
//		playerDTO.setTeamName(player.getTeam().getName()); // Map team name
//		// playerDTO.setPrice(player.getPrice());
////        playerDTO.setRole(player.getRole());
//		playerDTO.setNationality(player.getNationality());
//		// playerDTO.setMarquee(player.isMarquee());
//
//		return playerDTO;
//	}

	@Override
	public List<PlayerDTO> findAllMarqueePlayer() {
		return playerJpaRepository.findByMarqueeTrue()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<PlayerDTO> findAllForeignPlayer() {
		return playerJpaRepository.findByForeignPlayerTrue()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	private PlayerSearchCriteriaDTO convertSearchDto(Player player) {
		PlayerSearchCriteriaDTO playerSearchDto=new PlayerSearchCriteriaDTO();
		playerSearchDto.setName(player.getName());
		playerSearchDto.setRole(player.getRole());
		playerSearchDto.setTeamName(player.getTeam().getName());
		return playerSearchDto;
		
		
	}

	@Override
	public List<PlayerSearchCriteriaDTO> searchPlayer(PlayerSearchCriteriaDTO criteria) {
	    return playerJpaRepository.findAll(PlayerSpecification.searchPlayers(criteria))
	                              .stream()
	                              .map(this::convertSearchDto)
	                              .collect(Collectors.toList());
	}


	

}
