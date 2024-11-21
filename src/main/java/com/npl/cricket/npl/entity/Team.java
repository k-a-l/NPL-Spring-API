package com.npl.cricket.npl.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String ownershipName; // Ownership Name
	private String city;

	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore //prevent looping. Apply @JsonIgnore on the  in the parent entity to child collection.
	private List<Player> players; // List of players in the team

	public Team() {
	}

	// Constructor
	public Team(Long id, String name, String ownershipName, String city, List<Player> players) {
		this.id = id;
		this.name = name;
		this.ownershipName = ownershipName;
		this.city = city;
		this.players = players;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnershipName() {
		return ownershipName;
	}

	public void setOwnershipName(String ownershipName) {
		this.ownershipName = ownershipName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team{" + "id=" + id + ", name='" + name + '\'' + ", ownershipName='" + ownershipName + '\'' + ", city='"
				+ city + '\'' + ", players=" + players + '}';
	}
}
