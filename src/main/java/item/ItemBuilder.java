package item;

import blocks.BlockType;

import java.util.ArrayList;

public class ItemBuilder {


	private int id;
	private String name;
	private String lore;

	private int cost;

	private String imagePath;

	private ArrayList<ItemType> attribute;



	//

	public ItemBuilder ID (int id) {
		this.id = id;
		return this;
	}

	public ItemBuilder Image (String path) {
		this.imagePath = imagePath;
		return this;
	}

	public ItemBuilder Name (String name) {
		this.name = name;
		return this;
	}

	public ItemBuilder Type (ItemType type) {
		this.attribute.add(type);
		return this;
	}



	public Item build() {
		return new Item(id, name, lore, attribute, cost);
	}

}
