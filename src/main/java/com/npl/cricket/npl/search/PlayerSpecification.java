package com.npl.cricket.npl.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.npl.cricket.npl.entity.Player;

import jakarta.persistence.criteria.Predicate;

public class PlayerSpecification {

	public static Specification<Player> searchPlayers(PlayerSearchCriteriaDTO criteria) {
		return (root, query, CriteriaBuilder) -> {
			List<Predicate> prediList = new ArrayList<Predicate>();
			if (criteria.getName() != null) {
				prediList.add(CriteriaBuilder.like(root.get("name"), "%" + criteria.getName() + "%"));

			}
			if (criteria.getTeamName() != null) {
				prediList.add(CriteriaBuilder.like(root.get("teamName"), "%" + criteria.getTeamName() + "%"));
			}

			if (criteria.getRole() != null) {
				prediList.add(CriteriaBuilder.like(root.get("role"), "%" + criteria.getRole() + "%"));
			}
			return CriteriaBuilder.and(prediList.toArray(new Predicate[0]));

		};

	}
}
