package com.kasyan.Socialka.Servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kasyan.Socialka.Dao.UserDao;
import com.kasyan.Socialka.DaoImpl.UserDaoImpl;
import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.Impl.UserDaoServiceImpl;

public class Avatar extends HttpServlet {

	private UserDaoServiceImpl service;
	private final Logger logger = Logger.getLogger(Avatar.class.getName());

	public Avatar() {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("get request...");
		service = new UserDaoServiceImpl();
		UserDao userDao = new UserDaoImpl();
		service.setUserDao(userDao);
		int id = Integer.valueOf(req.getParameter("id"));
		logger.debug("Id of object: "+id);
		User user = service.getById(id);
		Image image = user.getPhoto();
		Blob blob = image.getPhoto();
		byte[] bytes = null;
		
		try {
			int length = (int) blob.length();
			logger.debug("Length: "+length);
			bytes = blob.getBytes(1, length);
			blob.free();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		OutputStream outputStream = resp.getOutputStream();
		resp.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		outputStream.write(bytes);
		outputStream.flush();
		outputStream.close();
	}
}
