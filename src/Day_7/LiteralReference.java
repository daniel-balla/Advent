package Day_7;

public class LiteralReference extends Reference {

	
	public LiteralReference(int i) {
		this.signal = i;
	}
	
	public LiteralReference(String s) {
		this.signal = Integer.valueOf(s);
	}

	@Override
	public String toString() {
		return String.valueOf(signal);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if(!(o instanceof LiteralReference)) {
			return false;
		}
		if(this.equals(null)||o.equals(null)) {
			return false;
		}
		LiteralReference other = (LiteralReference) o;
		return this.signal == other.signal;
	}

}
