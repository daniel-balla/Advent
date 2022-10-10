package Day_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Part_2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String file = "src/Day_2/adventofcode_2015_day_2_input";
		System.out.println(work(file));
		System.out.println(rechnen(2, 3, 4));
		System.out.println(rechnen(1, 1, 10));
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

	public static int work(String file) throws FileNotFoundException, IOException {

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

}
