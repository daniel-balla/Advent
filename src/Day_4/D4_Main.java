package Day_4;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class D4_Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		String input = "bgvyzdsv";
		System.out.println(findNumber(input, 5)); // Part 1
		System.out.println(findNumber(input, 6)); // Part 2

	}

	public static String getMD5Hash(String str) throws NoSuchAlgorithmException {

		MessageDigest msg = MessageDigest.getInstance("MD5");
		byte[] hash = msg.digest(str.getBytes(StandardCharsets.UTF_8));

		StringBuilder s = new StringBuilder();
		for (byte b : hash) {
			s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		}
		return s.toString();
	}

	public static boolean checkZeros(String str, int zeros) {

		boolean ret = true;

		for (int i = 0; i < zeros; i++) {
			if (str.charAt(i) != '0')
				ret = false;
		}
		return ret;
	}

	public static int findNumber(String input, int zeros) throws NoSuchAlgorithmException {

		String[] strArr = new String[2];
		strArr[0] = input;
		int a = 1;
		strArr[1] = Integer.toString(a);
		String str = strArr[0] + strArr[1];

		while (checkZeros(getMD5Hash(str), zeros) == false) {
			a++;
			strArr[1] = Integer.toString(a);
			str = strArr[0] + strArr[1];
		}
		return a;
	}
}
