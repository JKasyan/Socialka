package com.kasyan.Socialka.Utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageResize {
	
	private static final int WIDTH = 150;
	private static final int HEIGHT = 150;
	
	public static BufferedImage resizeImage(BufferedImage original, int type){
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, type);
		Graphics2D g = bi.createGraphics();
		g.drawImage(original, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		return bi;
	}
}
