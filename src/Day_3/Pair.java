package Day_3;

import java.util.Objects;

public class Pair<T, U> {
	public T t;
	public U u;

	public Pair(T t, U u) {
		this.t = t;
		this.u = u;
	}

	public T getT() {
		return t;
	}

	public U getU() {
		return u;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	public void setU(U u) {
		this.u = u;
	}
	

	@Override
	public boolean equals(Object o) {
		if (o instanceof Pair<?, ?>) {
			Pair<?, ?> pair = (Pair<?, ?>) o;
			return t.equals(pair.t) && u.equals(pair.u);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(t, u);
	}
}
