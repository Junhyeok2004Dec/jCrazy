package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {


	public static boolean up, down, right, left, exit, add, subtract, inventory;
	GamePanel gp;


	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	/**
	 * Invoked when a key has been typed.
	 * See the class description for {@link KeyEvent} for a definition of
	 * a key typed event.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Invoked when a key has been pressed.
	 * See the class description for {@link KeyEvent} for a definition of
	 * a key pressed event.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();

		switch (code) {

			case KeyEvent.VK_E:
				inventory = true;
				break;
			case KeyEvent.VK_W:
				up = true;
				break;
			case KeyEvent.VK_A:
				left = true;
				break;
			case KeyEvent.VK_S:
				down = true;
				break;
			case KeyEvent.VK_D:
				right = true;
				break;
			case KeyEvent.VK_ESCAPE:
				exit = true;
				break;
			case KeyEvent.VK_UP:
				add = true;
				break;
			case KeyEvent.VK_DOWN:
				subtract = true;
				break;
			case KeyEvent.VK_OPEN_BRACKET:
				gp.zoomFactor(-1);
				break;
			case KeyEvent.VK_CLOSE_BRACKET:
				gp.zoomFactor(1);
				break;

			default:
				break;
		}
	}

	/**
	 * Invoked when a key has been released.
	 * See the class description for {@link KeyEvent} for a definition of
	 * a key released event.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();

		switch (code) {
			case KeyEvent.VK_E:
				inventory = false;
				break;
			case KeyEvent.VK_W:
				up = false;
				break;
			case KeyEvent.VK_A:
				left = false;
				break;
			case KeyEvent.VK_S:
				down = false;
				break;
			case KeyEvent.VK_D:
				right = false;
				break;
			case KeyEvent.VK_ESCAPE:
				exit = false;
				break;
			case KeyEvent.VK_UP:
				add = false;
				break;
			case KeyEvent.VK_DOWN:
				subtract = false;
				break;

			default:
				break;
		}

	}
}
