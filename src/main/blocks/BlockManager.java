package main.blocks;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BlockManager {

	GamePanel gamePanel;
	Block[] block;

	public BlockManager(GamePanel gp) {
		this.gamePanel = gp;

		block = new Block[256];
		getBlockImage();
	}


	public void getBlockImage() {



		block[0] = new Block();



	}



}
