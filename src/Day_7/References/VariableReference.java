package Day_7.References;

public class VariableReference extends Reference {

	public String name;

	public VariableReference(String s) {
		this.name = s;
	}

	@Override
	public String toString() {
		return name + " " + Integer.toString(signal);
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
