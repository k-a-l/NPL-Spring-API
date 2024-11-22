package com.npl.cricket.npl.search;

public class PlayerSearchCriteriaDTO {
	private String name;
	private String teamName;
	private String role;

	public PlayerSearchCriteriaDTO() {
	}

	public PlayerSearchCriteriaDTO(String name, String teamName, String role) {
		super();
		this.name = name;
		this.teamName = teamName;
		this.role = role;
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

}
