package dev.bonjugi.boottemp.baseball2;

import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {

    // 사용되는 숫자는 0에서 9까지 서로 다른 숫자이다.
    @Test
    public void 숫자_0부터9까지_생성기_테스트(){

        ThreeNumbers threeNumbers = ThreeNumbers.autoSetup();

        for (int i = 0; i < 100000; i++) {

            int amp = i%3;
            switch (amp){
                case 0 :
                    int one = threeNumbers.one();
                    assertThat(one).isBetween(0,9);
                    break;
                case 1 :
                    int two = threeNumbers.two();
                    assertThat(two).isBetween(0,9);
                    break;

                case 2 :
                    int three = threeNumbers.three();
                    assertThat(three).isBetween(0,9);
                    break;
            }
        }
    }

    @Test
    public void 랜덤반복_0부터9까지_한번씩은나와야하는_테스트(){

        List<Integer> randoms1 = new ArrayList<>();
        List<Integer> randoms2 = new ArrayList<>();
        List<Integer> randoms3 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ThreeNumbers threeNumbers = ThreeNumbers.autoSetup();
            randoms1.add(threeNumbers.one());
            randoms2.add(threeNumbers.two());
            randoms3.add(threeNumbers.three());
        }

        Map<Integer, List<Integer>> collect = randoms1.stream().collect(groupingBy(x -> x));
        assertThat(collect).containsKeys(0,1,2,3,4,5,6,7,8,9);
        assertThat(collect).doesNotContainKeys(-2,-1,10,11);

        for(Integer key :  collect.keySet()){
            // 기대치가 1000/10 해서 100이니 넉넉히 편차 30% 예상하자.
            // 70~130 사이에서만 나올것이다.
            assertThat(collect.get(key).size()).isBetween(70,130);
        }


        Map<Integer, List<Integer>> collect2 = randoms1.stream().collect(groupingBy(x -> x));
        assertThat(collect2).containsKeys(0,1,2,3,4,5,6,7,8,9);
        assertThat(collect2).doesNotContainKeys(-2,-1,10,11);

        for(Integer key :  collect2.keySet()){
            // 기대치가 1000/10 해서 100이니 넉넉히 편차 30% 예상하자.
            // 70~130 사이에서만 나올것이다.
            assertThat(collect2.get(key).size()).isBetween(70,130);
        }


        Map<Integer, List<Integer>> collect3 = randoms1.stream().collect(groupingBy(x -> x));
        assertThat(collect3).containsKeys(0,1,2,3,4,5,6,7,8,9);
        assertThat(collect3).doesNotContainKeys(-2,-1,10,11);

        for(Integer key :  collect3.keySet()){
            // 기대치가 1000/10 해서 100이니 넉넉히 편차 30% 예상하자.
            // 70~130 사이에서만 나올것이다.
            assertThat(collect3.get(key).size()).isBetween(70,130);
        }
    }




    @Test
    public void 통합테스트(){
        ThreeNumbers threeNumbers = ThreeNumbers.manualSetup(2,1,6);

        GameResult result = threeNumbers.tryNumbers(8,3,0);
        assertThat(result.strike()).isEqualTo(0);
        assertThat(result.ball()).isEqualTo(0);

        GameResult result2 = threeNumbers.tryNumbers(6,5,9);
        assertThat(result2.strike()).isEqualTo(0);
        assertThat(result2.ball()).isEqualTo(1);

        GameResult result3 = threeNumbers.tryNumbers(2,6,4);
        assertThat(result3.strike()).isEqualTo(1);
        assertThat(result3.ball()).isEqualTo(1);

        GameResult result4 = threeNumbers.tryNumbers(2,1,6);
        assertThat(result4.strike()).isEqualTo(3);
        assertThat(result4.ball()).isEqualTo(0);

    }

}
