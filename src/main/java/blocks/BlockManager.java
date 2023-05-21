package blocks;


import main.java.util.GamePanel;

import javax.imageio.ImageIO;
import javax.xml.crypto.Data;
import java.awt.*;
import java.io.IOException;

import static information.Data.mapPath;

public class BlockManager implements Data {

	GamePanel gamePanel;
	Block[] block;

	WorldGen wgen = new WorldGen();

	Type type = new Type();


	public BlockManager(GamePanel gp) {
		this.gamePanel = gp;

		block = new Block[8];
		getBlockImage();


	}


	public void getBlockImage() {




		try {


			block[0] = new Block(0, "돌", type.getTypes());
			block[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));



			block[1] = new Block(1,"시멘트벽돌", type.getTypes());
			block[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/brick1.png"));



			block[2] = new Block();
			block[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/brick2.png"));


			block[3] = new Block();
			block[3].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/grass.png"));


			block[4] = new Block();
			block[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/barrier.png"));

			block[5] = new Block();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	public void mapgen(Graphics2D g2d) {


		int width = 14;
		int height = 14;

		if(gamePanel.asdf == 0) {

			wgen.Data("src/main/java/data/map/map.dat");


			 width = wgen.getWidth();
			 height = wgen.getHeight();
		}


			for (String path : mapPath) {



				//block 포지션을 설정하는 것으로 수정
				for (int i = 0; i < height; i++) {

					for (int p = 0; p < width; p++) {

						g2d.drawImage(block[wgen.getData(p, i)].image,


								gamePanel.tileSize * i, gamePanel.tileSize * p, gamePanel.tileSize, gamePanel.tileSize, null);

					}
				}

			}
			gamePanel.asdf++;
		}


	/**
	 * 맵 내 블럭 수동조정
	 * @param g2d
	 */
	public void draw(Graphics2D g2d) {



//		for (int i = 0; i < 5; i++)
//			g2d.drawImage(block[i].image, 0 + i * gamePanel.tileSize, 0, gamePanel.tileSize, gamePanel.tileSize, null);


		int column = 0;
		int row = 0;

		int x = 0;
		int y = 0;











		}





}
