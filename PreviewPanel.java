package uk.ac.cam.jp775.supo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PreviewPanel extends JPanel {

	private int n = 3; // Number of preview images
	private int imgSize = 256;
	private ArrayList<String> images = new ArrayList<String>();
	private String srName;
	
	public PreviewPanel() {
		images.add("C:\\Users\\BourgeoisArab\\Pictures\\fadlesbrekky.jpg");
		images.add("C:\\Users\\BourgeoisArab\\Pictures\\holbrookflipped.jpg");
		images.add("C:\\Users\\BourgeoisArab\\Pictures\\marmite.jpeg");
	}
	
	public void setFilePath(String s) {
		
	}
	
	public void setSubReddit(String name) {
		this.srName = name;
	}

	@Override
	protected void paintComponent(java.awt.Graphics g) {
		int yOffset = 25;
		this.imgSize = Math.min(this.getHeight() - 2 * yOffset, (this.getWidth() - (n - 2) * n * yOffset) / n);
		g.setColor(java.awt.Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(java.awt.Color.BLACK);
		if (images.size() <= 0) {
			g.drawString("No images found", 20, 30);
		} else if (srName != null) {
			g.drawString("SubReddit found: " + srName, 20, 30);
		}
		try {
			ArrayList<BufferedImage> ims = loadImages();
			for (int i = 0; i < ims.size(); i++) {
				BufferedImage image = ims.get(i);
				int w = image.getWidth();
				int h = image.getHeight();
				if (w > h) {
					image = image.getSubimage((w - h) / 2, 0, h, h);
				} else {
					image = image.getSubimage(0, (h - w) / 2, w, w);
				}
				g.drawImage(image.getScaledInstance(imgSize, imgSize, 0), yOffset * (i + 1) + imgSize * i, yOffset, null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ArrayList<BufferedImage> loadImages() throws IOException {
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		for(String i : this.images) {
			images.add(ImageIO.read(new File(i)));
		}
		return images;
	}

	public void display() {
		repaint();
	}
}