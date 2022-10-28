package Day_7;

public class RSHIFT extends DoubleSourceAssignmentOperation {

	public RSHIFT(VariableReference left, LiteralReference value, VariableReference target) {
		this.left = left;
		this.value = value;
		this.target = target;
	}

	@Override
	void calculate() {
		target.signal = left.signal >> value.signal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof RSHIFT)) {
			return false;
		}
		RSHIFT other = (RSHIFT) o;
		return this.target.equals(other.target) && this.value.equals(other.value) && this.left.equals(other.left);
	}

	@Override
	boolean isExecutable() {
		if (left.signal != -1 && value.signal != -1) {
			return true;
		}
		return false;
	}
}
