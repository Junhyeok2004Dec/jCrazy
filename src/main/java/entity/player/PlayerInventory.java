package entity.player;

import item.Item;
import util.GamePanel;
import entity.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerInventory extends Inventory {

	private Item[][] itemsArrays;
	private ArrayList<Item> items;
	public void playerInventory(int width, int height) {


		this.items = new ArrayList<>();


		HashMap<Integer, String> map = new HashMap<>();
		map.put(1,"none");
		for(int i = 0; i < width * height; i++) {
			this.items.add(new Item("air"));
		}
		this.itemsArrays = new Item[width][height];


	}




	/**
	 * 아이템 정렬, 1차원 -> 2차원 정렬기능 구현
	 */
	public void setItemsArrays() {
		int width, height; // playerInventory는 static이고 main.java.util.GamePanel 에 선언

		width = GamePanel.playerInventoryX;
		height = GamePanel.playerInventoryY;

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				this.itemsArrays[j][i] =  this.items.get(i*j);
				System.out.println(j+"줄" + i+"칸" + this.items.get(i*j).toString() + "생성");
			}
		}
	}
}