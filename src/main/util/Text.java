package main.util;

import main.GamePanel;

import java.awt.*;

public class Text {

	GamePanel gamePanel;


	public String drawText = "";
	int x,y;

	public void setText(String text) {
		setText(text, 0, 0);
	}


	public void setText(String text, int x, int y) {
		this.x = x;
		this.y = y;
		this.drawText = text;

	}


	public void draw(Graphics2D g2d) {

		g2d.drawString(drawText, x, y);
	}


}
