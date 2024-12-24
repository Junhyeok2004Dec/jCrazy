package blocks;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
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
import java.util.List;

import static information.ProgramData.blockLoadPath;

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

        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getBlockImage();


    }

    public void getBlockImage() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(blockLoadPath), "UTF-8"))) {
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }


            gson = new Gson();

            Block[] blockArray = gson.fromJson(jsonStringBuilder.toString(), Block[].class);


            for (Block blockElement : blockArray) {
                block.add(blockElement);
                blockElement.image = (ImageIO.read(
                        getClass().getClassLoader().getResourceAsStream(blockElement.getImagePath())));
            }

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

                int screenX = worldX - gamePanel.player.getWorldX() + gamePanel.player.getScreenX();
                int screenY = worldY - gamePanel.player.getWorldY() + gamePanel.player.getScreenY();


                g2d.drawImage(block.get(wgen.getData(col, Row)).image,
                        screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);


                mapTileNum[col][Row] = wgen.getData(col, Row);

            }


        }
        gamePanel.asdf++;
    }


    /**
     * 맵 내 블럭 수동조정
     *
     * @param g2d
     */
    public void draw(Graphics2D g2d) {

    }

    public Block createObjFromJson(String path) {


        String str = "";
        Block objectBlock = new Block();

        gson = new Gson();


        try {
            java.lang.reflect.Type parseList = new TypeToken<ArrayList<Deserialize>>() {
            }.getType();
            List<Deserialize> objectList = gson.fromJson(new FileReader(path), parseList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectBlock;

    }


}
