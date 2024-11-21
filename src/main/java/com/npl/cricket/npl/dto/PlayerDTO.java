package com.npl.cricket.npl.dto;

public class PlayerDTO {
	private Long id;
	private String name;
	private String teamName; // Team name instead of full Team object
	private String role;
	private String nationality;
	
	public PlayerDTO() {}
	
	public PlayerDTO(Long id, String name, String teamName, String role, String nationality) {
		super();
		this.id = id;
		this.name = name;
		this.teamName = teamName;
		this.role = role;
		this.nationality = nationality;
	}
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
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	@Override
	public String toString() {
		return "PlayerDTO [id=" + id + ", name=" + name + ", teamName=" + teamName + ", role=" + role + ", nationality="
				+ nationality + "]";
	}

}