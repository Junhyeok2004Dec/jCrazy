package blocks;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Block<T> {
	private int id;
	private String name;
	private ArrayList<Type> type;
	private String imagePath;




	public transient BufferedImage image;
	// Constructor
	public Block(int id, String name, ArrayList<Type> type, String imagePath) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.imagePath = imagePath;
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

	@Override
	public String toString() {
		return "[" + this.id + "," + this.name + "," + this.type + "," + this.imagePath + "]";
	}

}
