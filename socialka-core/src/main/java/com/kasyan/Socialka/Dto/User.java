package com.kasyan.Socialka.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@Entity
@Table(name="users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user", unique=true, nullable=false)
	private int id;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@OneToMany(targetEntity=SmallImage.class, fetch=FetchType.LAZY, mappedBy="user")
	private List<SmallImage> smallImages = new ArrayList<SmallImage>();
	
	@OneToMany(targetEntity=Image.class, fetch=FetchType.LAZY, mappedBy="user")
	private Set<Image> images = new HashSet<Image>(0);
	
	@OneToMany(targetEntity=UserRole.class, fetch=FetchType.LAZY, mappedBy="user")
	private Set<UserRole> userRole;
	
	@Column(name="enabled", nullable=false, columnDefinition="TINYINT(1)")
	@Type(type="org.hibernate.type.NumericBooleanType")
	private boolean enabled;

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
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Set<Image> getImages() {
		return images;
	}
	public void setImages(Set<Image> images) {
		this.images = images;
	}
	
	public List<SmallImage> getSmallImages() {
		return smallImages;
	}
	public void setSmallImages(List<SmallImage> smallImages) {
		this.smallImages = smallImages;
	}
	@Override
	public String toString() {
		return "[ Id "+id+", email: "+email+", name: "+name+", last Name: "+lastName+", gender "+gender+" ]";
	}
}
