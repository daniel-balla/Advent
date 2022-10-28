package Day_7;

public class Assign extends SingleSourceAssignmentOperation {

	public Assign(Reference value, VariableReference target) {
		this.value = value;
		this.target = target;
	}

	@Override
	void calculate() {
		target.signal = value.signal;
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