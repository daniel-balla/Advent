package Day_7.AssignmentOperations.SingleSourceOp;

import java.util.Map;

import Day_7.References.VariableReference;

public class NOT extends SingleSourceAssignmentOperation {

	public NOT(VariableReference secondValue, VariableReference target) {
		this.secondValue = secondValue;
		this.target = target;
	}

	@Override
	public void calculate(Map<String, VariableReference> map) {
		int a = map.get(((VariableReference) secondValue).name).signal;
		char b = (char) ~a;
		map.get(((VariableReference) target).name).signal = (int) b;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof NOT)) {
			return false;
		}
		NOT other = (NOT) o;
		return this.target.equals(other.target) && this.secondValue.equals(other.secondValue);
	}

	@Override
	public boolean isExecutable(Map<String, VariableReference> map) {
		if (map.get(((VariableReference)secondValue).name).signal != -1) {
			return true;
		}
		return false;
	}
}
