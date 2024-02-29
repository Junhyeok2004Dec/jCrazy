package util;

import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {


	JFrame window;
	public Container container;
	JPanel titlePanel, startBtnPanel;
	JLabel titleLabel, startLabel;

	Font titleFont = new Font(Font.SERIF, Font.BOLD, 96);
	Font mediumFont = new Font(Font.SERIF, Font.BOLD, 40);
	Font smallFont = new Font(Font.SERIF, Font.PLAIN, 20);

	JButton startButton;

	TitleScreenHandler titleScreenHandler;


	public void Panel() {



		titlePanel = new JPanel();


		container = window.getContentPane();


		titlePanel.setBounds(225, 100, 780, 220);
		titlePanel.setBackground(Color.red);

		titleLabel = new JLabel(Information.GAME_NAME);
		titleLabel.setForeground(Color.yellow);
		titleLabel.setFont(titleFont);

		startLabel = new JLabel(Information.GAME_VER);
		startLabel.setForeground(Color.yellow);
		startLabel.setFont(mediumFont);



		startBtnPanel = new JPanel();
		startBtnPanel.setBounds(450, 400, 330, 120);
		startBtnPanel.setBackground(Color.red);



		startButton = new JButton("C 받기");
		startButton.setFont(mediumFont);
		startButton.setBackground(Color.red);
		startButton.setForeground(Color.yellow);
		startButton.addActionListener(titleScreenHandler);



		titlePanel.add(titleLabel);
		startBtnPanel.add(startButton);


		container.add(titlePanel);
		container.add(startBtnPanel);


		window.setVisible(true);
	}


	public MainPanel() {

		window = new JFrame();
		window.setSize(1280, 720);


		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.red);

		window.setLayout(null);



		window.setTitle(Information.GAME_NAME);
		titleScreenHandler = new TitleScreenHandler();

		Panel();

	}

	public class TitleScreenHandler implements ActionListener {

		GamePanel gs;

		/**
		 * Invoked when an action occurs.
		 *
		 * @param e the event to be processed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			window.setVisible(false);

			gs = new GamePanel();
			gs.startGameThread();
		}

	}

	public void setFontForAllButtons(Container container, Font font) {
		for (Component component : container.getComponents()) {
			if (component instanceof JButton) {
				((JButton) component).setFont(font);
			} else if (component instanceof Container) {
				setFontForAllButtons((Container) component, font);
			}
		}
	}
}

