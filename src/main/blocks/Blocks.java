package main.blocks;

import main.GamePanel;
import main.KeyHandler;

import java.awt.event.KeyListener;

public class Blocks {

	private String name;

	private int x,y;

	private GamePanel gp;
	private KeyHandler keyHandler;



	public Blocks(GamePanel gp, KeyHandler keyHandler) {

		this.gp = gp;
		this.keyHandler = keyHandler;

	}
}
