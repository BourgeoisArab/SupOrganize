package uk.ac.cam.uni.main.java;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PreviewPanel extends JPanel {

	private GUIDeath container;
	int n = 3; // Number of preview images
	private int imgSize = 256;
	private ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	private String srName;
	
	public PreviewPanel(GUIDeath container) {
		this.container = container;
	}
	
	public void clearPreviewImages() {
		this.images.clear();
	}

	public void setSubReddit(String name) {
		this.srName = name;
	}

	@Override
	protected void paintComponent(java.awt.Graphics g) {
		int yOffset = 25;
		if (images.size() > 0 && n > 0) {
			this.imgSize = Math.min(this.getHeight() - 2 * yOffset, (this.getWidth() - (n - 2) * n * yOffset) / n);
			g.setColor(java.awt.Color.WHITE);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(java.awt.Color.BLACK);
			System.out.println(container.getTextField());
			if (images.size() <= 0 && container.getTextField().length() > 0) {
//					loadImages("");
			}
			for (int i = 0; i < images.size(); i++) {
				BufferedImage image = images.get(i);
				int w = image.getWidth();
				int h = image.getHeight();
				if (w > h) {
					image = image.getSubimage((w - h) / 2, 0, h, h);
				} else {
					image = image.getSubimage(0, (h - w) / 2, w, w);
				}
				g.drawImage(image.getScaledInstance(imgSize, imgSize, 0), yOffset * (i + 1) + imgSize * i, yOffset, null);
			}
		}
		else {
			g.drawString("No images found", 20, 30);
		}
	}
	
	public void loadImages(String path) throws IOException {
		images.clear();
		for(int i = 0; i < n; i++) {
			try {
				images.add(ImageIO.read(new File(path + "image" + i + ".jpg")));
			} catch (IOException e) {
				n = i;
				break;
			}
		}
	}
	
	public void deleteFiles(String path) throws IOException {
		for (int i = 0; i < n; i++) {
			File f = new File(path + "image" + i + ".jpg");
			f.delete();
		}
	}
}