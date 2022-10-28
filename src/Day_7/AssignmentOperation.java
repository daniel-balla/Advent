package Day_7;

public abstract class AssignmentOperation {

	VariableReference target;
	Reference value;
	Reference left;

	abstract void calculate();
	
	public abstract boolean equals(Object o);
	
	abstract boolean isExecutable();
	
}
