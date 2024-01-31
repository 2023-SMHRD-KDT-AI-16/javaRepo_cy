package view;


import java.util.Scanner;
import java.util.ArrayList;

import model.DatabaseDAO;
import model.LoginDTO;


public class MovieMain {

	// 연습게임

	private static final char[] Remaining_Number = null;

	public static void main(String[] args) {
		// 게임을 다시 할 것인지 물어봄
		while (playGame()) {

		}

		// 터치를 전달 .

		Scanner sc = new Scanner(System.in);

		DatabaseDAO dbdao = new DatabaseDAO();

		while (true) {
			System.out.println("==========회원관리 프로그램==========");
			System.out.println("1.회원 가입");
			System.out.println("2.비밀 번호 수정");
			System.out.println("3.회원정보 삭제");
			System.out.println("4.전체 회원 조회");
			System.out.println("5.프로그램 종료");

			int choice = sc.nextInt();

			if (choice == 5) {
				System.out.println("프로그램 종료");
				break;

			} else if (choice == 1) {
				System.out.println("회원가입 페이지 입니다.");

				System.out.print("id를 입력하세요 :");
				String join_id = sc.next();

				System.out.print("pw를 입력하세요 :");
				String join_pw = sc.next();

				System.out.print("name를 입력하세요 :");
				String join_name = sc.next();

				System.out.print("email를 입력하세요 :");
				String join_email = sc.next();

				LoginDTO ldto = new LoginDTO(join_id, join_pw, join_name, join_email);
				int row = dbdao.insertMember(ldto);

				if (row > 0) {
					System.out.println("insert success");
				} else {
					System.out.println("insert fail");
				}

			} else if (choice == 2) {
				System.out.println("회원정보 수정 페이지 입니다.");

				System.out.print("id를 입력하세요 :");
				String update_id = sc.next();

				System.out.print("pw를 입력하세요 :");
				String update_pw = sc.next();

				int row = dbdao.updateMember(update_pw, update_id);

				if (row > 0) {
					System.out.println("update success");
				} else {
					System.out.println("update fail");
				}

			} else if (choice == 3) {
				System.out.println("회원정보 삭제 페이지 입니다.");

				System.out.print("삭제할 id를 입력하세요 :");
				String delete_id = sc.next();

				int row = dbdao.deleteMember(delete_id);

				if (row > 0) {
					System.out.println("delete success");
				} else {
					System.out.println("delete fail");
				}

			} else if (choice == 4) {
				ArrayList<LoginDTO> dtoList = dbdao.selectMember();
				for (int i = 0; i < dtoList.size(); i++) {
					// System.out.println(dtoList.get(i)); // 주소값
					System.out.println("id : " + dtoList.get(i).getId());
					System.out.println("pw : " + dtoList.get(i).getPw());
					System.out.println("name : " + dtoList.get(i).getName());
					System.out.println("age : " + dtoList.get(i).getEmail());
				}

			} else {
				System.out.println("잘못 눌렀습니다!");
			}
		}

	}

	// 게임 플레이하는 메소드
	private static boolean playGame() {

		// 영화 제목 배열
		String[] movieTitles = { "변호인", "도둑들", "택시운전사", "기생충", "써니", "7번방의 선물", "국제시장", "명량", "극한직업", "신과함께" };

		// 랜덤으로 영화 선택
		int randomIndex = (int) (Math.random() * movieTitles.length);
		String selectedMovie = movieTitles[randomIndex].toUpperCase(); // 대소문자 구분 없이 맞출 수 있도록 대문자로 변환

		// 게임 시작 메시지
		System.out.println("영화 제목 맞추기 게임을 시작합니다!");
		System.out.println("영화의 제목은 " + selectedMovie.length() + "글자 입니다.");

		// 사용자 입력 받기
		Scanner scanner = new Scanner(System.in);

		// 사용자에게 영화 제목을 맞추도록 함
		boolean gameWon = false;
		int attempts = 0;
		final int maxNumber = 3; // 총 도전횟수 3번
		int score = 0; // 시작점수는 0점
		int newScore = 10; // 문제를 맞추면 10점
		boolean toggle = true;

		while ((!gameWon && attempts < maxNumber) && toggle) {
			int Remaining_Number = maxNumber - attempts; // 남은 도전횟수 보여주기
			System.out.println("남은 시도 횟수: " + Remaining_Number);
			System.out.print("영화 제목을 입력하세요: ");

			String userGuess = scanner.nextLine(); // 대소문자 구분 없이 비교하기 위해 대문자로 변환
			attempts++;

			// switch 문을 사용하여 정답 여부 확인
			while (true) {
				if (Remaining_Number < 0) {
					System.out.println("3번 시도 동안 정답을 맞추지 못하였습니다.");
					break;
				} else {
					if (userGuess.equals(selectedMovie)) { // 정답일 경우

						System.out.println("축하합니다! 영화 제목을 맞추셨습니다.");
						score += newScore;
						System.out.println("현재 누적된 점수 : " + score);
						toggle = false;
						break;

					} else { // 정답이 아닐 경우
						System.out.println("틀렸습니다. 다시 시도하세요.");

						System.out.println("현재 누적된 점수 : " + score);
						break;
					}

				}

			}
		}

		// 다시 플레이할지 물어봄
		System.out.print("게임을 다시 하시겠습니까? (y/n): ");
		String playAgain = scanner.next();
		if (playAgain.equals("y")) {
			return true;
		} else
			return false;

	}
}
