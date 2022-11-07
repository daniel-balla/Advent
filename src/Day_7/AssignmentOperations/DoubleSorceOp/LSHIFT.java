package Day_7.AssignmentOperations.DoubleSorceOp;

import java.util.Map;

import Day_7.References.LiteralReference;
import Day_7.References.VariableReference;

public class LSHIFT extends DoubleSourceAssignmentOperation {

	public LSHIFT(VariableReference firstValue, LiteralReference secondValue, VariableReference target) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.target = target;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof LSHIFT)) {
			return false;
		}
		LSHIFT other = (LSHIFT) o;
		return this.target.equals(other.target) && this.secondValue.equals(other.secondValue)
				&& this.firstValue.equals(other.firstValue);
	}

	@Override
	public void calculate(Map<String, VariableReference> map) {
		map.get(((VariableReference) target).name).signal = map
				.get(((VariableReference) firstValue).name).signal << secondValue.signal;
	}

	@Override
	public boolean isExecutable(Map<String, VariableReference> map) {
		if (map.get(((VariableReference) firstValue).name).signal != -1) {
			return true;
		}
		return false;
	}
}
