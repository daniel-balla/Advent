package Day_2;

public class Paper {

	public Paper() {

	}

	public static int calculatePaperAmount(Present pr) {

		int side1 = (2 * pr.length * pr.width), side2 = (2 * pr.width * pr.height), side3 = (2 * pr.height * pr.length),
				ret = side1 + side2 + side3;

		if (side1 <= side2 && side1 <= side3) {
			ret += side1 / 2;
		} else if (side2 <= side1 && side2 <= side3) {
			ret += side2 / 2;
		} else
			ret += side3 / 2;

		return ret;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Paper) {
			return true;
		}
		return false;
	}
}
