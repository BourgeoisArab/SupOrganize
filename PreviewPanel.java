package uk.ac.cam.jp775.supo;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PreviewPanel extends JPanel {

	private ArrayList<String> images = new ArrayList<String>();

	@Override
	protected void paintComponent(java.awt.Graphics g) {
		g.setColor(java.awt.Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

//		if (mWorld == null) {
//			return;
//		}
//
//		int cellSize;
//		int remainder = 0;
//		if (getWidth() / mWorld.getWidth() > getHeight() / mWorld.getHeight()) {
//			cellSize = getHeight() / mWorld.getHeight();
//			remainder = getHeight() % mWorld.getHeight();
//		} else {
//			cellSize = getWidth() / mWorld.getWidth();
//			remainder = getWidth() % mWorld.getWidth();
//		}
//
//		for (int i = 0; i < mWorld.getWidth(); i++) {
//			for (int j = 0; j < mWorld.getHeight(); j++) {
//				if (mWorld.getCell(i, j)) {
//					g.setColor(Color.BLACK);
//					g.fillRect(i * cellSize + (i < remainder ? i : remainder),
//							j * cellSize + (j < remainder ? j : remainder), cellSize + (i < remainder ? 1 : 0),
//							cellSize + (j < remainder ? 1 : 0));
//				}
//				g.setColor(Color.LIGHT_GRAY);
//				g.drawRect(i * cellSize + (i < remainder ? i : remainder),
//						j * cellSize + (j < remainder ? j : remainder), cellSize + (i < remainder ? 1 : 0),
//						cellSize + (j < remainder ? 1 : 0));
//			}
//		}
//
//		g.setColor(Color.BLACK);
//		g.drawString("Generation : " + mWorld.getGenerationCount(), 10, getHeight() - 15);
	}

	public void display() {
		repaint();
	}
}