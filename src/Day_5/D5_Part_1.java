package Day_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class D5_Part_1 {

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

	public static boolean checkIfBad(String str) {

		if (str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy")) {
			return true;
		}
		return false;
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

	public static int checkString(Path path) throws IOException {

		String[] strArr = createStringArray(path);
		int countGood = 0;

		for (int i = 0; i < strArr.length; i++) {
			if (checkIfBad(strArr[i])) {
				continue;

			} else if (checkVowels(strArr[i]) && checkPair(strArr[i])) {
				countGood++;
			}
		}
		return countGood++;
	}
	

	public static int checkStr(Path path) throws IOException {

		byte[] lines = Files.readAllBytes(path);
	
		long in = lines.toString().chars().filter(ch -> "aeiou".contains((char)ch+"")).count();
	}

}


























