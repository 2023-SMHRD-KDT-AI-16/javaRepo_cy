package view;

import java.util.Scanner;

import model.DatabaseDAO;
import model.LoginDTO;
import model.PreGameDAO;

public class GameMain {
	// 최종 main 문 -> 손채영 연결
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 스캐너 선언
		
		System.out.println("\r\n"
				+ "     ___  _______  __   __  _______    _______  _______  __   __  _______    _     _  _______  ______    ___      ______  \r\n"
				+ "    |   ||   _   ||  | |  ||   _   |  |       ||   _   ||  |_|  ||       |  | | _ | ||       ||    _ |  |   |    |      | \r\n"
				+ "    |   ||  |_|  ||  |_|  ||  |_|  |  |    ___||  |_|  ||       ||    ___|  | || || ||   _   ||   | ||  |   |    |  _    |\r\n"
				+ "    |   ||       ||       ||       |  |   | __ |       ||       ||   |___   |       ||  | |  ||   |_||_ |   |    | | |   |\r\n"
				+ " ___|   ||       ||       ||       |  |   ||  ||       ||       ||    ___|  |       ||  |_|  ||    __  ||   |___ | |_|   |\r\n"
				+ "|       ||   _   | |     | |   _   |  |   |_| ||   _   || ||_|| ||   |___   |   _   ||       ||   |  | ||       ||       |\r\n"
				+ "|_______||__| |__|  |___|  |__| |__|  |_______||__| |__||_|   |_||_______|  |__| |__||_______||___|  |_||_______||______| \r\n"
				+ "");
		System.out.println("==========================================================================================================================");
		System.out.println("==========================================================================================================================");
		System.out.println("==========================================================================================================================");
		// 출력문
		
		DatabaseDAO dbDAO = new DatabaseDAO();
		System.out.println("\n자바 게임 월드에 오신 것을 환영합니다!");
		
		while(true) {
		// 종료하지 않는 한 계속 실행되도록 while문 실행	
			
			System.out.print("[1] 연습 게임 , [2] 랭킹 조회 , [3] 회원 가입 , [4] 로그인 , [5] 환경 설정, [6] 종료");
			System.out.print("\n선택해 주세요 : ");
			// 선택 출력문
			
			int input = sc.nextInt(); // 변수 input에 사용자 선택 담기
			
			switch(input) {
			case 1 : 
				// [1] 연습 게임
				PreGameDAO.playGame(); // 싱글 게임 시작
				break;
			case 2: 
				// [2] 랭킹 조회
				break;
			case 3: 
				// [3] 회원 가입
				// 민중님 작성
				
				System.out.println("회원가입 페이지 입니다.");

				System.out.print("id를 입력하세요 :");
				String join_id = sc.next();
				
				boolean correct = dbDAO.signUp(join_id); // 로그인 검사
				
				while(correct=false) {
					System.out.println("아이디 사용이 불가합니다. 다시 입력해 주세요");
					System.out.print("id를 입력하세요 :");
					join_id = sc.next();
				}
				
				System.out.println("아이디 사용이 가능합니다.");
				
				System.out.print("pw를 입력하세요 :");
				String join_pw = sc.next();

				System.out.print("name를 입력하세요 :");
				String join_name = sc.next();

				System.out.print("email를 입력하세요 :");
				String join_email = sc.next();

				LoginDTO ldto = new LoginDTO(join_id, join_pw, join_name, join_email);
				int row = dbDAO.insertMember(ldto);

				if (row > 0) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("회원가입 실패");
				}
				
				break;
		
			case 4: 
				// [4] 로그인
				System.out.println("로그인 페이지 입니다.");

				System.out.print("id를 입력하세요 :");
				join_id = sc.next();
			
				System.out.print("pw를 입력하세요 :");
				join_pw = sc.next();

				correct = dbDAO.loginInfo(join_id, join_pw);

				if(correct = true) {
					System.out.println("로그인 성공 !");
				}else {
					System.out.println("로그인 실패");
				}
				
				break;
				
			case 5:
				// [5] 환경 설정
				break;
				
			case 6: 
				// [6] 종료
				System.out.println("정말 종료하시겠습니까? [Y/N]");
				String inputString = sc.next().toUpperCase(); // 입력을 inputString에 저장
				
				if(inputString.equals("Y")) {
					System.out.println("다음에 또 봐요 !");
					break;
				}else {
					System.out.println("좋은 생각입니다!");
					break;
				}
				
			default:
				// 잘못된 입력
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
				break;
			}
			
		}
	}
}
