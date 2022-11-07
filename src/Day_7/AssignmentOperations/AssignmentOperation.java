package Day_7.AssignmentOperations;

import java.util.List;
import java.util.Map;

import Day_7.References.Reference;
import Day_7.References.VariableReference;

public abstract class AssignmentOperation {

	public VariableReference target;
	public Reference secondValue;
	public Reference firstValue;

	public abstract void calculate(Map<String, VariableReference> map);
	
	public abstract boolean equals(Object o);
	
	public abstract boolean isExecutable(Map<String, VariableReference> map);
	
	public abstract List<VariableReference> getVariableReferences();
	
}
