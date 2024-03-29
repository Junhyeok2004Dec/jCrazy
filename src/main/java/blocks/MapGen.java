package blocks;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import util.Deserialize;
import util.GamePanel;

import javax.imageio.ImageIO;
import javax.xml.crypto.Data;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static information.Data.mapPath;

public class MapGen implements Data {

	GamePanel gamePanel;
	Gson gson;

	ArrayList<Block> block;

	int mapTileNum[][];

	WorldGen wgen = new WorldGen();

	Reader reader;



	public MapGen(GamePanel gp) {
		this.gamePanel = gp;

		block = new ArrayList<>();

		mapTileNum = new int [gamePanel.maxWorldCol][gamePanel.maxWorldRow];
		getBlockImage();




	}

	public void getBlockImage() {


		String loadPath = "src/main/resources/json/block/block.json";



		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(loadPath), "UTF-8"))) {
			StringBuilder jsonStringBuilder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonStringBuilder.append(line);
			}


			gson = new Gson();

			Block[] blockArray = gson.fromJson(jsonStringBuilder.toString(), Block[].class);


			Block lastelement;
			for (Block blockElement : blockArray) {
				block.add(blockElement);
				lastelement = block.stream().reduce((first, second) -> second).orElse(null);

				lastelement.image = (ImageIO.read(
						getClass().getClassLoader().getResourceAsStream(lastelement.getImagePath())));


			}

			} // TODO 여기 부분, JSON 읽고 block(arraylist)에 각 block별로 add할 것. GSON
/*

			block.add(new Block(0, "돌", new ArrayList<>(Arrays.asList(
					"Stone", "Breakable"
			))));
			block.get(0).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));


			block.add(new Block(1, "돌", new ArrayList<>(Arrays.asList(
					"Stone", "Breakable"
			))));
			block.get(1).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));


			block.add(new Block(2, "돌", new ArrayList<>(Arrays.asList(
					"Stone", "Breakable"
			))));
			block.get(2).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));


			block.add(new Block(3, "돌", new ArrayList<>(Arrays.asList(
					"Stone", "Breakable"
			))));
			block.get(3).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));


			block.add(new Block(4, "돌", new ArrayList<>(Arrays.asList(
					"Stone", "Breakable"
			))));
			block.get(4).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));


			block.add(new Block(5, "돌", new ArrayList<>(Arrays.asList(
					"Stone", "Breakable"
			))));
			block.get(5).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));


			block.add(new Block(6, "돌", new ArrayList<>(Arrays.asList(
					"Stone", "Breakable"
			))));
			block.get(6).image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));

*/


		 catch (IOException e) {
			e.printStackTrace();
		}


		String path = "src/main/resources/json/block/blockNew.json";


		try (Writer writer = Files.newBufferedWriter(Path.of(path), StandardCharsets.UTF_8)) {



				gson = new GsonBuilder().setPrettyPrinting().create();

				JsonElement tree = gson.toJsonTree(block);
				gson.toJson(tree, writer);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}






	public void mapgen(Graphics2D g2d) {


		int width = gamePanel.maxWorldCol;
		int height = gamePanel.maxWorldRow;


		int worldposX = 0;
		int worldposY = 0;


		wgen.Data("src/main/resources/world/map/map.dat");



			//block 포지션을 설정하는 것으로 수정
			for (int Row = 0; Row < height; Row++) {

				for (int col = 0; col < width; col++) {


				int tileNum = mapTileNum[col][Row];

				int worldX = col * gamePanel.tileSize;
				int worldY = Row * gamePanel.tileSize;

				int screenX = worldX - gamePanel.player.getWorldX() + gamePanel.player.screenX;
				int screenY = worldY - gamePanel.player.getWorldY() + gamePanel.player.screenY;


					g2d.drawImage(block.get(wgen.getData(col, Row)).image,
							screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);


					mapTileNum[col][Row] = wgen.getData(col,Row);

				}


		}
		gamePanel.asdf++;
	}


	/**
	 * 맵 내 블럭 수동조정
	 * @param g2d
	 */
	public void draw(Graphics2D g2d) {

		}


	@Test
	public Block createObjFromJson(String path) {


		String str = "";
		Block objectBlock = new Block();

		gson =new Gson();


		try {
			java.lang.reflect.Type parseList = new TypeToken<ArrayList<Deserialize>>(){}.getType();
			List<Deserialize> objectList = gson.fromJson(new FileReader(path), parseList);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return objectBlock;

}


}
