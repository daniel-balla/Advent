package Day_7.AssignmentOperations.SingleSourceOp;

import java.util.LinkedList;
import java.util.List;

import Day_7.AssignmentOperations.AssignmentOperation;
import Day_7.References.VariableReference;

public abstract class SingleSourceAssignmentOperation extends AssignmentOperation {

	@Override
	public String toString() {
		return secondValue.toString() + " -> " + target.toString();
	}

	@Override
	public List<VariableReference> getVariableReferences() {
		List<VariableReference> ret = new LinkedList<>();
		if (secondValue instanceof VariableReference) {
			ret.add((VariableReference) secondValue);
		}
		ret.add(target);
		return ret;
	}
}
