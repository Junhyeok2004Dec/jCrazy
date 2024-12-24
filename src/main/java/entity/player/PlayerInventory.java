package entity.player;

import item.Item;
import item.ItemGen;
import util.GamePanel;
import entity.Inventory;

import java.awt.*;
import java.util.ArrayList;

import static util.GamePanel.playerInventoryX;
import static util.GamePanel.playerInventoryY;

public class PlayerInventory extends Inventory {

	private Item[][] itemsArrays;

	private static final int inventoryTileSize = 32;
	private boolean open;

	public PlayerInventory() {

		open = false;

		this.itemsArrays = new Item[playerInventoryX][GamePanel.playerInventoryY];

		//setItemsArrays();
	}


	private int x, y; // draw x, y position

	public void draw(Graphics2D gp) {

		if(this.open){
			x = 0; y = 0;
			for(Item item : ItemGen.items) {

				gp.drawImage(item.image, x * inventoryTileSize , y*inventoryTileSize, inventoryTileSize, inventoryTileSize, null);
				x++;

				if(x > playerInventoryX) {
					y++;
					x=0;
				}


			}
		}
	}


	public void inventoryOpen() {
		this.open = true;
	}

	public void inventoryClose() {
		this.open = false;
	}

	/**
	 * 아이템 정렬, 1차원 -> 2차원 정렬기능 구현
	 * 	public void setItemsArrays() {
	 * 		int width, height;
	 *
	 * 		width = GamePanel.playerInventoryX;
	 * 		height = GamePanel.playerInventoryY;
	 *
	 * 		for(int i = 0; i < height; i++) {
	 * 			for(int j = 0; j < width; j++) {
	 * 				this.itemsArrays[i][j] =  item.itemList.get(i*height + j);
	 * 				System.out.println(i+"줄" + j+"칸" + item.itemList.get(i*height + j).toString() + "생성");
	 * 			            }        * 		}
	 * 	}
	 */

}