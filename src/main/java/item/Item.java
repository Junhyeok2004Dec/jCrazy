package item;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

public class Item {

	private String name;
	private int id;
	private String type;
	private String lore;
	private transient ArrayList attribute;
	private int cost;


	public Item() {

	}

	public Item(String name) {
		this.name = name;
		this.lore = "";
		this.attribute = null;
		this.cost = 1;
	}








}
