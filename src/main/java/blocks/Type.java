package blocks;

import java.util.ArrayList;

public class Type {

	public ArrayList<Object> types = new ArrayList<>();
	public ArrayList<String> materials = new ArrayList<>();

	/*
	MATERIALS

	Stone 돌
	Wood 나무
	Water 물



	 */

/*

TYPES

Breakable
UnBreakable


 */


	public void setMaterials() {
	}

	public void init() {

		setMaterials();
		types.add(materials);



	}


	public ArrayList<Object> getTypes() {
		return this.types;
	}

	public ArrayList<String> getMaterials() {
		return materials;
	}
}
