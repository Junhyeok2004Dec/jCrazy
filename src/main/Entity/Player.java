package main.Entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.security.Key;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler kh1;



	

	public Player(GamePanel gp, KeyHandler kh1) {


		this.gp = gp;
		this.kh1 = kh1;
		this.init();
	}





	public void init() {


		x = 100;
		y = 100;
		speed = 2;


	}

	public void update() {



		if (KeyHandler.up == true) {

			y -= speed;


		}
		if (KeyHandler.down == true) {
			y += speed;

		}
		if (KeyHandler.right == true) {
			x += speed;
		}
		if (KeyHandler.left == true) {
			x -= speed;
		}



	}

	public void draw(Graphics2D gp) {
		
		GamePanel gp1 = new GamePanel();
    
		gp.setColor(Color.white);
		gp.fillRect(x, y
				, gp1.getTileSize(), gp1.getTileSize());


	}
}
