package dev.bonjugi.boottemp.baseballtmp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {
	/**
	 *
	 사용되는 숫자는 0에서 9까지 서로 다른 숫자이다.
	    - 로봇으로부터는 0~9 까지만 나올수 있다.
	    - 사용자도 0~9 까지만 입력할수 있다
	 두 숫자가 중복되면 경우의 수가 많아져서 그런지 중복 숫자는 잘 사용하지 않는다.
		- 세자리 모두 서로간의 중복이 없어야한다.


	 숫자는 맞지만 위치가 틀렸을 때는 볼.
	    -
	 숫자와 위치가 전부 틀리면 아웃. "틀렸다"는 게 중요하다.
	 숫자와 위치가 전부 맞으면 스트라이크.
	 물론 무엇이 볼이고 스트라이크인지는 알려주지 않는다.

	 */

	@Test
	public void ThreeNumbers_Random_테스트_1000번_반복하면_0부터9까지_적어도한개씩은나온다() {

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			int ran = ThreeNumbers.random();
			list.add(ran);
		}

		Map<Integer, List<Integer>> collect = list.stream().collect(groupingBy(i -> i));
		assertThat(collect).containsKeys(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		assertThat(collect).doesNotContainKeys(-1,10);

	}

	@Test
	public void ThreeNumbers_Random테스트_10000번_반복하면_이론상_1000개씩이어야함_하지만_편차고려하여_800개면_통과(){

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			int ran = ThreeNumbers.random();
			list.add(ran);
		}

		Map<Integer, List<Integer>> collect = list.stream().collect(groupingBy(i -> i));


		for(int key : collect.keySet()){
			List<Integer> value = collect.get(key);
			assertThat(value.size()).isGreaterThan(800);
		}
	}

	@Test
	public void autoSetup_테스트_세자리랜덤_서로다른값(){

		for (int i = 0; i < 100000; i++) {

			ThreeNumbers tn = Bm.autoSetup();
			int one = tn.one();
			int two = tn.two();
			int three = tn.three();

			assertThat(one).isNotEqualTo(two).isNotEqualTo(three);
			assertThat(two).isNotEqualTo(one).isNotEqualTo(three);
			assertThat(three).isNotEqualTo(one).isNotEqualTo(two);

		}

	}

	@Test
	public void manualSetup_테스트_oneTwoThree_적절하게_할당되는지(){
		ThreeNumbers tn = Bm.manualSetup(1,2,3);
		assertThat(tn.one()).isEqualTo(1);
		assertThat(tn.two()).isEqualTo(2);
		assertThat(tn.three()).isEqualTo(3);

		tn = Bm.manualSetup(4,5,6);
		assertThat(tn.one()).isEqualTo(4);
		assertThat(tn.two()).isEqualTo(5);
		assertThat(tn.three()).isEqualTo(6);

	}


	@Test
	public void manualSetup_테스트_숫자와_자리가같으면_스트라이크(){
		ThreeNumbers tn = Bm.manualSetup(1,2,3);
		GameResult result = tn.game(1,2,3);
		assertThat(result.strike()).isEqualTo(3);

		GameResult result1 = tn.game(1,2,5);
		assertThat(result1.strike()).isEqualTo(2);
	}


	@Test
	public void manualSetup_테스트_숫자는맞지만_위치가틀리면_볼(){
		ThreeNumbers tn = Bm.manualSetup(1,2,3);
		GameResult result = tn.game(2, 3, 1);
		assertThat(result.ball()).isEqualTo(3);

		GameResult result2 = tn.game(2, 4, 5);
		assertThat(result2.ball()).isEqualTo(1);
	}


	@Test
	public void autoSetup_테스트_통합테스트(){
		ThreeNumbers threeNumbers = Bm.autoSetup();

		// 다맞춰서 3스트라이크
		GameResult game = threeNumbers.game(threeNumbers.one(), threeNumbers.two(), threeNumbers.three());
		assertThat(game.strike()).isEqualTo(3);
		assertThat(game.ball()).isEqualTo(0);

		// 1자리씩 시프트해서 3볼 만들기
		GameResult game2 = threeNumbers.game(threeNumbers.three(), threeNumbers.one(), threeNumbers.two());
		assertThat(game2.strike()).isEqualTo(0);
		assertThat(game2.ball()).isEqualTo(3);

		// 1스트라이크 2볼
		GameResult game3 = threeNumbers.game(threeNumbers.two(), threeNumbers.one() , threeNumbers.three());
		assertThat(game3.strike()).isEqualTo(1);
		assertThat(game3.ball()).isEqualTo(2);
	}


	@Test
	public void manualSetup_테스트_매뉴얼셋업이_오토셋업과_동일한결과를_만드는지(){
		ThreeNumbers auto = Bm.autoSetup();
		ThreeNumbers manualByAuto = Bm.manualSetup(auto.one(), auto.two(), auto.three());
		assertThat(auto).isEqualTo(manualByAuto);
	}


	@Test
	public void 통테_autoSetup은_216맞추기어려워서_manualTest로셋팅(){
		ThreeNumbers tn = Bm.manualSetup(2,1,6);

		GameResult game1 = tn.game(8, 3, 0);
		assertThat(game1.strike()).isEqualTo(0);
		assertThat(game1.ball()).isEqualTo(0);

		GameResult game2 = tn.game(6,5,9);
		assertThat(game2.strike()).isEqualTo(0);
		assertThat(game2.ball()).isEqualTo(1);


		GameResult game3 = tn.game(2,6,4);
		assertThat(game3.strike()).isEqualTo(1);
		assertThat(game3.ball()).isEqualTo(1);

		GameResult game4 = tn.game(2,1,6);
		assertThat(game4.strike()).isEqualTo(3);
		assertThat(game4.ball()).isEqualTo(0);

	}

}
