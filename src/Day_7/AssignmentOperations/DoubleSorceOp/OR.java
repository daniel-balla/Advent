package Day_7.AssignmentOperations.DoubleSorceOp;

import java.util.Map;

import Day_7.References.VariableReference;

public class OR extends DoubleSourceAssignmentOperation {

	public OR(VariableReference firstValue, VariableReference secondValue, VariableReference target) {

		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.target = target;
	}

	@Override
	public void calculate(Map<String, VariableReference> map) {
		map.get(((VariableReference) target).name).signal = map.get(((VariableReference) firstValue).name).signal
				| map.get(((VariableReference) secondValue).name).signal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof OR)) {
			return false;
		}
		OR other = (OR) o;
		return this.target.equals(other.target) && this.secondValue.equals(other.secondValue)
				&& this.firstValue.equals(other.firstValue);
	}

	@Override
	public boolean isExecutable(Map<String, VariableReference> map) {
		if (map.get(((VariableReference) firstValue).name).signal != -1
				&& map.get(((VariableReference) secondValue).name).signal != -1) {
			return true;
		}
		return false;
	}
}
