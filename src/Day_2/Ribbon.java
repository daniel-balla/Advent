package Day_2;

public class Ribbon {

	public Ribbon() {

	}

	public static int calculateRibbonAmount(Present pr) {

		int a, b, ret;

		if (pr.length <= pr.height && pr.width <= pr.height) {
			a = pr.length;
			b = pr.width;
		} else if (pr.width <= pr.length && pr.height <= pr.length) {
			a = pr.width;
			b = pr.height;
		} else {
			a = pr.length;
			b = pr.height;
		}

		ret = 2 * a + 2 * b + pr.length * pr.width * pr.height;

		return ret;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ribbon) {
			return true;
		}
		return false;
	}
}
