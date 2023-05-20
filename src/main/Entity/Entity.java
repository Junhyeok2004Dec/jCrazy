package main.Entity;

import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class Entity {

	public int x,y;
	public int speed;
	public int hp;

	public Inventory inventory;

	public Entity() {
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

	public Vector<Integer> getPos() {
		return new Vector<>(Arrays.asList(this.x, this.y));
	}

	public void setInfo(Vector<Integer> info) {
		this.hp = info.get(0);
		this.speed = info.get(1);
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setSpriteNumber(int spriteNumber) {
		SpriteNumber = spriteNumber;
	}

	public void setIdle(boolean idle) {
		isIdle = idle;
	}

	public void setSpriteCount(int spriteCount) {
		SpriteCount = spriteCount;
	}


	public void draw(Graphics2D g) {



	}
}
