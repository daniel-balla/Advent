package Day_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class D2_Part_1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String file = "src/resources/day_2_input";
		System.out.println(
				"The elves should order " + readFileStartCalculationViaBR(file) + " square feet of wrapping paper.");

		Path path = Paths.get("src/resources/day_2_input");
		System.out.println(
				"The elves should order " + readFileStartCalculationViaByte(path) + " square feet of wrapping paper.");

	}

	public static int calculatePaperAmount(Present pr) {

		int side1 = (2 * pr.length * pr.width), side2 = (2 * pr.width * pr.height), side3 = (2 * pr.height * pr.length),
				ret = side1 + side2 + side3;

		if (side1 <= side2 && side1 <= side3) {
			ret += side1 / 2;
		} else if (side2 <= side1 && side2 <= side3) {
			ret += side2 / 2;
		} else
			ret += side3 / 2;

		return ret;
	}

	public static String[] extractNumbers(String str) {

		str = str.replaceAll("\\s", "x");
		str = str.replaceAll("x", " ");
		str = str.replaceAll("  ", " ");

		String[] strArr = str.split(" ");

		return strArr;
	}

	public static int readFileStartCalculationViaBR(String file) throws FileNotFoundException, IOException {

		String str;
		int result = 0;

		try (BufferedReader in = new BufferedReader(new FileReader(file))) {

			while ((str = in.readLine()) != null) {

				try (Scanner a = new Scanner(str)) {
					a.useDelimiter("\\D+");
					int[] arr = new int[3];
					for (int i = 0; i < 3; i++) {
						int sd = a.nextInt();
						arr[i] = sd;
					}
					Present pr = new Present(arr[0], arr[1], arr[2]);
					result += calculatePaperAmount(pr);
				}
			}
		}

		return result;
	}

	public static int readFileStartCalculationViaByte(Path path) throws IOException {

		int result = 0, l, w, h;
		byte[] lines = Files.readAllBytes(path);
		String str = new String(lines);
		String strArr[] = extractNumbers(str);

		for (int i = 0; i < strArr.length - 2; i++) {
			if (strArr[i].matches("[0-9]+")) {

				l = Integer.parseInt(strArr[i]);
				w = Integer.parseInt(strArr[i + 1]);
				h = Integer.parseInt(strArr[i + 2]);

				Present pr = new Present(l, w, h);
				result += calculatePaperAmount(pr);
				i = i + 2;
			} else
				i++;
		}
		return result;

	}
}
