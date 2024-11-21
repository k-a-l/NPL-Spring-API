package com.npl.cricket.npl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npl.cricket.npl.entity.Team;

public interface TeamJpaRepository extends JpaRepository<Team, Long> {

}
