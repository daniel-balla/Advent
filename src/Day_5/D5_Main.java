package Day_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D5_Main {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("src/resources/day_5_input");
		System.out.println("There are " + checkStr(path, 1) + " good strings");
		System.out.println("There are " + checkStr(path, 2) + " good strings");

	}

	public static String[] createStringArray(Path path) throws IOException {

		byte[] lines = Files.readAllBytes(path);
		String str = new String(lines);

		str = str.replaceAll("\\s", " ");
		str = str.replaceAll("  ", " ");

		String[] strArr = str.split(" ");

		return strArr;
	}

	public static boolean checkIfBad(String str) {

		if (str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy")) {
			return false;
		}
		return true;
	}

	public static boolean checkVowels(String str) {

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u') {
				count++;
			}
		}
		if (count >= 3) {
			return true;
		}
		return false;
	}

	public static boolean checkPair(String str) {

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkPairDupe(String in) {

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

	public static long checkStr(Path path, int a) throws IOException {

		long ret;

		if (a == 1) {
			ret = Files.lines(path).filter(D5_Main::checkIfBad).filter(D5_Main::checkVowels)
					.filter(D5_Main::checkPair).count();
		} else {
			ret = Files.lines(path).filter(D5_Main::checkPairDupe).filter(D5_Main::checkRepeats).count();
		}

		return ret;

	}

}
