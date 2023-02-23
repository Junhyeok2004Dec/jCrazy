package main.blocks;

import main.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WorldGen implements Data {




	private int width=0, height=0;

	ArrayList<ArrayList<Integer>> layout = new ArrayList<>();

	private String data;
	private String[] splitData;


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<ArrayList<Integer>> getLayout() {
		return layout;
	}

	public String getData() {
		return data;
	}

	public String[] getSplitData() {
		return splitData;
	}



	public void Data(String path) {

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path)))
		{
			while((data =bufferedReader.readLine()) != null) {

				ArrayList<Integer> row = new ArrayList<>();

				splitData = data.trim().split("\\s");
				for(String str : splitData) {

					if(!str.isEmpty()) {
						int id = Integer.parseInt(str);
						row.add(id);
					}
				}
			layout.add(row);


			this.width = layout.get(0).size();
			this.height= layout.size();

			if(data.isEmpty()) {
				continue;
			}

			}


		} catch(IOException e) {
			e.printStackTrace();
		}
	}



	public int getData(int row, int column) {
		return this.layout.get(row).get(column);
	}
}
