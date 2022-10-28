package Day_7;

import java.util.HashMap;
import java.util.Map;

public class Memory {

	static Map<String, VariableReference> vars = new HashMap<>();
	public static Map<String, VariableReference> remember(String[] tokens) {
		if (tokens[0].equals("NOT")) {
			checkVars(vars, new VariableReference(tokens[1]), new VariableReference(tokens[3]));
		} else {
			switch (tokens[1]) {
			case "OR":
				checkVars(vars, new VariableReference(tokens[0]), new VariableReference(tokens[2]),
						new VariableReference(tokens[4]));
				break;
			case "LSHIFT":
				checkVars(vars, new VariableReference(tokens[0]), new VariableReference(tokens[4]));
				break;
			case "RSHIFT":
				checkVars(vars, new VariableReference(tokens[0]), new VariableReference(tokens[4]));
				break;
			case "AND":
				if (Character.isDigit(tokens[0].charAt(0))) {
					checkVars(vars, new VariableReference(tokens[2]), new VariableReference(tokens[4]));
				} else {
					checkVars(vars, new VariableReference(tokens[0]), new VariableReference(tokens[2]),
							new VariableReference(tokens[4]));
				}
				break;
			case "->":
				if (Character.isDigit(tokens[0].charAt(0))) {
					checkVars(vars, new VariableReference(tokens[2]));
				} else {
					checkVars(vars, new VariableReference(tokens[0]), new VariableReference(tokens[2]));
				}
				break;
			}
		}
		return vars;
	}

	public static void checkVars(Map<String, VariableReference> vars, VariableReference... a) {
		for (VariableReference v : a) {
			if (!(vars.containsKey(v.name))) {
				vars.put(v.name, v);
			}
		}
	}
}
