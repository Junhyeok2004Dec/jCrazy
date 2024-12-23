package entity;

import util.Component;
import util.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Vector;




public class Entity {


	private int x,y, speed, hp;

	private String name;
	private EntityData entityData;
	private int worldX, worldY;
	protected int screenX, screenY;

	private EntityData entitydata;

	private GamePanel gp;



	public Inventory inventory;



	public Entity(GamePanel gp) {

		this.gp = gp;
		this.screenX = (gp.screenWidth - gp.tileSize)/2;
		this.screenY = (gp.screenHeight - gp.tileSize)/2;
	}



	public Entity(String name, int x, int y, int hp) {
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.speed = 1;
		this.name = name;
		this.inventory = new Inventory();
		this.entitydata = new EntityData();


		this.screenX = (gp.screenWidth - gp.tileSize)/2;
		this.screenY = (gp.screenHeight - gp.tileSize)/2;
	}




	public String direction;


	public int SpriteNumber = 1;
	public boolean isIdle = false;



	public int SpriteCount = 0;


	public Inventory getInventory() {
		return this.inventory;
	}





	public void modX(int var) {
		 //this.x += var;
		 modWorldPosition(var, 0);
	}

	public void modY(int var) {

		//this.y += var;
		modWorldPosition(0, var);
	}



	public void modHP(int var) {
		this.hp += var;
	}



	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void draw(Graphics2D g) {



	}

	public int getSpeed() {
		return speed;
	}


	public void modWorldPosition(int x, int y) {
		this.worldX += x;
		this.worldY += y;
	}

	public int getScreenX() {
		return screenX;
	}

	public int getScreenY() {
		return screenY;
	}

	public int getWorldX() {
		return this.worldX;
	}

	public int getWorldY() {
		return this.worldY;
	}

	public int getHP() {
		return this.hp;
	}


	@Override
	public String toString() {
		return
				"[" + this.name + "," +
						this.x + "," + this.y + ","
						+ this.name + "," + this.speed + "]" ;

	}
}
