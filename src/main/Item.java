package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Item {

	private String name;
	private String lore;
	private ArrayList attribte;
	private HashMap attribute;


	public <K,V> Item(String name, HashMap<K,V> data)
	{
		this.name = name;
		this.lore = "";
		this.attribute = data;
	}








	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLore() {
		return lore;
	}

	public void setLore(String lore) {
		this.lore = lore;
	}

	public ArrayList getAttribte() {
		return attribte;
	}

	public void setAttribte(ArrayList attribte) {
		this.attribte = attribte;
	}

	public HashMap getAttribute() {
		return attribute;
	}

	public void setAttribute(HashMap attribute) {
		this.attribute = attribute;
	}
}
