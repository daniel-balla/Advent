package Day_7;

import java.io.IOException;

public class Tokenizer {

	public static String[] tokenize(String line, Parser parser) throws IOException {
		String[] strArr = line.split(" ");
		parser.parse(strArr);
		return strArr;
	}
}
