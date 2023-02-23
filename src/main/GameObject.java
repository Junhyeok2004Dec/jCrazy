package main;

import main.blocks.Block;

import javax.imageio.ImageIO;
import java.util.List;

public class GameObject {

	private List<Component> components;
	private int depth;


	public GameObject(String imageURL) {


		//block[0] = new Block();
		//block[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));
	}

	public <T extends Component> void removeComponent(Class<T> componentClass) {
		for (int i=0; i < components.size(); i++) {
			Component c = components.get(i);
			if (componentClass.isAssignableFrom(c.getClass())) {
				components.remove(i);
				return;
			}
		}
	}

	public void addComponent(Component c) {
		this.components.add(c);
	}
}
