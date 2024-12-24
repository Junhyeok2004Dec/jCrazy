package item;

import com.google.gson.Gson;
import util.Attribute;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Item {

	private int id;
	private String name;

	private transient ItemType itemType;

	private String lore;
	private List<Attribute> attribute;
	private int cost;

	private String imagePath;


	public transient ArrayList<Item> itemList;
	public transient BufferedImage image;

	public Item() {

	}

	public Item(String name) {

		this.id = -1;
		this.name = name;
		this.lore = "";
		this.attribute = new ArrayList(Arrays.asList("테스트"));
		this.cost = 1;
	}

	public Item(int id, String name, String lore, ArrayList attribute, int cost)
	{
		this.id = id;
		this.name = name;
		this.lore = lore;
		this.attribute = attribute;
		this.cost = cost;


	}




	public List<Attribute> getAttribute() {
		return attribute;
	}


	public void setAttribute(List<Attribute> attribute) {
		this.attribute = attribute;
	}


	public String getImagePath()
	{
		return this.imagePath;
	}


	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", name='" + name + '\'' +
				", itemType='" + itemType + '\'' +
				", lore='" + lore + '\'' +
				", attribute=" + attribute +
				", cost=" + cost +
				", imagePath='" + imagePath + '\'' +
				'}';
	}
}
