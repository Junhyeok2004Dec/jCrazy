package util;

import entity.Player;
import blocks.BlockManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{


	public int asdf = 0;
	//mapgen 일회실행



	public static final int playerInventoryX = 12;
	public static final int playerInventoryY = 3;
	public final int rootTileScale = 16;
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


	public final int cameraPosX = 0;
	public final int cameraPosY = 0;


	BlockManager blockManager = new BlockManager(this);

	util.KeyHandler keyHandler = new util.KeyHandler();
	Thread gameThread;


	Player player = new Player(this, keyHandler);
	util.Text text = new util.Text();


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
		blockManager.draw(g2d);
		blockManager.mapgen(g2d);
		player.draw(g2d);
		text.draw(g2d);


		g2d.dispose();
	}

}

