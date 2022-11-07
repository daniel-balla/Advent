package Day_7;

import Day_7.AssignmentOperations.AssignmentOperation;
import Day_7.AssignmentOperations.DoubleSorceOp.AND;
import Day_7.AssignmentOperations.DoubleSorceOp.LSHIFT;
import Day_7.AssignmentOperations.DoubleSorceOp.OR;
import Day_7.AssignmentOperations.DoubleSorceOp.RSHIFT;
import Day_7.AssignmentOperations.SingleSourceOp.Assign;
import Day_7.AssignmentOperations.SingleSourceOp.NOT;
import Day_7.References.LiteralReference;
import Day_7.References.Reference;
import Day_7.References.VariableReference;

public class Parser {

	public static AssignmentOperation parse(String[] tokens) {
		AssignmentOperation aO = null;
		if (tokens[0].equals("NOT")) {
			aO = new NOT(new VariableReference(tokens[1]), new VariableReference(tokens[3]));
		} else {
			switch (tokens[1]) {
			case "OR":
				aO = new OR(new VariableReference(tokens[0]), new VariableReference(tokens[2]),
						new VariableReference(tokens[4]));
				break;
			case "LSHIFT":
				aO = new LSHIFT(new VariableReference(tokens[0]), new LiteralReference(tokens[2]),
						new VariableReference(tokens[4]));
				break;
			case "RSHIFT":
				aO = new RSHIFT(new VariableReference(tokens[0]), new LiteralReference(tokens[2]),
						new VariableReference(tokens[4]));
				break;
			case "AND":
				aO = newAnd(tokens);
				break;
			case "->":
				aO = newAssign(tokens);
				break;
			}
		}
		return aO;
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
