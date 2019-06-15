package dev.bonjugi.boottemp.baseballtmp;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ThreeNumbers {

	private int one;
	private int two;
	private int three;

	public ThreeNumbers() {
		autoOneTwoThreeSetup();
	}

	public ThreeNumbers(int one, int two, int three) {
		this.one=one;
		this.two=two;
		this.three=three;
	}


	public int one() {
		return one;
	}

	public int two() {
		return two;
	}

	public int three() {
		return three;
	}


	public static int random() {
		return  (int) (Math.random() * 10);
	}


	private void autoOneTwoThreeSetup() {
		Set<Integer> set = new HashSet<>();
		while (set.size() <= 3) {
			set.add(random());
		}
		Integer[] randoms = set.toArray(new Integer[set.size()-1]);
		one = randoms[0];
		two = randoms[1];
		three = randoms[2];
	}

	public GameResult game(int one, int two, int three) {

		int strikeCount = 0;
		int ballCount = 0;

		if (one == this.one) {
			strikeCount ++;
		} else if(one == this.two || one == this.three) {
			ballCount ++;
		}

		if (two == this.two) {
			strikeCount ++;
		} else if(two == this.one || two == this.three) {
			ballCount ++;
		}

		if (three == this.three) {
			strikeCount ++;
		} else if(three == this.one || three == this.two) {
			ballCount ++;
		}

		return new GameResult(strikeCount, ballCount);
	}

	@Override
	public String toString() {
		return "ThreeNumbers{" +
				"one=" + one +
				", two=" + two +
				", three=" + three +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ThreeNumbers that = (ThreeNumbers) o;
		return one == that.one &&
				two == that.two &&
				three == that.three;
	}

	@Override
	public int hashCode() {
		return Objects.hash(one, two, three);
	}
}
