package Day_6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D6_Main {

	public static void main(String[] args) throws IOException {

		int[][] intArr = new int[1000][1000];
		boolean[][] booArr = new boolean[1000][1000];
		Path path = Paths.get("src/resources/day_6_input");
		System.out.println(countLights(path, booArr, intArr));

	}

	public static String[] createStringArray(Path path) throws IOException {

		byte[] lines = Files.readAllBytes(path);
		String str = new String(lines);

		str = str.replaceAll("\n", "x");
		str = str.replaceAll("  ", "x");

		String[] strArr = str.split("x");

		return strArr;
	}

	public static int[] extractNumbers(String str) {

		str = str.replaceAll("[^\\d]", " ");
		str = str.trim();
		str = str.replaceAll(" + ", " ");
		String[] strArr = str.split(" ");

		int[] intArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		return intArr;
	}

	public static void toggle(String str, boolean[][] booArr, int[][] intArr) {

		int[] intCords = extractNumbers(str);

		for (int k = intCords[0]; k <= intCords[2]; k++) {
			for (int j = intCords[1]; j <= intCords[3]; j++) {
				booArr[k][j] = !booArr[k][j];
				intArr[k][j] += 2;
			}
		}
	}

	public static void turnOn(String str, boolean[][] booArr, int[][] intArr) {

		int[] intCords = extractNumbers(str);

		for (int k = intCords[0]; k <= intCords[2]; k++) {
			for (int j = intCords[1]; j <= intCords[3]; j++) {
				booArr[k][j] = true;
				intArr[k][j]++;
			}
		}
	}

	public static void turnOff(String str, boolean[][] booArr, int[][] intArr) {

		int[] intCords = extractNumbers(str);

		for (int k = intCords[0]; k <= intCords[2]; k++) {
			for (int j = intCords[1]; j <= intCords[3]; j++) {
				booArr[k][j] = false;
				if (intArr[k][j] > 0) {
					intArr[k][j]--;
				}
			}
		}
	}

	public static Pair<Integer, Integer> countLights(Path path, boolean[][] booArr, int[][] intArr) throws IOException {

		int countLights = 0;
		int countBrightness = 0;
		String[] strArr = createStringArray(path);

		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].contains("toggle")) {
				toggle(strArr[i], booArr, intArr);

			} else if (strArr[i].contains("on")) {
				turnOn(strArr[i], booArr, intArr);

			} else if (strArr[i].contains("off")) {
				turnOff(strArr[i], booArr, intArr);

			}
		}

		for (int x = 0; x < booArr.length; x++) {
			for (int y = 0; y < booArr.length; y++) {
				if (booArr[x][y] == true) {
					countLights++;
				}
				countBrightness += intArr[x][y];
			}
		}
		Pair<Integer, Integer> counts = new Pair<Integer, Integer>(countLights, countBrightness);

		return counts;
	}

}
