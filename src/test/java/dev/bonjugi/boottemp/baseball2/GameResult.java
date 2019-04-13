package dev.bonjugi.boottemp.baseball2;

public class GameResult {

    int strike = 0;
    int ball = 0;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }


    public int ball() {
        return ball;
    }

    public int strike() {
        return strike;
    }
}
