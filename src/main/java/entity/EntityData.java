package entity;

import item.Item;

import java.util.ArrayList;

public class EntityData {

	private String name;
	private int hp;
	private int xp, level, maxXp;
	private ArrayList<Item> inventory;

	public EntityData() {
		this.name = "";
		this.hp = 1;
		this.xp = 1;
		this.level = 1;
		this.maxXp = 2;
		this.inventory = new ArrayList<>();

	}

	/**
	 * 1 레벨업
	 */
	public void levelUp() {
		this.level++;
	}

	/**
	 *
	 * @param amount 만큼 레벨업합니다, 음수도 가능합니다. 레벨은 1 이상만 되나(추후 구현예정-매 interval마다 update)
	 *               레벨 마이너스는 가능.
	 */
	public void levelUp(int amount) {
		this.level += amount;
	}

	public void addItems(Item item) {
		this.inventory.add(item);
	}

	public void removeItems(Item item) {
		this.inventory.remove(item);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMaxXp() {
		return maxXp;
	}

	public void setMaxXp(int maxXp) {
		this.maxXp = maxXp;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}
}
