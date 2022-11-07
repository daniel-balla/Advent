package Day_7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Day_7.AssignmentOperations.AssignmentOperation;
import Day_7.References.VariableReference;

public class Memory {


	public static void checkVars(Map<String, VariableReference> vars, List<VariableReference> a) {
		for (VariableReference v : a) {
			if (!(vars.containsKey(v.name))) {
				vars.put(v.name, v);
			}
		}
	}

	public static Map<String, VariableReference> remember(List<AssignmentOperation> operations) {
		Map<String, VariableReference> vars = new HashMap<>();
		for (AssignmentOperation a : operations) {
			checkVars(vars, a.getVariableReferences());
		}
		return vars;
	}
}













