package Day_7;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import Day_7.AssignmentOperations.AssignmentOperation;
import Day_7.References.VariableReference;

public class Interpreter {

	public static Map<String, VariableReference> interpret(List<AssignmentOperation> operations, Map<String, VariableReference> map) throws IOException {
		while (operations.size() != 0) {
			for (int i = 0; i < operations.size(); i++) {
				AssignmentOperation aO = operations.get(i);
				operate(operations, aO, map);
			}
		}
		return map;
	}

	public static void operate(List<AssignmentOperation> operations, AssignmentOperation a, Map<String, VariableReference> map) {
		if (a.isExecutable(map)) {
			a.calculate(map);
			operations.remove(a);
		}
	}
}
