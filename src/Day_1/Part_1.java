package Day_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.nio.file.*;

public class Part_1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Path path = Paths.get("src/Day_1/day_1_input");
		System.out.println("Santa needs to go to floor " + count(path));
		System.out.println("Santa needs to go to floor " + count1(path));
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

	public static long count1(Path path) throws FileNotFoundException, IOException {

		long counter = 0, count1 = 0, count2 = 0;

		byte[] arr = Files.readAllBytes(path);
		String str = new String(arr);
		
		IntStream lines1 = str.chars();
		IntStream lines2 = str.chars();
		
		count1 = lines1.filter(e -> e == '(').count();
		count2 = lines2.filter(e -> e == ')').count();
		
		counter = count1 - count2;

		return counter;
	}
}