package dev.bonjugi.boottemp.baseball;

public class MyResult {

	private int strikeCount;
	private int ballCount;


	public MyResult(int st, int b) {
		strikeCount = st;
		ballCount = b;
	}

	public int getStriceCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	@Override
	public String toString() {

		if (strikeCount == 0 && ballCount == 0) {
			return "OUT";
		} else if(strikeCount == 3) {
			return "YOU WIN";
		} else {
			return strikeCount + "S, " + ballCount+"B";
		}


	}
}
