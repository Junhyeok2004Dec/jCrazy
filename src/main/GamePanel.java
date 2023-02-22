package main;

import main.Entity.Player;
import main.blocks.Block;
import main.blocks.BlockManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

	public final int rootTileScale = 32;
	public final int sizeFactor = 3;

	public final int tileSize = rootTileScale * sizeFactor;
	public final int maxScreenColumn =  16;
	public final int maxScreenRow = 12;


	public final int screenMultiX = 1;
	public final int screenMultiY = 1;

	public int getTileSize() {
		return this.tileSize;
	}

	public final int screenWidth = screenMultiX* tileSize * maxScreenColumn;
	public final int screenHeight = screenMultiY * tileSize * maxScreenRow;


	BlockManager blockManager = new BlockManager(this);

	KeyHandler keyHandler = new KeyHandler();
	Thread gameThread;


	Player player = new Player(this, keyHandler);

	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;


	int fps = 240;



	public GamePanel() {


		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.blue);

		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}


	@Override
	public void run() {


		double drawInterval = 1E+9/fps; // 0.004166 sec
		double dt = 0;


		long lastTime = System.nanoTime();
		long currentTime;

		long timer = 0;
		long drawCount = 0;



		while(gameThread != null) {



			currentTime = System.nanoTime();

			dt += (currentTime - lastTime) / drawInterval;


			timer += (currentTime - lastTime);

			lastTime = currentTime;

			//Redraw
			if (dt >= 1) {
				update();
				repaint();
				dt--;
				drawCount++;
			}

			if (timer >= 1E+9) {
				System.out.println("FPS\t" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}


	}

	public void update() {

		player.update();


	}


	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		player.draw(g2d);
		blockManager.draw(g2d);


		g2d.dispose();
	}

}

