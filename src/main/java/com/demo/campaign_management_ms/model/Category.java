package com.demo.campaign_management_ms.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Category")
public class Category {
	private String gaming;
	private String banking;
	private String movie;
	private String music;
	
	/**
	 * @param gaming
	 * @param banking
	 * @param movie
	 * @param music
	 */
	public Category(String gaming, String banking, String movie, String music) {
		super();
		this.gaming = gaming;
		this.banking = banking;
		this.movie = movie;
		this.music = music;
	}

	/**
	 * @return the gaming
	 */
	public String getGaming() {
		return gaming;
	}

	/**
	 * @param gaming the gaming to set
	 */
	public void setGaming(String gaming) {
		this.gaming = gaming;
	}

	/**
	 * @return the banking
	 */
	public String getBanking() {
		return banking;
	}

	/**
	 * @param banking the banking to set
	 */
	public void setBanking(String banking) {
		this.banking = banking;
	}

	/**
	 * @return the movie
	 */
	public String getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(String movie) {
		this.movie = movie;
	}

	/**
	 * @return the music
	 */
	public String getMusic() {
		return music;
	}

	/**
	 * @param music the music to set
	 */
	public void setMusic(String music) {
		this.music = music;
	}

	@Override
	public String toString() {
		return "Category [gaming=" + gaming + ", banking=" + banking + ", movie=" + movie + ", music=" + music + "]";
	}
	
}
