package Day_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D1_Part_2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String file = "src/resources/day_1_input";
		System.out.println("Santa reaches the basement at step " + reachBasement1(file));

		Path path = Paths.get("src/resources/day_1_input");
		System.out.println("Santa reaches the basement at step " + reachBasement2(path));

	}

	public static int reachBasement1(String file) throws FileNotFoundException, IOException {

		int counter = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String lines = reader.readLine();

			char[] arr = lines.toCharArray();

			for (int i = 0; i < lines.length(); i++) {

				if (arr[i] == '(') {
					counter++;
				} else {
					counter--;
				}
				if (counter == -1) {
					counter = i + 1;
					break;
				}
			}
		}
		return counter;

	}

	public static int reachBasement2(Path path) throws FileNotFoundException, IOException {

		int counter = 0;
		byte[] lines = Files.readAllBytes(path);

		for (int i = 0; i < lines.length; i++) {
			if (lines[i] == '(') {
				counter++;
			} else {
				counter--;
			}
			if (counter == -1) {
				counter = i + 1;
				break;
			}
		}
		return counter;
	}

}
