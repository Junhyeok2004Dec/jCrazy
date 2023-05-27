package blocks;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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

public class BlockManager implements Data {

	GamePanel gamePanel;
	Gson gson;
	Block[] block;

	WorldGen wgen = new WorldGen();

	Type type = new Type();


	public BlockManager(GamePanel gp) {
		this.gamePanel = gp;

		block = new Block[8];
		getBlockImage();


	}



	@Test
	public void getBlockImage() {




		try {


			block[0] = new Block(0, "돌", new ArrayList<>(Arrays.asList(
					"Stone", "Breakable"
			)));
			block[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/stone.png"));



			block[1] = new Block(1,"벽돌1", type.getTypes());
			block[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/brick1.png"));



			block[2] = new Block(2, "벽돌2", type.getTypes());
			block[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/brick2.png"));


			block[3] = new Block(3, "잔디", type.getTypes());
			block[3].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/grass.png"));


			block[4] = new Block(4, "방호벽", type.getTypes());
			block[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/barrier.png"));

			block[5] = new Block(5, "물1", type.getTypes());
			block[5].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/ocean.png"));



		} catch (IOException e) {
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







	@Test
	public void mapgen(Graphics2D g2d) {


		int width = 14;
		int height = 14;

		if(gamePanel.asdf == 0) {

			wgen.Data("src/main/java/data/map/map.dat");


			 width = wgen.getWidth();
			 height = wgen.getHeight();
		}


			for (String path : mapPath) {

				//block 포지션을 설정하는 것으로 수정
				for (int i = 0; i < height; i++) {

					for (int p = 0; p < width; p++) {

						g2d.drawImage(block[wgen.getData(p, i)].image,


								gamePanel.tileSize * i, gamePanel.tileSize * p, gamePanel.tileSize, gamePanel.tileSize, null);

					}
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
