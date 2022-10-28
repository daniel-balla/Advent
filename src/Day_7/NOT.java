package Day_7;

public class NOT extends SingleSourceAssignmentOperation {

	public NOT(VariableReference value, VariableReference target) {
		this.value = value;
		this.target = target;
	}

	@Override
	void calculate() {
		int a = value.signal;
		char b = (char) ~a;
		target.signal = (int) b;
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
		return this.target.equals(other.target) && this.value.equals(other.value);
	}

	@Override
	boolean isExecutable() {
		if (value.signal != -1) {
			return true;
		}
		return false;
	}
}
