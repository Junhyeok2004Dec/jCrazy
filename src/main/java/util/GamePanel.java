package util;

import entity.player.Player;
import blocks.BlockManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends MainPanel implements Runnable{


	public int asdf = 0;
	//mapgen 일회실행



	public static final int playerInventoryX = 12;
	public static final int playerInventoryY = 3;
	public final int rootTileScale = 16;
	public final int sizeFactor = 3;

	public int tileSize = rootTileScale * sizeFactor;
	public final int maxScreenColumn =  16;
	public final int maxScreenRow = 12;


	public final int screenMultiX = 2;
	public final int screenMultiY = 2;


	public final int maxWorldCol = 60;
	public final int maxWorldRow = 60;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	public int getTileSize() {
		return this.tileSize;
	}

	public final int screenWidth = screenMultiX* tileSize * maxScreenColumn;
	public final int screenHeight = screenMultiY * tileSize * maxScreenRow;


	public final int cameraPosX = 0;
	public final int cameraPosY = 0;


	BlockManager blockManager = new BlockManager(this);

	util.KeyHandler keyHandler = new util.KeyHandler(this);
	Thread gameThread;


	public Player player = new Player(this, keyHandler);
	util.Text text = new util.Text();


	int fps = 240;



	/*


	메인화면 구현


	1. 첫 init 이후 메인화면 draw(기본 화면)
	2. if press key(space) -> 다음 scene으로 넘어감(현 메인화면 zindex 우선순위 하락)
	3. 메인화면의 zindex를 바꾸는 식




	 */


	public GamePanel() {

		super.titlePanel.setVisible(false);
		super.startBtnPanel.setVisible(false);


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

	public void zoomFactor(int var) {

		int tempWorldWidth = tileSize*maxWorldCol;

		tileSize +=var;
		int currentWorldWidth = tileSize*maxWorldRow;

		double multiply = (double) (currentWorldWidth / tempWorldWidth);

		double newPlayerX = player.getWorldX() * multiply;
		double newPlayerY = player.getWorldY() * multiply;

		player.setPos((int) newPlayerX, (int)newPlayerY);


	}
}

