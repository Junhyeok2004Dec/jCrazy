import util.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Application {

	JPanel titlePanel;
	public Container container;
	JFrame jframe;

	public static void main(String[] args) {



	}

	public Application() {

		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jframe.setResizable(false);

		jframe.setTitle("MainCraft");


		GamePanel gamePanel = new GamePanel();
		jframe.add(gamePanel);

		jframe.pack();

		jframe.setLocationRelativeTo(null);

		jframe.setVisible(true);


		gamePanel.startGameThread();
	}
	public void mainScreen() {
		titlePanel = new JPanel();
		container = jframe.getContentPane();

	}
}
