package Day_7.AssignmentOperations.SingleSourceOp;

import java.util.Map;

import Day_7.References.LiteralReference;
import Day_7.References.Reference;
import Day_7.References.VariableReference;

public class Assign extends SingleSourceAssignmentOperation {

	public Assign(Reference secondValue, VariableReference target) {
		this.secondValue = secondValue;
		this.target = target;
	}

	@Override
	public void calculate(Map<String, VariableReference> map) {
		if (secondValue instanceof VariableReference) {
			map.get(((VariableReference) target).name).signal = map.get(((VariableReference) secondValue).name).signal;
		} else {
			map.get(((VariableReference) target).name).signal = secondValue.signal;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Assign)) {
			return false;
		}
		Assign other = (Assign) o;
		return this.target.equals(other.target) && this.secondValue.equals(other.secondValue);
	}

	@Override
	public boolean isExecutable(Map<String, VariableReference> map) {
		if (secondValue instanceof LiteralReference) {
			return true;
		} else if (map.get(((VariableReference) secondValue).name).signal != -1) {
			return true;
		}
		return false;
	}
}