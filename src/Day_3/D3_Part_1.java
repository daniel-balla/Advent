package Day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D3_Part_1 {

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

		for (int i = 0; i < directions.length; i++) {
			switch (directions[i]) {

			case '^':
				column--;
				intArr[row][column]++;
				if (intArr[row][column] == 1)
					visited++;
				break;
			case 'v':
				column++;
				intArr[row][column]++;
				if (intArr[row][column] == 1)
					visited++;
				break;
			case '<':
				row--;
				intArr[row][column]++;
				if (intArr[row][column] == 1)
					visited++;
				break;
			case '>':
				row++;
				intArr[row][column]++;
				if (intArr[row][column] == 1)
					visited++;
				break;
			}
		}
		return visited;
	}

}
