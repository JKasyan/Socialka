package com.kasyan.Socialka.Dto;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="friends")
public class Friend implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_friendship", nullable=false)
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="id_friend")
	private int friend;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFriend() {
		return friend;
	}

	public void setFriend(int friend) {
		this.friend = friend;
	}
	
	@Override
	public String toString() {
		return "[idFriendship = "+id+", user with email = "+email+", have a friend with id = "+friend+" ]";
	}
	
}
