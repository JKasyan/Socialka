package com.kasyan.Socialka.Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_role_id", unique=true, nullable=false)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="id_user", nullable=false)
	private User user;
	
	@Column(name="role")
	private String role;

	public User getProfile() {
		return user;
	}

	public void setProfile(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
