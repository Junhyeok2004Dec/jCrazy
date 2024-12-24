package item;

import blocks.BlockType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PotionBuilder extends ItemBuilder {


	//potion
	private float duration;
	private int amount;
	private PotionType potionType;

	private int id;
	private String name;
	private String lore;

	private int cost;

	private String imagePath;



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

	public ItemBuilder Lore (String lore) {
		this.lore = lore;
		return this;
	}





	public Item build() {
		return new Potion(id, name, lore, new ArrayList<>(Arrays.asList(potionType)), cost, amount, duration);
	}

}
