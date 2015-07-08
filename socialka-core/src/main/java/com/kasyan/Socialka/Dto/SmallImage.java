package com.kasyan.Socialka.Dto;

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
//@Table(name="small_images")
@Table(name="new_small_images")
public class SmallImage {
	
	
	@GenericGenerator(name = "generator", strategy = "foreign", 
	parameters = {@Parameter(name = "property", value = "user")})
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id_user",unique=true,nullable=false)
	private int id;
	
	//@Column(name="small_photo")
	@Column(name="small_image")
	private Blob smallPhoto;
	
	//@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	//@JoinColumn(name="id_user")
	
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blob getSmallPhoto() {
		return smallPhoto;
	}

	public void setSmallPhoto(Blob smallPhoto) {
		this.smallPhoto = smallPhoto;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
