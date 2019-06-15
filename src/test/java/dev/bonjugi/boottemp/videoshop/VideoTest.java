package dev.bonjugi.boottemp.videoshop;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoTest {

	/**
	 * - 고객(Customer)은 이름을 가지고 있다.
	 * - 비디오(Video)는 영화,스포츠,다큐멘타리의 세종류가 있다.
	 * - 각각의 비디오는 독립적인 일일 대여요금과 대여기간(하루단위)을 가지고 있다.
	 * - 고객은 한번에 여러개의 비디오를 대여할 수 있다.
	 * - 출력
	 *     - 총 대여비디오 수
	 *     - 대여정보: 비디오(종류 + 제목 + 가격 + 대여기간)
	 *     - 총대여가격
	 */



	@Test
	public void 고객은_이름을가지고있다_또한_같은고객의이름은_같다(){
		Customer customer = Customer.of("bonjugi");
		assertThat(customer).isEqualTo(Customer.of("bonjugi"));
		assertThat(customer).isNotEqualTo(Customer.of("anotherName"));
	}

	@Test
	public void 비디오는_영화_스포츠_다큐멘타리_세종류가있다(){
		Video video1 = new Video(VideoType.다큐멘타리,"역사속으로",5000);
		assertThat(video1.videoType).isEqualTo(VideoType.다큐멘타리);
		assertThat(video1.videoType).isNotEqualTo(VideoType.스포츠);

		Video video2 = new Video(VideoType.스포츠,"국가대표",5000);
		assertThat(video2.videoType).isNotEqualTo(VideoType.다큐멘타리);
		assertThat(video2.videoType).isEqualTo(VideoType.스포츠);

		Video video3 = new Video(VideoType.영화,"보헤미안",5000);
		assertThat(video3.videoType).isEqualTo(VideoType.영화);
		assertThat(video3.videoType).isNotEqualTo(VideoType.다큐멘타리);
	}




	@Test
	public void 샵은_비디오를_입고시킬수_있다(){

		Video video1 = new Video(VideoType.다큐멘타리,"역사속으로",5000);
		Video video2 = new Video(VideoType.스포츠,"국가대표",5000);
		Video video3 = new Video(VideoType.영화,"보헤미안",5000);


		VideoShop videoShop = new VideoShop();
		videoShop.store(video1);
		videoShop.store(video2);
		videoShop.store(video3);



		List<Video> videos = videoShop.all();
		assertThat(videos).hasSize(3);

		assertThat(videos).contains(video1);
		assertThat(videos).contains(video2);
		assertThat(videos).contains(video3);



	}


}
