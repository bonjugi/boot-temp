package dev.bonjugi.tddbestudy.mytdd;

public class ThreeNumbers {

    private int one;
    private int two;
    private int three;

    public ThreeNumbers(Integer one, Integer two, Integer three) {
        this.one=one;
        this.two = two;
        this.three = three;
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


    public static ThreeNumbers autoSetup() {
        return new ThreeNumbers(randomZero2Nine(), randomZero2Nine(), randomZero2Nine());
    }

    public static ThreeNumbers manualSetup(int one, int two, int three) {
        return new ThreeNumbers(one,two,three);
    }

    public GameResult tryNumbers(int try1, int try2, int try3) {

        int strike = 0;
        int ball = 0;

        if (try1 == one) {
            strike++;
        } else if (try1 == two || try1 == three) {
            ball++;
        }

        if (try2 == two) {
            strike++;
        } else if (try2 == one || try2 == three) {
            ball++;
        }

        if (try3 == three) {
            strike++;
        } else if (try3 == one || try3 == two) {
            ball++;
        }
        return new GameResult(strike,ball);
    }


    private static Integer randomZero2Nine() {
        return (int) (Math.random() * 10);
    }

}
