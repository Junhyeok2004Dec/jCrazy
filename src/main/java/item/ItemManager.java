package item;

import com.google.gson.Gson;
import util.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

public class ItemManager {


    Gson gson ;


    ArrayList<Item> itemList;

    public ItemManager() {
        itemList = new ArrayList<>();

        getItemImage();


    }

    public void getItemImage() {

        try {
            itemList.set(0, new Item("Default"));
            itemList.get(0).image =
                    ImageIO.read(getClass().getClassLoader().getResourceAsStream(
                            "item/block/barrier.png"
                    )

                    );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            System.out.println("esfsfsfdsf");
        }

        }
    }

