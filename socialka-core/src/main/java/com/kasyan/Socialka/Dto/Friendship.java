package com.kasyan.Socialka.Dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="friends")
public class Friendship implements Serializable{

	private static final long serialVersionUID = 914675182506952276L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_friendship")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_one")
	private User friendOne;
	
	@ManyToOne
	@JoinColumn(name="id_two")
	private User friendTwo;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getFriendOne() {
		return friendOne;
	}
	public void setFriendOne(User friendOne) {
		this.friendOne = friendOne;
	}
	public User getFriendTwo() {
		return friendTwo;
	}
	public void setFriendTwo(User friendTwo) {
		this.friendTwo = friendTwo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return ", user with id = "+friendOne+", have a friend with id = "+friendOne+" with status "+status+" ]";
	}
}
