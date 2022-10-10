package Day_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;
import java.nio.file.*;

public class Part_1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Path path = Paths.get("src/Day_1/day_1_input");
		System.out.println("Santa needs to go to floor " + count(path));

	}

	public static long count(Path path) throws FileNotFoundException, IOException {

		long counter = 0, count1 = 0, count2 = 0;
		try (Stream<String> lines1 = Files.lines(path)) {

			count1 = lines1.flatMapToInt(s -> s.chars()).filter(e -> e == '(').count();
		}

		try (Stream<String> lines2 = Files.lines(path)) {

			count2 = lines2.flatMapToInt(s -> s.chars()).filter(e -> e == ')').count();
		}

		counter = count1 - count2;

		return counter;
	}
}