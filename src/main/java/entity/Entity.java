package entity;

import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class Entity {


	private int x,y;
	private int speed;
	private int hp;
	private String name;

	private int worldX, worldY;

	public Inventory inventory;

	public Entity() {
	}

	public Entity(String name, int x, int y, int hp) {
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.speed = 1;
		this.name = name;
		this.inventory = new Inventory();
	}




	public String direction;


	public int SpriteNumber = 1;
	public boolean isIdle = false;



	public int SpriteCount = 0;


	public Inventory getInventory() {
		return this.inventory;
	}



	public void setPosition(Vector<Integer> position) {
		this.x = position.get(0);
		this.y = position.get(1);
	}

	public void modX(int var) {
		 this.x += var;
	}

	public void modY(int var) {

		this.y += var;
	}

	public void modHP(int var) {
		this.hp += var;
	}

	public int getHp() {
		return hp;
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

	@Override
	public String toString() {
		return
				"[" + this.name + "," +
						this.x + "," + this.y + ","
						+ this.name + "," + this.speed + "]" ;


	}


}
