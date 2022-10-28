package Day_7;

public class LSHIFT extends DoubleSourceAssignmentOperation {

	public LSHIFT(VariableReference left, LiteralReference value, VariableReference target) {
		this.left = left;
		this.value = value;
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
		return this.target.equals(other.target) && this.value.equals(other.value) && this.left.equals(other.left);
	}

	@Override
	void calculate() {
		target.signal = left.signal << value.signal;
	}

	@Override
	boolean isExecutable() {
		if (left.signal != -1 && value.signal != -1) {
			return true;
		}
		return false;
	}
}
