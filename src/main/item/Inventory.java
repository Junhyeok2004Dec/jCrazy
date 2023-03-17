package main.item;

import main.GamePanel;

import java.util.ArrayList;

public class Inventory {

	private ArrayList<Item> items;
	private ArrayList<ArrayList<Item>> itemsArrays;

	private int number;


	public void playerInventory(int width, int height) {
		this.items = new ArrayList<>();
		this.itemsArrays = new ArrayList<>();
	}

	public void addItem(Item item) {
		this.items.add(item);

	}


	/**
	 * 아이템 정렬, 1차원 -> 2차원 정렬기능 구현
	 */
	public void setItemsArrays() {
		int width, height; // playerInventory는 static이고 GamePanel 에 선언

		width = GamePanel.playerInventoryX;
		height = GamePanel.playerInventoryY;

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				this.itemsArrays.get(i).set(j, this.items.get(i*j));
				System.out.println(i+"줄" + j+"칸" + this.items.get(i*j).toString() + "생성");
			}
		}
	}
}
