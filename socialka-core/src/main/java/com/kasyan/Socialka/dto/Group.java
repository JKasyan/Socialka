package com.kasyan.Socialka.dto;

import javax.persistence.*;

@Entity
@Table(name="groups")
public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_group", unique=true, nullable=false)
	private int idGroup;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="city", nullable=false)
	private String city;

	public int getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Group{" +
				"idGroup=" + idGroup +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
