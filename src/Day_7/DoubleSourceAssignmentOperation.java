package Day_7;

public abstract class DoubleSourceAssignmentOperation extends AssignmentOperation {

	@Override
	public String toString() {
		return left.toString() + " + " + value.toString() + " -> " + target.toString();
	}
}
