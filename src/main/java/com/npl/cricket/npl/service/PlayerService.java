package com.npl.cricket.npl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.npl.cricket.npl.dto.PlayerDTO;
import com.npl.cricket.npl.entity.Player;
import com.npl.cricket.npl.search.PlayerSearchCriteriaDTO;

public interface PlayerService {
	List<Player> getAllPlayers();

	Optional<Player> getPlayerById(Long id);

	Player addPlayer(Player player);

	Player updatePlayer(Long id,Player player);

	boolean deletePlayer(Long id);
	
	public List<PlayerDTO> getAllPlayerTeam();
	
	List<PlayerDTO> findAllMarqueePlayer();
	
	List<PlayerDTO> findAllForeignPlayer();
	
	List<PlayerSearchCriteriaDTO> searchPlayer (PlayerSearchCriteriaDTO criteria);

}
