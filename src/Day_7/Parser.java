package Day_7;

import java.util.LinkedList;
import java.util.List;

public class Parser {

	Lexer lexer;

	static List<AssignmentOperation> operations = new LinkedList<>();

	public AssignmentOperation parse(String[] tokens) {
		AssignmentOperation aO = null;
		VariableReference[] arr;
		if (tokens[0].equals("NOT")) {
			aO = new NOT(new VariableReference(tokens[1]), new VariableReference(tokens[3]));
		} else {
			switch (tokens[1]) {
			case "OR":
				arr = initilize3(tokens);
				aO = new OR(arr[0], arr[1], arr[2]);
				break;
			case "LSHIFT":
				arr = initilize2(tokens);
				aO = new LSHIFT(arr[0], new LiteralReference(tokens[2]), arr[1]);
				break;
			case "RSHIFT":
				arr = initilize2(tokens);
				aO = new RSHIFT(arr[0], new LiteralReference(tokens[2]), arr[1]);
				break;
			case "AND":
				aO = newAnd(tokens);
				break;
			case "->":
				aO = newAssign(tokens);
				break;
			}
		}
		operations.add(aO);
		return aO;
	}

	public static VariableReference[] initilize3(String[] strArr) {
		VariableReference[] d = { new VariableReference(strArr[0]), new VariableReference(strArr[2]),
				new VariableReference(strArr[4]) };
		return d;
	}

	public static VariableReference[] initilize2(String[] strArr) {
		VariableReference[] d = { new VariableReference(strArr[0]), new VariableReference(strArr[4]) };
		return d;
	}

	public static AssignmentOperation newAnd(String[] strArr) {
		Reference c;
		if (Character.isDigit(strArr[0].charAt(0))) {
			c = new LiteralReference(strArr[0]);
		} else {
			c = new VariableReference(strArr[0]);
		}
		AssignmentOperation aO = new AND(c, new VariableReference(strArr[2]), new VariableReference(strArr[4]));
		return aO;
	}

	public static AssignmentOperation newAssign(String[] strArr) {
		Reference c;
		if (Character.isDigit(strArr[0].charAt(0))) {
			c = new LiteralReference(strArr[0]);
		} else {
			c = new VariableReference(strArr[0]);
		}
		AssignmentOperation aO = new Assign(c, new VariableReference(strArr[2]));
		return aO;
	}
}
