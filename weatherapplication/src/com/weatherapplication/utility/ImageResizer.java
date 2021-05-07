package com.weatherapplication.utility;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ImageResizer {
	public static ImageIcon resize(ImageIcon image, int width, int height) {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D gd = (Graphics2D) bi.getGraphics();
		gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		gd.drawImage(image.getImage(), 0, 0, width, height, null);
		gd.dispose();
		return new ImageIcon(bi);
	}
}
