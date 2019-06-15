package dev.bonjugi.boottemp.baseballtmp;

public class GameResult {

	private int strike = 0;
	private int ball = 0;

	public GameResult(int strikeCount, int ballCount) {
		strike = strikeCount;
		ball = ballCount;
	}

	public int ball() {
		return ball;
	}

	public int strike() {
		return strike;
	}

	@Override
	public String toString() {
		return "GameResult{" +
				"strike=" + strike +
				", ball=" + ball +
				'}';
	}
}
