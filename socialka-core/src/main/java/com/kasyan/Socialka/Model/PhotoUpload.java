package com.kasyan.Socialka.Model;

import org.springframework.web.multipart.MultipartFile;

public class PhotoUpload {
	
	private MultipartFile multipartFile;

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
}
