package item;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import information.ProgramData;
import org.junit.Test;
import util.Attribute;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemGen implements ProgramData  {


	Gson gson;

	public static ArrayList<Item> items;
	Item item;



	public ItemGen()
	{

		items = new ArrayList<>();

		getItemImage();
		item = new Item();


	}

	@Test(expected = IOException.class)
	public void getItemImage() {


		try (BufferedReader reader = new BufferedReader(

			new InputStreamReader(new FileInputStream(itemLoadPath), "UTF-8"))) {
			StringBuilder jsonStringBuilder = new StringBuilder();
			String line;

			while((line = reader.readLine()) != null)
			{
				jsonStringBuilder.append(line);
			}

			gson = new Gson();

			Item[] itemArray = gson.fromJson(jsonStringBuilder.toString(), Item[].class);


			for(Item itemElement: itemArray)
			{


				itemElement.image = (ImageIO.read(
						getClass().getClassLoader().getResourceAsStream(itemElement.getImagePath())
				));


				if (itemElement.getAttribute() != null) {
					List<Attribute> attributes = gson.fromJson(
							gson.toJson(itemElement.getAttribute()),
							new TypeToken<List<Attribute>>() {
							}.getType()
					);
						itemElement.setAttribute(attributes);
					}


				items.add(itemElement);
				}



		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}



}
