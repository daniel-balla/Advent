package Day_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.nio.file.*;

public class D1_Part_1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Path path = Paths.get("src/resources/day_1_input");
		System.out.println("Santa needs to go to floor " + countFloor(path));
		System.out.println("Santa needs to go to floor " + countFloor1(path));
		System.out.println("Santa needs to go to floor " + countFloor3(path));
	}

	public static long countFloor(Path path) throws FileNotFoundException, IOException {

		long count1, count2;
		try (Stream<String> lines1 = Files.lines(path)) {

			count1 = lines1.flatMapToInt(s -> s.chars()).filter(e -> e == '(').count();
		}

		try (Stream<String> lines2 = Files.lines(path)) {

			count2 = lines2.flatMapToInt(s -> s.chars()).filter(e -> e == ')').count();
		}

		return count1 - count2;
	}

	public static long countFloor1(Path path) throws FileNotFoundException, IOException {

		long count1, count2;

		byte[] arr = Files.readAllBytes(path);
		String str = new String(arr);

		IntStream lines1 = str.chars(), lines2 = str.chars();

		count1 = lines1.filter(e -> e == '(').count();
		count2 = lines2.filter(e -> e == ')').count();

		return count1 - count2;
	}

	public static long countFloor2(Path path) throws FileNotFoundException, IOException {

		long count1, count2;

		byte[] arr = Files.readAllBytes(path);

		IntStream lines1 = IntStream.range(0, arr.length).map(i -> arr[i]),
				lines2 = IntStream.range(0, arr.length).map(i -> arr[i]);

		count1 = lines1.filter(e -> e == '(').count();
		count2 = lines2.filter(e -> e == ')').count();

		return count1 - count2;
	}

	public static long countFloor3(Path path) throws FileNotFoundException, IOException {

		long count = 0;

		byte[] arr = Files.readAllBytes(path);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				count++;
			} else
				count--;
		}
		return count;
	}

}
