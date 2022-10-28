package Day_7;

public class VariableReference extends Reference {

	String name;

	public VariableReference(String s) {
		this.name = s;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if(!(o instanceof VariableReference)) {
			return false;
		}
		VariableReference other = (VariableReference) o;
		return this.name.equals(other.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
