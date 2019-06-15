package dev.bonjugi.boottemp.videoshop;

import java.util.Scanner;

public class VideoMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("비디오 정보들을 입력하시오");

		String video = scanner.nextLine();  // 스포츠 월드컵 100000


		System.out.println("고객의 이름을 입력하세요");    // bonjugi

		String name = scanner.nextLine();


		System.out.println("빌릴 비디오 이름 + 대여기간");     // 월드컵 10

		String rentalInfo = scanner.nextLine();


		System.out.println("출력하시겠습니까?");

		String yn = scanner.nextLine();

		if (yn.equals("Y")) {
			System.out.println(video);
			System.out.println(name);
			System.out.println(rentalInfo);
		} else {
			System.out.println("종료되었습니다.");
		}









	}

	public static void main2(String[] args) {

		String message;
		Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성

		System.out.println("메시지를 입력하세요:");

		message = scan.nextLine();            // 키보드 문자 입력

		System.out.println("입력 메시지: \""+ message + "\"");
		// 입력 문자 출력

		int kilometer;
		double liter, mpg;

		System.out.println("거리(km) 값 정수를 입력하세요 : ");

		kilometer = scan.nextInt();        // 키보드 숫자 정수 입력

		System.out.println("리터 값 를 입력하세요 : ");

		liter = scan.nextDouble();        // 키보드 숫자 Double형 입력

		mpg = kilometer / liter;          // 입력받은 kilometer와 liter 계산

		System.out.println("Kilometer per liter : " + mpg);

	}


}
