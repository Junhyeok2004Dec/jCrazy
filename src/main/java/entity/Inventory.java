package entity;

import item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Inventory {

	private ArrayList<Item> items;

	private int number;

	public Inventory() {
		this.items = new ArrayList<>();
	}

	public Item getItemfromID(int id) {


		for(Item item : items) {

			if(item.getId() == id) {
				return item;
			}
		}

		throw new NoSuchElementException();
	}


	public Item getItem(int index) {
		return this.items.get(index);
	}

	public void addItem(Item item) {
		this.items.add(item);

	}
}
