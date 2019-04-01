package dev.bonjugi.boottemp.baseball;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Baseball 을 TDD로 만들어 보았음.
 */
public class BaseballTest {

	@Test
	public void testMyNumberEquality(){
		Num number1 = Num.of(1);
		Num number2 = Num.of(1);
		assertThat(number1).isEqualTo(number2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOverMaximum_hasException(){
		Num.of(10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOverMiniimum_hasException(){
		Num.of(-1);
	}


	@Test
	public void testGenerationThreeNumbers(){
		ThreeNum threeNumbers = new ThreeNum(Num.of(1), Num.of(2), Num.of(3));

		Num first = threeNumbers.first();
		Num second = threeNumbers.second();
		Num third = threeNumbers.third();

		assertThat(first).isEqualTo(Num.of(1));
		assertThat(second).isEqualTo(Num.of(2));
		assertThat(third).isEqualTo(Num.of(3));
	}

	@Test
	public void testRandomNumRange_0To9(){
		Set<Num> sets = new HashSet<>();
		for (int i = 0; i < 1000000; i++) {

			Num random = Num.random();
			sets.add(random);
		}

		assertThat(sets).hasSize(10);
		assertThat(sets).contains(Num.of(0));
		assertThat(sets).contains(Num.of(9));
	}

	@Test
	public void testGenerationThreeNumbersDuplicateCheck() throws Exception {

		// autoCreate() 100만번 돌려서 중복없으면 없는걸로
		for (int i = 0; i < 1000000; i++) {

			ThreeNum threeNumbers = ThreeNum.autoCreate();

			Set<Num> collect = Arrays.asList(threeNumbers.first(), threeNumbers.second(), threeNumbers.third())
					.stream()
					.collect(Collectors.toSet());

			assertThat(collect.size()).isEqualTo(3);
		}
	}


	/**
	 * 룰 : https://namu.wiki/w/%EC%88%AB%EC%9E%90%EC%95%BC%EA%B5%AC
	 *
	 * 3개 숫자만 맞으면 볼
	 * 3개 숫자+자리 맞으면 스트라이크
	 *
	 */
	@Test
	public void testStrike(){

		ThreeNum threeNumbers = new ThreeNum(Num.of(1), Num.of(2), Num.of(3));

		// 3st
		MyResult result = threeNumbers.check(Num.of(1), Num.of(2), Num.of(3));
		assertThat(result.getStriceCount()).isEqualTo(3);
		assertThat(result.getBallCount()).isEqualTo(0);


		// 2st
		result = threeNumbers.check(Num.of(1), Num.of(2), Num.of(9));
		assertThat(result.getStriceCount()).isEqualTo(2);
		assertThat(result.getBallCount()).isEqualTo(0);


		// 1st
		result = threeNumbers.check(Num.of(1), Num.of(8), Num.of(9));
		assertThat(result.getStriceCount()).isEqualTo(1);
		assertThat(result.getBallCount()).isEqualTo(0);

	}

	@Test
	public void testBall(){

		ThreeNum threeNumbers = new ThreeNum(Num.of(1), Num.of(2), Num.of(3));

		// 3b
		MyResult result = threeNumbers.check(Num.of(2), Num.of(3), Num.of(1));
		assertThat(result.getStriceCount()).isEqualTo(0);
		assertThat(result.getBallCount()).isEqualTo(3);


		// 2b
		result = threeNumbers.check(Num.of(2), Num.of(1), Num.of(9));
		assertThat(result.getStriceCount()).isEqualTo(0);
		assertThat(result.getBallCount()).isEqualTo(2);


		// 1st
		result = threeNumbers.check(Num.of(2), Num.of(8), Num.of(9));
		assertThat(result.getStriceCount()).isEqualTo(0);
		assertThat(result.getBallCount()).isEqualTo(1);


	}


	/**
	 * 나무위키에 마침 테스트하기 좋은 시나리오 예시가 있어서 퍼왔다. (https://namu.wiki/w/숫자야구)
	 */
	@Test
	public void testBallAndStrike(){

		ThreeNum threeNumbers = new ThreeNum(Num.of(2), Num.of(1), Num.of(6));


		// out
		MyResult result = threeNumbers.check(Num.of(8), Num.of(3), Num.of(0));
		assertThat(result.getStriceCount()).isEqualTo(0);
		assertThat(result.getBallCount()).isEqualTo(0);
		assertThat(result.toString()).contains("OUT");


		// 0st, 1b
		result = threeNumbers.check(Num.of(6), Num.of(5), Num.of(9));
		assertThat(result.getStriceCount()).isEqualTo(0);
		assertThat(result.getBallCount()).isEqualTo(1);
		assertThat(result.toString()).contains("0S, 1B");


		// 1st, 1b
		result = threeNumbers.check(Num.of(2), Num.of(6), Num.of(4));
		assertThat(result.getStriceCount()).isEqualTo(1);
		assertThat(result.getBallCount()).isEqualTo(1);
		assertThat(result.toString()).contains("1S, 1B");

		// 1st, 2b
		result = threeNumbers.check(Num.of(1), Num.of(2), Num.of(6));
		assertThat(result.getStriceCount()).isEqualTo(1);
		assertThat(result.getBallCount()).isEqualTo(2);
		assertThat(result.toString()).contains("1S, 2B");


		// 3st, 0b
		result = threeNumbers.check(Num.of(2), Num.of(1), Num.of(6));
		assertThat(result.getStriceCount()).isEqualTo(3);
		assertThat(result.getBallCount()).isEqualTo(0);
		assertThat(result.toString()).contains("YOU WIN");


	}
}
