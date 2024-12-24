package entity;

import item.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

	private ArrayList<Item> items;

	private int number;

	public Inventory() {
		this.items = new ArrayList<>();
	}


	public void addItem(Item item) {
		this.items.add(item);

	}
}
