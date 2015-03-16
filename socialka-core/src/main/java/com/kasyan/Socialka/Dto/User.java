package com.kasyan.Socialka.Dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user", unique=true, nullable=false)
	private int id;
	
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}", message="Invalid email address.")
	@Column(name="email", nullable=false)
	private String email;
	
	@Size(min=6, message="Name must be at least 6 characters long.")
	@Column(name="password", nullable=false)
	private String password;
	/*
	@OneToOne(mappedBy="password")
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Password password;
	*/
	
	@Size(min=4, max=20, message="Name must be at between 3 and 20 characters long.")
	@Column(name="name", nullable=false)
	private String name;
	
	@Size(min=4, max=20, message="Last name must be at between 3 and 20 characters long.")
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="birth_day")
	private Calendar dateOfBirth;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_photo", nullable=false)
	private Image photo;

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Image getPhoto() {
		return photo;
	}
	public void setPhoto(Image photo) {
		this.photo = photo;
	}
	/*
	public Password getPassword() {
		return password;
	}
	public void setPassword(Password password) {
		this.password = password;
	}
	*/
	@Override
	public String toString() {
		return "[ "+email+", "+name+", "+lastName+", "+dateOfBirth.get(Calendar.YEAR)+"/"
				+dateOfBirth.get(Calendar.MONTH)+"/"+dateOfBirth.get(Calendar.DATE)+" ]";
	}
}