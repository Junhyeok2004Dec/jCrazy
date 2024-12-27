package util;

import window.GamePanel;

import java.awt.*;

public class Text {

	GamePanel gamePanel;


	public String drawText = "으하하123123wr";
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

		g2d.setRenderingHint(RenderingHints
				.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Font f1 = new Font("Dialog", 0, 21);


		g2d.setFont(f1);
		g2d.drawString(drawText, 44, 99);



	}


}
