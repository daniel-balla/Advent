package Day_6;

public class Pair<T, U> {
	public final T t;
	public final U u;

	public Pair(T t, U u) {
		this.t = t;
		this.u = u;
	}

	@Override
	public String toString() {
		return this.t + " lights are lit with a overall brightness of " + this.u;
	}
}
