package com.kasyan.Socialka.Dto;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
//@Table(name="images")
@Table(name="images_new")
public class Image implements Serializable{

	private static final long serialVersionUID = -8126123976226910217L;

	@GenericGenerator(name = "generator", strategy = "foreign", 
	parameters = {@Parameter(name = "property", value = "user")})
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id_user",unique=true,nullable=false)
	private int id;
	
	/*
	@Column(name="title", nullable=false)
	private String title;
	*/
	
	//@Column(name="photo", nullable=false)
	@Column(name="image")
	private Blob photo;
	
	/*
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="id_user", nullable=false)
	private User user;
	*/
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	*/
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
