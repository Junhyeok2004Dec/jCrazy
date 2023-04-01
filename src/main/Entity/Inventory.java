package main.Entity;

import main.GamePanel;
import main.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

	private ArrayList<Item> items;

	private int number;

	public Inventory() {
		this.items = new ArrayList<>();
	}

	public void playerInventory(int width, int height) {
		this.items = new ArrayList<>();


		HashMap<Integer, String> map = new HashMap<>();
		map.put(1,"none");
		for(int i = 0; i < width * height; i++) {
			this.items.add(new Item("air", map));
		}



	}

	public void addItem(Item item) {
		this.items.add(item);

	}
}
