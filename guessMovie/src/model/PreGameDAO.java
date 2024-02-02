package model;

import java.util.Scanner;

public class PreGameDAO {

	// 싱글게임 기회는 5번 힌트1번 주인공이름 제공 한번에 맞추면 10점 힌트보고 맞추면 5점

	//final char[] Remaining_Number = null;


	// 게임 플레이하는 메소드
	public static boolean playGame() {

		// 영화 제목 배열
		String[] movieTitles = { "신과함께","택시운전사","극한직업", "7번방의 선물","국제시장", "기생충","명량", "써니","변호인","도둑들"};

		// 랜덤으로 영화 선택
		int randomIndex = (int) (Math.random() * movieTitles.length);
		String selectedMovie = movieTitles[randomIndex].toUpperCase(); // 대소문자 구분 없이 맞출 수 있도록 대문자로 변환
		int j = randomIndex;
		
		String[][] hintCharacter = { // 2차원배열로 각 영화의 주인공들
				{"차태현","하정우","주지훈","김향기"}, // 신과함께
				{"송강호","유해진","류준열","토마스 크레취만"}, // 택시운전사
				{"류승룡","이하늬","진선규","이동휘","공명"}, // 극한직업
				{"류승룡","갈소원","박신혜","오달수","김정태"}, // 7번방의 선물
				{"황정민","김윤진","오달수","정진영"}, // 국제시장
				{"송강호","이정은","최우식","박소담","이선균","조여정"}, // 기생충
				{"최민식","류승룡","조진웅"}, // 명량
				{"심은경","강소라","김민영","박진주","남보라","민효린"}, // 써니
				{"송강호","김영애","오달수","곽도원","임시완"}, // 변호인
				{"김윤석","김혜수","이정재","전지현","김해죽","김수현"} // 도둑들
		};
		
		
		// 게임 시작 메시지
		System.out.println("\n❢◥ ▬▬▬▬▬▬ ◆ ▬▬▬▬▬▬ ◤❢ ❢◥ ▬▬▬▬▬▬ ◆ ▬▬▬▬▬▬ ◤❢ ❢◥ ▬▬▬▬▬▬ ◆ ▬▬▬▬▬▬ ◤❢");
		System.out.println("\r\n"
				+ " _     _  _______  ___      _______  _______  __   __  _______ \r\n"
				+ "| | _ | ||       ||   |    |       ||       ||  |_|  ||       |\r\n"
				+ "| || || ||    ___||   |    |       ||   _   ||       ||    ___|\r\n"
				+ "|       ||   |___ |   |    |       ||  | |  ||       ||   |___ \r\n"
				+ "|       ||    ___||   |___ |      _||  |_|  ||       ||    ___|\r\n"
				+ "|   _   ||   |___ |       ||     |_ |       || ||_|| ||   |___ \r\n"
				+ "|__| |__||_______||_______||_______||_______||_|   |_||_______|\r\n"
				+ "\n");
        System.out.println("❢◥ ▬▬▬▬▬▬ ◆ ▬▬▬▬▬▬ ◤❢ ❢◥ ▬▬▬▬▬▬ ◆ ▬▬▬▬▬▬ ◤❢ ❢◥ ▬▬▬▬▬▬ ◆ ▬▬▬▬▬▬ ◤❢");
        
        System.out.println("\t\t영화 제목 맞추기 게임을 시작합니다! ");
        System.out.println("\t\t연습 게임에서는 랭킹 정보가 저장되지 않습니다. ");
        
        System.out.println("❢◥ ▬▬▬▬▬▬ ◆ ▬▬▬▬▬▬ ◤❢ ❢◥ ▬▬▬▬▬▬ ◆ ▬▬▬▬▬▬ ◤❢ ❢◥ ▬▬▬▬▬▬ ◆ ▬▬▬▬▬▬ ◤❢");
		System.out.println("\n영화의 제목은 " + selectedMovie.length() + "글자 입니다.");


		ImageDAO dao = new ImageDAO();
		dao.displayImage(j);
		
		// 사용자 입력 받기
		Scanner scanner = new Scanner(System.in);

		// 사용자에게 영화 제목을 맞추도록 함
		boolean gameWon = false; //게임이 종료될때 사용되는 변수 답을 맞추면 true로 바뀌고 틀리면 false로 유지
		int attempts = 0; // 총 시도 횟수
		final int maxNumber = 3; // 총 도전횟수 3번
		int score = 0; // 시작점수는 0점
		int newScore = 10; // 문제를 맞추면 10점
		boolean toggle = true;

		while ((!gameWon && attempts < maxNumber) && toggle) {
		
			
			int Remaining_Number = maxNumber - attempts; // 남은 도전횟수 보여주기
			System.out.println("남은 시도 횟수 : " + Remaining_Number);
			System.out.print("영화 제목을 입력하세요 : ");

			String userGuess = scanner.nextLine(); // 대소문자 구분 없이 비교하기 위해 대문자로 변환
			attempts++;

			// switch 문을 사용하여 정답 여부 확인
			while (true) {
				if (Remaining_Number <= 0) {
					System.out.println("3번 시도 동안 정답을 맞추지 못하였습니다.");
					break;
				} else {
					if (userGuess.equals(selectedMovie)) { // 정답일 경우

						System.out.println(".　♪　∧,＿∧\r\n"
								+ "　 　(´･ω･`) ))\r\n"
								+ "　(( (　つ　ヽ、　♪\r\n"
								+ "　　　〉 とノ　)))\r\n"
								+ "　　（__ノ^(＿)\r\n"
								+ "");
						System.out.println("축하합니다 ! 영화 제목을 맞추셨습니다.");
						score += newScore;
						System.out.println("┌───────────────┐\r\n"
								+ "  누적 점수 : "+score+"\r\n"
								+ "└───────────────┘\r\n"
								+ "　　ᕱ ᕱ ||\r\n"
								+ "　 ( ･ω･ ||\r\n"
								+ "　 /　つΦ\r\n");
						toggle = false;
						break;

					} else { // 정답이 아닐 경우
						System.out.print("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\r\n"
								+ "████▌▄▌▄▐▐▌█████\r\n"
								+ "████▌▄▌▄▐▐▌▀████\r\n"
								+ "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\r");
						System.out.println("틀렸습니다. 다시 시도하세요.");
						
						// 힌트 제공
						if(attempts == 1) {
							provideHint(hintCharacter, randomIndex);
						}
						System.out.println("┌───────────────┐\r\n"
								+ "  누적 점수 : "+score+"\r\n"
								+ "└───────────────┘\r\n"
								+ "　　ᕱ ᕱ ||\r\n"
								+ "　 ( ･ω･ ||\r\n"
								+ "　 /　つΦ\r\n");
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
		} else {
			System.out.println();
			System.out.println("또 만나요!");
			return false;
		}
	}
		
		// 힌트를 제공하는 메소드
	    private static void provideHint(String[][] hintCharacter, int randomIndex) {
	    	System.out.println();
	    	System.out.print("힌트: 주인공 이름은 " ); 
	    	for(int i = 0; i<hintCharacter[randomIndex].length; i++ ) {  
	    	System.out.print(hintCharacter[randomIndex][i]+" ");
	    }
	        System.out.println("입니다\n");
	    }
	

}
