package Day_7;

import java.io.IOException;

public class D7 {

	public static void main(String[] args) throws IOException {

		String filePath = "src/resources/day_7_input";
		VariableReference c = new VariableReference("a");
		Reference b = Interpretierer.startProcess(filePath, c);
		System.out.println(b.signal);
	}

}
