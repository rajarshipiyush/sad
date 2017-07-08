package com.cg.beans;


import java.time.LocalDate;

public class PlayerBean {
	
	private int age;
	private int playerId;
	private String playerName;
	private LocalDate dateOfBirth;
	private String country;
	private String battingStyle;
	private int century;
	private int matches;
	private int totalRunScore;
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBattingStyle() {
		return battingStyle;
	}
	public void setBattingStyle(String battingStyle) {
		this.battingStyle = battingStyle;
	}
	public int getCentury() {
		return century;
	}
	public void setCentury(int century) {
		this.century = century;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getTotalRunScore() {
		return totalRunScore;
	}
	public void setTotalRunScore(int totalRunScore) {
		this.totalRunScore = totalRunScore;
	}
	
	@Override
	public String toString() {
		return "PlayerBean [age=" + age + ", playerId=" + playerId
				+ ", playerName=" + playerName + ", dateOfBirth=" + dateOfBirth
				+ ", country=" + country + ", battingStyle=" + battingStyle
				+ ", century=" + century + ", matches=" + matches
				+ ", totalRunScore=" + totalRunScore + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
