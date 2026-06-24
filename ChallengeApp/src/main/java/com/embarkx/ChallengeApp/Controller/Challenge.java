package com.embarkx.ChallengeApp.Controller;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Challenge {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "challenge_month")
	    private String month;

	    private String description;

	    public Challenge() {
	    }

	    public Challenge(long id, String month, String description) {
	        this.id = id;
	        this.month = month;
	        this.description = description;
	    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String monthString) {
		this.month = monthString;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
}
