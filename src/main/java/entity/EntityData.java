package entity;

import item.Item;

import java.util.ArrayList;

public class EntityData {

	private String name;
	private int hp;
	private int xp, level, maxXp;
	private ArrayList<Item> inventory;
	private transient ArrayList<String> entityLore;

	public EntityData() {
		this.name = "";
		this.hp = 1;
		this.xp = 1;
		this.level = 1;
		this.maxXp = 2;
		this.inventory = new ArrayList<>();
		this.entityLore = new ArrayList<>();

	}

	@Override
	public String toString() {
		return "[" + this.name + "," +
				this.hp + "," + this.inventory + "," +
				this.xp + "," + this.level + "," + this.maxXp + "]";
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}
}
