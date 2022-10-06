package Day_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Part_1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String file = "src/Day_2/adventofcode_2015_day_2_input";
		System.out.println(work(file));
		System.out.println(rechnen(2, 3, 4));
		System.out.println(rechnen(1, 1, 10));
	}

	public static int rechnen(int l, int w, int h) {

		
		int side1 = (2 * l * w),
			side2 = (2 * w * h),
			side3 = (2 * h * l),
			ret = side1 + side2 + side3;
		
		if(side1 <= side2 && side1 <= side3) {
			ret += side1/2;
		}
		else if(side2 <= side1 && side2 <= side3) {
			ret += side2/2;
		}
		else
			ret += side3/2;

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
