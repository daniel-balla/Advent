package Day_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Day_7.AssignmentOperations.AssignmentOperation;
import Day_7.References.VariableReference;

public class D7 {

	public static void main(String[] args) throws IOException {

		String filePath = "src/resources/day_7_input";
		System.out.println(process(filePath).get("a"));

	}

	public static Map<String, VariableReference> process(String filePath) throws IOException {
		List<AssignmentOperation> operations = new LinkedList<>();
		operations = Files.lines(Paths.get(filePath)).map(line -> Parser.parse(Tokenizer.tokenize(line)))
				.collect(Collectors.toList());
		Map<String, VariableReference> q = Memory.remember(operations);
		Interpreter.interpret(operations, q);
		return q;
	}
}
