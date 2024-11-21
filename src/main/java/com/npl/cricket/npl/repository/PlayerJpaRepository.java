package com.npl.cricket.npl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npl.cricket.npl.entity.Player;

@Repository
public interface PlayerJpaRepository extends JpaRepository<Player, Long> {
	
	List<Player> findByMarqueeTrue();
	List<Player> findByForeignPlayerTrue();
	
	

}
