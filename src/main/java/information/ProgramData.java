package information;

import java.util.ArrayList;
import java.util.Arrays;

public interface ProgramData {


	ArrayList<String> block = new ArrayList<>(Arrays.asList("stone", "grass", "brick1", "brick2", "barrier"));
	//json 파일 관련 추후 설정 예정
	int blockCount = block.size();


	String[] mapPath = {"res/world/map.dat", "res/world/map.dat"};
	String blockLoadPath =  "src/main/resources/json/block/block.json";
	String itemLoadPath = "src/main/resources/json/item/item.json";
	String weaponLoadPath = "src/main/resources/json/item/weapon.json";

}
