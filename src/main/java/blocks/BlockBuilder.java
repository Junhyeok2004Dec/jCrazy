package blocks;

import java.util.ArrayList;

public class BlockBuilder {
	private int id;
	private String name;
	private ArrayList<Type> blockType;

	public BlockBuilder setID (int id) {
		this.id = id;
		return this;
	}

	public BlockBuilder setName (String name) {
		this.name = name;
		return this;
	}

	public BlockBuilder setType (Type type) {
		this.blockType.add(type);
		return this;
	}
}
