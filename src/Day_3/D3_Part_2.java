package Day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D3_Part_2 {

	public static void main(String[] args) throws IOException {

		int[][] intArr = new int[2500][2500];
		Path path = Paths.get("src/resources/day_3_input");
		System.out.println(navigateGrid(intArr, path) + " houses receive at least one present");

	}

	public static int navigateGrid(int[][] intArr, Path path) throws IOException {

		int visited = 1;
		int row = 1250, column = 1250;
		intArr[row][column] = 1;
		byte[] directions = Files.readAllBytes(path);
		Player santa = new Player(row, column);
		Player robo = new Player(row, column);
		Player player;

		for (int i = 0; i < directions.length; i++) {
			if (i % 2 == 0) {
				player = santa;
			} else
				player = robo;

			switch (directions[i]) {

			case '^':
				player.column--;
				intArr[player.row][player.column]++;
				if (intArr[player.row][player.column] == 1)
					visited++;
				break;
			case 'v':
				player.column++;
				intArr[player.row][player.column]++;
				if (intArr[player.row][player.column] == 1)
					visited++;
				break;
			case '<':
				player.row--;
				intArr[player.row][player.column]++;
				if (intArr[player.row][player.column] == 1)
					visited++;
				break;
			case '>':
				player.row++;
				intArr[player.row][player.column]++;
				if (intArr[player.row][player.column] == 1)
					visited++;
				break;
			}

		}
		return visited;
	}
}
