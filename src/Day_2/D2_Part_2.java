package Day_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class D2_Part_2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String file = "src/resources/day_2_input";
		System.out.println("The elves should order " + workBR(file) + " feet of ribbons");
		
		Path path = Paths.get("src/resources/day_2_input");
		System.out.println("The elves should order " + workFrAB(path) + " feet of ribbons");
	}

	public static int rechnen(int l, int w, int h) {

		int a, b, ret;

		if (l <= h && w <= h) {
			a = l;
			b = w;
		} else if (w <= l && h <= l) {
			a = w;
			b = h;
		} else {
			a = l;
			b = h;
		}

		ret = 2 * a + 2 * b + l * w * h;

		return ret;
	}
	
	public static int[] extract(String str) {

		str = str.replaceAll("[^0-9]", " ");
		str = str.replaceAll(" +", " ");

		String[] strArr = str.split(" ");
		int[] numbers = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			numbers[i] = Integer.parseInt(strArr[i]);
		}
		return numbers;
	}

	public static int workBR(String file) throws FileNotFoundException, IOException {

		BufferedReader in = new BufferedReader(new FileReader(file));
		String str;
		int res = 0;

		while ((str = in.readLine()) != null) {
			Scanner a = new Scanner(str);
			a.useDelimiter("\\D+");
			int[] arr = new int[3];
			for (int i = 0; i < 3; i++) {
				int sd = a.nextInt();
				arr[i] = sd;
			}
			res += rechnen(arr[0], arr[1], arr[2]);
			a.close();
		}
		in.close();

		return res;
	}
	
	public static int workFrAB(Path path) throws IOException{
		
		int result = 0;
		byte[] lines = Files.readAllBytes(path);
		String str = new String(lines);
		int[] intArr = extract(str);

		for (int i = 1; i < intArr.length + 1; i++) {
			result += rechnen(intArr[i - 1], intArr[i], intArr[i + 1]);
			i = i + 2;
		}
		return result;

	}

}
