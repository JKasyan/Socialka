package com.kasyan.Socialka.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="images")
public class Image {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_image",unique=true,nullable=false)
	private int idImage;

	@Column(name="title", nullable=false)
	private String title;

	@Column(name="image_value")
	private byte[] imageValue;

	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="id_user", nullable=false)
	private User user;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "image", cascade = CascadeType.ALL)
	private SmallImage smallImage;

	public int getIdImage() {
		return idImage;
	}
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public byte[] getImageValue() {
		return imageValue;
	}
	public void setImageValue(byte[] imageValue) {
		this.imageValue = imageValue;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public SmallImage getSmallImage() {
		return smallImage;
	}
	public void setSmallImage(SmallImage smallImage) {
		this.smallImage = smallImage;
	}
}
