package dev.bonjugi.boottemp.baseball;

import java.util.Objects;

public class Num {

	private int num;

	private static int min = 0;
	private static int max = 9;

	public Num(int num){
		isValid(num);
		this.num = num;
	}

	public static Num of(int num) {
		return new Num(num);
	}

	public static Num random() {
		int ran = (int) (Math.random()*10);
		return of(ran);
	}

	private static boolean isValid(int num){
		if (num < min || num > max) {
			throw new IllegalArgumentException("valid number range is 0~9. arg is : " + num);
		}
		return true;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Num myNumber = (Num) o;
		return num == myNumber.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	@Override
	public String toString() {
		return "MyNumber{" +
				"num=" + num +
				'}';
	}
}
