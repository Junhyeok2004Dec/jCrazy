package main.Entity;

import main.GamePanel;
import main.KeyHandler;
import main.util.Text;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler kh1;
	PlayerInventory inventory;



	public BufferedImage up1, up2, down1, down2, right1, right2, left1, left2, idle1, idle2, heart, halfheart, bkh1,bkh2,bkh3;

	public String direction;



	public void getPlayerImage() {

		try {
			up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/up_1.png"));
			up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/up_2.png"));
			left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/left_1.png"));
			left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/left_2.png"));
			right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/right_1.png"));
			right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/right_2.png"));
			down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/down_1.png"));
			down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/down_2.png"));
			idle1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_front.png"));
			idle2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player_shift.png"));
			heart = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/heart/heart.png"));
			bkh1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/heart/breakingH_1.png"));
			bkh2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/heart/breakingH_2.png"));
			bkh3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/heart/breakingH_3.png"));
			halfheart = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/heart/heart_half.png"));




		} catch(IOException e) {
			e.printStackTrace();
		}
	}



	

	public Player(GamePanel gp, KeyHandler kh1) {


		this.gp = gp;
		this.kh1 = kh1;
		this.inventory = new PlayerInventory();
		this.init();
		this.setHp(26);

		getPlayerImage();
	}





	public void init() {


		x = 100;
		y = 100;
		speed = 2;


	}

	public int count = 0;

	public void update() {



		if (KeyHandler.up == true) {


			direction = "UP";
			y -= speed;


		}
		if (KeyHandler.down == true) {
			direction = "DOWN";
			y += speed;


		}
		if (KeyHandler.right == true) {

			direction = "RIGHT";

			x += speed;
		}
		if (KeyHandler.left == true) {

			direction = "LEFT";

			x -= speed;
		}


		SpriteCount++;

		count++;

		if(count > 24) {
			if (KeyHandler.subtract== true) {
				this.hp--;
			}
			if (KeyHandler.add == true) {
				this.hp++;
			}

			count = 0;
		}

		if(SpriteCount > 24) {

			System.out.println(this.hp);

			if (KeyHandler.left || KeyHandler.right || KeyHandler.up || KeyHandler.down) {

				isIdle = false;
				if (SpriteNumber == 1) {
					SpriteNumber = 2;
				} else if (SpriteNumber == 2) {
					SpriteNumber = 1;
				}



				SpriteCount = 0;
			}

			if (KeyHandler.suicide) {
				this.setHp(0);

			}
		}






	}
	Text text = new Text();

	public void draw(Graphics2D gp) {
		
		BufferedImage image = null;
		text.setText(String.valueOf(this.hp), 0, this.gp.screenHeight/2);

		switch(direction)

		{
			case "UP":

				if(SpriteNumber == 1) {
					image = up1;
				}
				if(SpriteNumber == 2) {
					image = up2;
				}
				break;


			case "DOWN":
				if(SpriteNumber == 1) {
					image = down1;
				}
				if(SpriteNumber == 2) {
					image = down2;
				}
				break;


			case "LEFT":
				if(SpriteNumber == 1) {
					image = left1;
				}
				if(SpriteNumber == 2) {
					image = left2;
				}
				break;


			case "RIGHT":
				if(SpriteNumber == 1) {
					image = right1;
				}
				if(SpriteNumber == 2) {
					image = right2;
				}
				break;
		}




		if(isIdle) {

			int idlecount = 0;

			if(isIdle) {
				idlecount++;

				if(idlecount > 32) {

					if((image == down2)||(image == down1)) {
						image = idle1;
					}

					if(image == idle1) {
						image = idle2;
					} else if (image == idle2) {
						image = idle1;
					}


				}

			}



		}





		gp.drawImage(image, x, y, this.gp.tileSize, this.gp.tileSize, null);





		//Health 코드 정리예정.
		if(!(this.hp == 0)) {



			for (int i = 0; i < this.hp; i += 2) {
				gp.drawImage(heart, i * this.gp.tileSize / 4,0,this.gp.tileSize / 2, this.gp.tileSize / 2, null);

		}}

		if((this.hp%2) == 1) {
			gp.drawImage(halfheart, this.hp * this.gp.tileSize / 4 - 24,0,this.gp.tileSize / 2, this.gp.tileSize / 2, null);

		}



	}
}
