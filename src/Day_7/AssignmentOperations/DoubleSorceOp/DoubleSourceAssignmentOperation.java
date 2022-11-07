package Day_7.AssignmentOperations.DoubleSorceOp;

import java.util.LinkedList;
import java.util.List;

import Day_7.AssignmentOperations.AssignmentOperation;
import Day_7.References.VariableReference;

public abstract class DoubleSourceAssignmentOperation extends AssignmentOperation {

	@Override
	public String toString() {
		return secondValue.toString() + " + " + secondValue.toString() + " -> " + target.toString();
	}

	@Override
	public List<VariableReference> getVariableReferences() {
		List<VariableReference> ret = new LinkedList<>();
		if (firstValue instanceof VariableReference) {
			ret.add((VariableReference) firstValue);
		}
		if (secondValue instanceof VariableReference) {
			ret.add((VariableReference) secondValue);
		}
		ret.add(target);
		return ret;
	}
}
