package blocks;

import java.util.ArrayList;

public class Type {

	public ArrayList<Object> types = new ArrayList<>();
	public ArrayList<String> materials = new ArrayList<>();



	public void setMaterials() {
		materials.add("Stone");
		materials.add("Wood");
		materials.add("Water");
	}

	public void init() {

		setMaterials();

		types.add("Breakable");
		types.add("Unbreakable");
		types.add("unAccessible");

		types.add(materials);



	}


	public ArrayList<Object> getTypes() {
		return this.types;
	}

	public ArrayList<String> getMaterials() {
		return materials;
	}
}
