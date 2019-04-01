package dev.bonjugi.boottemp.baseball;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeNum {

	private Num first;
	private Num second;
	private Num third;

	public ThreeNum(Num arg1, Num arg2, Num arg3) {

		first = arg1;
		second = arg2;
		third = arg3;
	}


	public static ThreeNum autoCreate() {

		Set<Num> duplicateCheckSet = new HashSet<>();
		while (duplicateCheckSet.size() < 3) {
			duplicateCheckSet.add(Num.random());
		}
		List<Num> collect = duplicateCheckSet.stream().collect(Collectors.toList());
		return new ThreeNum(collect.get(0), collect.get(1), collect.get(2));
	}

	public Num first() {
		return first;
	}

	public Num second() {
		return second;
	}

	public Num third() {
		return third;
	}

	@Override
	public String toString() {
		return "ThreeNumbers{" +
				"first=" + first +
				", second=" + second +
				", third=" + third +
				'}';
	}


	// st, b 을 가려내야함.
	public MyResult check(Num arg1, Num arg2, Num arg3) {

		int st = 0;
		int b = 0;

		if(arg1.equals(first)){
			st+=1;
		} else if (arg1.equals(second) || arg1.equals(third)) {
			b+=1;
		}

		if(arg2.equals(second)){
			st+=1;
		} else if (arg2.equals(first) || arg2.equals(third)){
			b+=1;
		}

		if(arg3.equals(third)){
			st+=1;
		} else if (arg3.equals(first) || arg3.equals(second)) {
			b+=1;
		}

		return new MyResult(st,b);
	}
}
