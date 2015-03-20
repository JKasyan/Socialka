package com.kasyan.Socialka.Dto;

import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Image implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_photo", unique=true, nullable=false)
	private int id;
	@Column(name="title", nullable=false)
	private String title;
	@Column(name="photo", nullable=false)
	private Blob photo;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="photo")
	private Set<User> users = new HashSet<User>();
	
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
	
	public Blob getPhoto() {
		return photo;
	}
	
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
