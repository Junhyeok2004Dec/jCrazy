package main.blocks;

import main.DefaultObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Block<T> extends DefaultObject {
	private int id;
	private String name;
	private ArrayList<T> type = new ArrayList<>();

	Type type1 = new Type();


	public BufferedImage image;
	// Constructor
	public Block(int id, String name, ArrayList<T> type) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.type1.init();
		this.type.add((T) type1.getTypes());
	}

	public Block() {
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<T> getType() {
		return type;
	}

	public void setType(ArrayList<T> type) {
		this.type = type;
	}


}
