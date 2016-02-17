package com.kasyan.Socialka.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name="small_images")
public class SmallImage {

	@Id
	@GenericGenerator(name = "generator", strategy = "foreign",
			parameters = @Parameter(name = "property", value = "image"))
	@GeneratedValue(generator = "generator")
	@Column(name="id_image")
	private int idImage;

	@Column(name="small_image_value")
	private byte[] smallPhoto;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Image image;

	public int getIdImage() {
		return idImage;
	}
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}
	public byte[] getSmallPhoto() {
		return smallPhoto;
	}
	public void setSmallPhoto(byte[] smallPhoto) {
		this.smallPhoto = smallPhoto;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
}
