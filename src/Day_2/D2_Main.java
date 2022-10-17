package Day_2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D2_Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Paper paper = new Paper();
		Ribbon ribbon = new Ribbon();
		Path path = Paths.get("src/resources/day_2_input");
		System.out.println(
				"The elves should order " + readFileStartCalculation(path, paper) + " square feet of wrapping paper.");

		System.out.println(
				"The elves should order " + readFileStartCalculation(path, ribbon) + " square feet of ribbon.");
	}

	public static String[] extractNumbers(String str) {

		str = str.replaceAll("\\s", "x");
		str = str.replaceAll("x", " ");
		str = str.replaceAll("  ", " ");

		String[] strArr = str.split(" ");

		return strArr;
	}

	public static int readFileStartCalculation(Path path, Object obj) throws IOException {

		int result = 0, l, w, h;
		byte[] lines = Files.readAllBytes(path);
		String str = new String(lines);
		String strArr[] = extractNumbers(str);
		Ribbon r = new Ribbon();

		for (int i = 0; i < strArr.length - 2; i += 3) {
			if (strArr[i].matches("[0-9]+")) {

				l = Integer.parseInt(strArr[i]);
				w = Integer.parseInt(strArr[i + 1]);
				h = Integer.parseInt(strArr[i + 2]);

				Present pr = new Present(l, w, h);
				if (obj.equals(r)) {
					result += Ribbon.calculateRibbonAmount(pr);
				} else {
					result += Paper.calculatePaperAmount(pr);
				}

			} else
				i++;
		}
		return result;

	}
}
