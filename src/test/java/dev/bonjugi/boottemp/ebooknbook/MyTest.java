package dev.bonjugi.boottemp.ebooknbook;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {



	/**
	 *
	 * 가격이 있어야 한다.
	 * 제목이 있어야 한다.
	 *
	 * 제목이 같으면 같은책이다.
	 * 가격은 같아도 같은책은 아니다.
	 *
	 * 페이퍼북은 이북으로 변환할수 있어야 한다.
	 * 이북은 페이버북으로 변환할수 없다.
	 *
	 * 이북과 페이퍼북은 같을수 없다.
	 *
	 * 이북은 20% 할인된 가격
	 *
	 */



	@Test
	public void 페이퍼북_제목_테스트_동치성체크(){
		Book paperBook = Book.paperBook("테스트 주도 개발");
		assertThat(paperBook).isEqualTo(Book.paperBook("테스트 주도 개발"));
	}


	@Test
	public void 이북_제목_테스트_동치성체크(){
		Book ebook = Book.ebook("테스트 주도 개발");
		assertThat(ebook).isEqualTo(Book.ebook("테스트 주도 개발"));
	}

	@Test
	public void 페이퍼북을_이북으로_변경(){
		Book paperBook = Book.paperBook("테스트 주도 개발",1000);
		Ebook ebook = paperBook.toEbook();

		// 제목은 같고
		assertThat(paperBook.getTitle()).isEqualTo(ebook.getTitle());
		// 가격은 0.8 배
		assertThat((paperBook.getAmount() * 0.8)).isEqualTo(ebook.getAmount());
		// 동등성은 당연히 다르다.
		assertThat(paperBook).isNotEqualTo(ebook);
	}

	@Test
	public void 페이퍼북과_이북은_같을수없다(){
		Book paperBook = Book.paperBook("테스트 주도 개발", 1000);
		Book ebook = Book.ebook("테스트 주도 개발", 1000);
		assertThat(paperBook).isNotEqualTo(ebook);
	}

	@Test
	public void 이북은_할인된가격(){
		Book ebook = Book.ebook("테스트 주도 개발", 1000);
		assertThat(ebook.getAmount()).isEqualTo(800);
	}

	@Test
	public void 팩토리메소드로_리팩터링(){
		Book paperBook = Book.paperBook("테스트 주도 개발", 1000);
		Book book = Book.paperBook("테스트 주도 개발", 1000);
		assertThat(paperBook).isEqualTo(book);

		Book ebook1 = Book.ebook("테스트 주도 개발", 1000);
		Book ebook2 = Book.ebook("테스트 주도 개발", 1000);

		assertThat(ebook1).isEqualTo(ebook2);
	}


	@Test
	public void 이북을_이북으로_변환불가(){
		Book ebook = Book.ebook("테스트 주도 개발", 1000);
		Ebook toEbook = ebook.toEbook();
		assertThat(ebook).isEqualTo(toEbook);
	}


}
