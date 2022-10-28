package Day_7;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Interpretierer {

	public static Reference startProcess(String filePath, VariableReference a) throws IOException {
		Lexer.readLine(filePath);
		return interpret(Parser.operations, a);
	}

	public static Reference interpret(List<AssignmentOperation> operations, VariableReference a) throws IOException {
		while (operations.size() != 0) {
			for (int i = 0; i < operations.size(); i++) {
				AssignmentOperation aO = operations.get(i);
				operate(operations, aO);
			}
		}
		return Memory.vars.get(a.name);
	}

	public static void newTarget(List<AssignmentOperation> operations, VariableReference t) {

		for (int i = 0; i < operations.size(); i++) {
			AssignmentOperation aO = operations.get(i);
			if (aO.value.equals(t)) {
				aO.value = t;
			} else if (aO.left != null && aO.left.equals(t)) {
				aO.left = t;
			}
		}
	}

	public static void putVar(Map<String, VariableReference> map, VariableReference a) {
		if (map.containsKey(a.name)) {
			map.get(a.name).signal = a.signal;
		} else {
			map.put(a.name, a);
		}
	}

	public static void operate(List<AssignmentOperation> operations, AssignmentOperation a) {
		if (a.isExecutable()) {
			a.calculate();
			putVar(Memory.vars, a.target);
			newTarget(operations, a.target);
			operations.remove(a);
		}
	}
}
