package com.kasyan.Socialka.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name="users")
public class User {
	
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

	@Column(name = "avatar_id", nullable = true)
	private Integer avatarId;

	@OneToMany(targetEntity=Image.class, fetch=FetchType.LAZY, mappedBy="user")
	private Set<Image> images = new HashSet<>();
	
	@OneToMany(targetEntity=UserRole.class, fetch=FetchType.LAZY, mappedBy="user")
	private Set<UserRole> userRole = new HashSet<>();
	
	@Column(name="enabled")
	//@Type(type="org.hibernate.type.NumericBooleanType")
	private boolean enabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(int avatarId) {
		this.avatarId = avatarId;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
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

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", lastName='" + lastName + '\'' +
				", avatarId=" + avatarId +
				", enabled=" + enabled +
				", userRole=" + userRole +
				'}';
	}
}
