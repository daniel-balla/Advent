package Day_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Lexer {

	static Parser parser = new Parser();
	static Tokenizer tokenizer = new Tokenizer();
	static Memory memory = new Memory();

	public static void readLine(String filePath) throws IOException {
		Stream<String> s = Files.lines(Paths.get(filePath));
		s.forEach(line -> {
			try {
				Tokenizer.tokenize(line, parser);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		s.close();

		Stream<String> st = Files.lines(Paths.get(filePath));
		st.forEach(line -> {
			try {
				Memory.remember(Tokenizer.tokenize(line, parser));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		st.close();
	}
}
