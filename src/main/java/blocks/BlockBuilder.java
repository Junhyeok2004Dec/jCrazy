package blocks;

import java.util.ArrayList;

public class BlockBuilder {
	private int id;
	private String name;
	private String imagePath;

	private ArrayList<BlockType> blockType;

	public BlockBuilder ID (int id) {
		this.id = id;
		return this;
	}

	public BlockBuilder Image (String path) {
		this.imagePath = imagePath;
		return this;
	}

	public BlockBuilder Name (String name) {
		this.name = name;
		return this;
	}

	public BlockBuilder Type (BlockType type) {
		this.blockType.add(type);
		return this;
	}

	public Block build() {
		return new Block(id, name, blockType, imagePath);
	}
}
