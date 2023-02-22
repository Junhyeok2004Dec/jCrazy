package main.blocks;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class BlockManager {

	GamePanel gamePanel;
	Block[] block;

	public BlockManager(GamePanel gp) {
		this.gamePanel = gp;

		block = new Block[8];
		getBlockImage();
	}


	public void getBlockImage() {

	try {

		block[0] = new Block();
		block[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));



		block[1] = new Block();
		block[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/brick1.png"));



		block[2] = new Block();
		block[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/brick2.png"));


		block[3] = new Block();
		block[3].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/grass.png"));


		block[4] = new Block();
		block[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/barrier.png"));

	} catch(IOException e) {
		e.printStackTrace();
	}


	}


	public void draw(Graphics2D g2d) {



		for(int i = 0; i < 5; i++)
			g2d.drawImage(block[i].image, 0 + i*gamePanel.tileSize ,0, gamePanel.tileSize, gamePanel.tileSize, null);


		int column = 0;
		int row = 0;

		int x=0;
		int y=0;


		while(column<gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow) {
			g2d.drawImage(block[3].image,x,y,gamePanel.tileSize, gamePanel.tileSize, null);
			column++;

			x+= gamePanel.tileSize;

			if (column == gamePanel.maxScreenColumn) {
				column= 0;
				x=0;

				row++;
				y+=gamePanel.tileSize;

			}
		}

	}



}
