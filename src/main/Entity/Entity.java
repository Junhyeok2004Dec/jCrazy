package main.Entity;

import main.GameObject;
import main.item.Inventory;

import java.util.ArrayList;

public class Entity {

	public int x,y;
	public int speed;
	public int hp;

	public Inventory inventory;

	public Entity() {
		inventory.playerInventory(12, 3);
	}




	public String direction;


	public int SpriteNumber = 1;
	public boolean isIdle = false;


	public int SpriteCount = 0;




}
