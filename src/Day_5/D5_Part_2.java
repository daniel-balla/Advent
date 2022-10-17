package Day_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D5_Part_2 {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("src/resources/day_5_input");
		System.out.println("There are " + checkString(path) + " good strings");

	}

	public static String[] createStringArray(Path path) throws IOException {

		byte[] lines = Files.readAllBytes(path);
		String str = new String(lines);

		str = str.replaceAll("\\s", " ");
		str = str.replaceAll("  ", " ");

		String[] strArr = str.split(" ");

		return strArr;
	}

	public static boolean checkPair(String in) {

		for (int i = 0; i < in.length() - 3; i++) {
			String pair = in.substring(i, i + 2);
			for (int j = i + 2; j < in.length() - 1; j++) {
				String temp = in.substring(j, j + 2);
				if (pair.equals(temp))
					return true;
			}
		}
		return false;
	}

	public static boolean checkRepeats(String str) {

		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) == str.charAt(i + 2)) {
				return true;
			}
		}
		return false;
	}

	public static int checkString(Path path) throws IOException {

		String[] strArr = createStringArray(path);
		int countGood = 0;

		for (int i = 0; i < strArr.length; i++) {
			if (checkRepeats(strArr[i]) && checkPair(strArr[i])) {
				countGood++;
			}
		}
		return countGood;
	}

}
