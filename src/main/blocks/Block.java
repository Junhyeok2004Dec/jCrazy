package main.blocks;

import main.GamePanel;
import main.KeyHandler;

import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Block {

	public BufferedImage image;
	public Boolean isCollision = false;


}


/*

		while (column < gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow) {
			g2d.drawImage(block[3].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
			column++;

			x += gamePanel.tileSize;

			if (column == gamePanel.maxScreenColumn) {
				column = 0;
				x = 0;

				row++;
				y += gamePanel.tileSize;

			}
		}
 */