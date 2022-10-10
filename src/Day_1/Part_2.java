package Day_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Part_2 {

public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String file = "src/Day_1/day_1_input";
		System.out.println("Santa reaches the basement at step " + count(file));
	
	}
	
	public static int count(String file) throws FileNotFoundException, IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		String str = in.readLine();
		char[] arr = new char[str.length()];
		str.getChars(0, str.length(), arr, 0);
		int counter = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(arr[i] == '(' ) {
				counter++;
			}
			else
				counter--;
				if(counter == -1) {
					counter = i + 1;
					break;
					
				}
		}	
		in.close();
		return counter;
		
	}
}
