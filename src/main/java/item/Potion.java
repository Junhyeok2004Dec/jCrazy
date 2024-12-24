package item;

import java.util.ArrayList;

public class Potion extends Item{


	private Item item;
	private int amount;
	private float duration;


	public Potion(int id, String name, String lore, ArrayList potionType, int cost, int amount, float duration)
	{
		super(id, name, lore, potionType, cost);
		this.amount = amount;
		this.duration = duration;
	}





}
