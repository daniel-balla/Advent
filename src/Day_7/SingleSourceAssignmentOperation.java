package Day_7;


public abstract class SingleSourceAssignmentOperation extends AssignmentOperation {

	
	@Override
	public String toString() {
		return value.toString() + " -> " + target.toString();
	}

}
