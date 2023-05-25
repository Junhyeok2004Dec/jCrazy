package blocks;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Test;
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


			block[3] = new Block();
			block[3].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/grass.png"));


			block[4] = new Block();
			block[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/barrier.png"));

			block[5] = new Block();
			block[5].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("item/block/barrier.png"));


			String path = "src/main/resources/json/block/blockNew.json";
			try (Writer writer = Files.newBufferedWriter(Path.of(path), StandardCharsets.UTF_8)) {

				gson = new GsonBuilder().setPrettyPrinting().create();

				JsonElement tree = gson.toJsonTree(block[0]);
				gson.toJson(tree, writer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		createObjFromJson("src/main/resources/json/block/block.json");
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
	public void createObjFromJson(String path) {


		String str = "";
		Block objectBlock = null;

		try {
			 objectBlock = gson.fromJson(new FileReader(path), Block.class);
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(objectBlock);

}}
