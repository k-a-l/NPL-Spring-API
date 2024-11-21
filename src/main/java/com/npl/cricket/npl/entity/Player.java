package com.npl.cricket.npl.entity;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity(name = "player")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int age;

	@ManyToOne
	@JoinColumn(name = "team_id",referencedColumnName = "id" ,nullable = false)
	private Team team;

	private double price;
	private String role;
	private String nationality;
	private boolean marquee;
	private boolean foreignPlayer;

	public Player() {
	}

	// Constructor
	public Player(Long id, String name, int age, Team team, double price, String role, String nationality,
			boolean marquee, boolean foreignPlayer) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.team = team;
		this.price = price;
		this.role = role;
		this.nationality = nationality;
		this.marquee = marquee;
		this.foreignPlayer = foreignPlayer;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public boolean isMarquee() {
		return marquee;
	}

	public void setMarquee(boolean marquee) {
		this.marquee = marquee;
	}

	public boolean isForeignPlayer() {
		return foreignPlayer;
	}

	public void setForeignPlayer(boolean foreignPlayer) {
		this.foreignPlayer = foreignPlayer;
	}

	@Override
	public String toString() {
		return "Player{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", team='" + team + '\''
				+ ", price=" + price + ", role='" + role + '\'' + ", nationality='" + nationality + '\'' + ", marquee="
				+ marquee + ", foreignPlayer=" + foreignPlayer + '}';
	}
}
