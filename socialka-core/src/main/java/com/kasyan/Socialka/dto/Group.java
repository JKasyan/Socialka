package com.kasyan.Socialka.dto;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groups")
public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_group", unique=true, nullable=false)
	private int id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="town", nullable=false)
	private String town;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	@Override
	public String toString() {
		return "[ title: "+title+", town: "+town+" ]";
	}
}
