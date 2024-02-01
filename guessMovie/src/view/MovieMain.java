package view;

import java.util.Scanner;

public class MovieMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 입력도구 불러오기
				
		System.out.println("메인입니다");
		
		while (true) {
			System.out.println("영화 제목 맞추기 게임");
			System.out.println("1.회원가입 2.로그인 3.싱글게임 4.연습게임 5.랭킹조회 6.회원 정보 수정 7.회원탈퇴 8.게임종료");
			
			int choice = sc.nextInt();
			if(choice == 8) {
				System.out.println("게임 종료");
				break;
			}else if(choice == 1) {
				
			}
		}
	}

}
