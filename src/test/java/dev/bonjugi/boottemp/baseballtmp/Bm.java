package dev.bonjugi.boottemp.baseballtmp;

public class Bm {


	public static ThreeNumbers autoSetup() {
		return new ThreeNumbers();
	}

	public static ThreeNumbers manualSetup(int one, int two, int three) {
		return new ThreeNumbers(one, two, three);
	}
}
