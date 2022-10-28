package Day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class D3 {

	public static void main(String[] args) throws IOException {

		Map<Pair<Integer, Integer>, Integer> field1 = new HashMap<Pair<Integer, Integer>, Integer>();
		Map<Pair<Integer, Integer>, Integer> field2 = new HashMap<Pair<Integer, Integer>, Integer>();
		Path path = Paths.get("src/resources/day_3_input");
		System.out.println(navigateGrid(path, 1, field1) + " houses receive at least one present (only Santa)");
		System.out.println(navigateGrid(path, 2, field2) + " houses receive at least one present (Santa and Robo)");
	}

	public static void checkCord(Pair<Integer, Integer> cord, Map<Pair<Integer, Integer>, Integer> c) {

		if (!c.containsKey(cord)) {
			c.put(cord, 1);
		} else {
			c.replace(cord, c.get(cord) + 1);
		}
	}

	public static int navigateGrid(Path path, int playerCount, Map<Pair<Integer, Integer>, Integer> field)
			throws IOException {

		int row = 1250, column = 1250;
		int visited = 1;
		byte[] arr = Files.readAllBytes(path);
		Pair<Integer, Integer> cords = new Pair<Integer, Integer>(row, column);
		field.put(cords, 1);
		Player santa = new Player(cords);
		Player robo = new Player(cords);
		Player player = new Player(cords);

		for (int i = 0; i < arr.length; i++) {
			if (playerCount == 2) {
				if (i % 2 == 0) {
					player = santa;
				} else {
					player = robo;
				}
			} else 
			switch (arr[i]) {

			case '^':
				column = player.cords.getU() - 1;
				row = player.cords.getT();
				player.cords = new Pair<Integer, Integer>(row, column);
				checkCord(player.cords, field);
				if (field.get(player.cords) == 1) {
					visited++;
				}
				break;
			case 'v':
				column = player.cords.getU() + 1;
				row = player.cords.getT();
				player.cords = new Pair<Integer, Integer>(row, column);
				checkCord(player.cords, field);
				if (field.get(player.cords) == 1) {
					visited++;
				}
				break;
			case '<':
				row = player.cords.getT() - 1;
				column = player.cords.getU();
				player.cords = new Pair<Integer, Integer>(row, column);
				checkCord(player.cords, field);
				if (field.get(player.cords) == 1) {
					visited++;
				}
				break;
			case '>':
				row = player.cords.getT() + 1;
				column = player.cords.getU();
				player.cords = new Pair<Integer, Integer>(row, column);
				checkCord(player.cords, field);
				if (field.get(player.cords) == 1) {
					visited++;
				}
				break;
			}
		}
		return visited;
	}
}
