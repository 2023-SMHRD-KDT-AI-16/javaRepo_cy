package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MusicController;
import model.DatabaseDAO;
import model.LoginDTO;
import model.PreGameDAO;
import model.SingleGameDAO;

public class GameMain {
	// 최종 main 문 -> 손채영 연결
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 스캐너 선언
		DatabaseDAO dbDAO = new DatabaseDAO(); // 새로운 DatabaseDAO 생성
		boolean state = true; // 실행을 위한 변수 추가
		boolean member = false; // 로그인 후 실행되는 멤버 전용 while 문을 위한 변수
		
		SingleGameDAO singleDAO = new SingleGameDAO();
		MusicController c = new MusicController();
		
		c.play(); // 처음부터 실행
		
		System.out.println("\r\n"
				+ "     ___  _______  __   __  _______    _______  _______  __   __  _______    _     _  _______  ______    ___      ______  \r\n"
				+ "    |   ||   _   ||  | |  ||   _   |  |       ||   _   ||  |_|  ||       |  | | _ | ||       ||    _ |  |   |    |      | \r\n"
				+ "    |   ||  |_|  ||  |_|  ||  |_|  |  |    ___||  |_|  ||       ||    ___|  | || || ||   _   ||   | ||  |   |    |  _    |\r\n"
				+ "    |   ||       ||       ||       |  |   | __ |       ||       ||   |___   |       ||  | |  ||   |_||_ |   |    | | |   |\r\n"
				+ " ___|   ||       ||       ||       |  |   ||  ||       ||       ||    ___|  |       ||  |_|  ||    __  ||   |___ | |_|   |\r\n"
				+ "|       ||   _   | |     | |   _   |  |   |_| ||   _   || ||_|| ||   |___   |   _   ||       ||   |  | ||       ||       |\r\n"
				+ "|_______||__|  |__|  |___|  |__| |__|  |_______||__| |__||_|   |_||_______|  |__| |__||_______||___|  |_||_______||______| \r\n"
				+ "");
		System.out.println("==========================================================================================================================");
		System.out.println("==========================================================================================================================");
		System.out.println("==========================================================================================================================");
		// 출력문
		
		System.out.println("\n***** 자바 게임 월드에 오신 것을 환영합니다! *****");
		
		while(state) {
		// 종료하지 않는 한 계속 실행되도록 while문 실행	
			
			System.out.print("\n[1] 연습 게임 , [2] 랭킹 조회 , [3] 회원 가입 , [4] 로그인 , [5] 환경 설정, [6] 종료");
			System.out.print("\n선택해 주세요 : ");
			// 선택 출력문
			
			int input = sc.nextInt(); // 변수 input에 사용자 선택 담기
			
			String join_id = null;
			
			switch(input) {
			
			case 1 : 
				// [1] 연습 게임
				PreGameDAO.playGame(); // 싱글 게임 시작
				break;
				
			case 2: 
				// [2] 랭킹 조회
				System.out.println("     .　 ⋀_⋀\r\n"
						+ "　    　 (･ω･)\r\n"
						+ "    .／ Ｕ ∽ Ｕ ＼\r\n"
						+ "     │＊　축　＊│\r\n"
						+ "     │＊　하　＊│\r\n"
						+ "     │＊　해　＊│\r\n"
						+ "     │＊　요　＊│\r\n"
						+ "     │＊　☆　＊│\r\n"
						+ "     .￣￣￣￣￣￣\r\n");
				System.out.println("╔═════ °• ♔ •° ═════╗");
	            ArrayList<LoginDTO> dtoList = dbDAO.selectRanking();
	            
	            for(int i = 0; i< dtoList.size(); i++) {
	               //System.out.println(dtoList.get(i)); // 주소값
	               System.out.println("  "+(i+1)+" " + dtoList.get(i).getId()+" // " + dtoList.get(i).getRank()+"점");
	            }
	            System.out.println("╚═════ °• ♔ •° ═════╝");
	           
				break;
			case 3: 
				// [3] 회원 가입
				// 민중님 작성
				boolean memberState = true; // 회원가입 state true 설정
				
				System.out.println("회원가입 페이지 입니다.");
				
				System.out.print("id를 입력하세요 :");
				join_id = sc.next();
				
				boolean correct = dbDAO.signUp(join_id); // 로그인 검사

				while(memberState) { // memberState가 true일 경우 계속 동작

					if(correct==false) { // true일 경우 -> 사용 불가
					
						System.out.println("아이디 사용이 불가합니다. 다시 입력해 주세요");
						System.out.print("id를 입력하세요 :");
						join_id = sc.next();
				
						correct = dbDAO.signUp(join_id); // 로그인 재검사
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
						int row2 = dbDAO.insertRank(join_id); // rank data 생성
						memberState = false; // while문 탈출
						
					} else {
						System.out.println("회원가입 실패");
					}
				
				}
				break;
				
			case 4: 
				// [4] 로그인
				System.out.println("\n로그인 페이지 입니다.");

				System.out.print("id를 입력하세요 :");
				join_id = sc.next();
			
				System.out.print("pw를 입력하세요 :");
				String join_pw = sc.next();

				correct = dbDAO.loginInfo(join_id, join_pw);

				if(correct == true) {
					System.out.println("로그인 성공 !");
					
					singleDAO.setMember(join_id); // 아이디 넘겨주기
					
					state = false; // while문 탈출
					member = true; // member while문 시작 -> 싱글게임을 위함.(랭킹 저장)
					
				}else {
					System.out.println("로그인 실패");
				}
				
				break;
				
			case 5:
				// [5] 환경 설정
				System.out.println();
				System.out.println(""
						+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
						+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
						+ "▒▒▒▒▓▒▒▓▒▒▒▒\r\n"
						+ "▒▒▒▒▓▒▒▓▒▒▒▒\r\n"
						+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
						+ "▒▓▒▒▒▒▒▒▒▒▓▒\r\n"
						+ "▒▒▓▓▓▓▓▓▓▓▒▒\r\n"
						+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
								+ "      설정을 선택해주세요\r\n"
								+ "      ￣￣＼／￣￣￣￣￣￣￣\r\n"
						+ "");
				int sel;//사용자의 선택
				boolean test = true;
				while(test) {

					System.out.println("[1] 재생 [2] 정지 [3] 다음곡 [4] 이전곡 [5] 음악 찾기 [6] 종료 ");
					System.out.print("번호 입력해주세요.>> ");
					sel = sc.nextInt();
					
					switch(sel) {
					case 1 :
						c.play();
						break;
					case 2:
						c.stop();
						System.out.println("노래를 종료할게요");
						break;
					case 3:
						c.next();
						break;
					case 4:
						c.pre();
						break;
					case 5:
						System.out.print("재생할 음악이름 >> ");
						c.search(sc.next());
						break;
					case 6:
						test = false;
						break;
						
					default:
						System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
						break;
					}
		
					
				}
				
				break;
				
			case 6: 
				
				// [6] 종료
				System.out.println("정말 종료하시겠습니까? [Y/N]");
				String inputString = sc.next().toUpperCase(); // 입력을 inputString에 저장
				
				if(inputString.equals("Y")) {
					System.out.println("다음에 또 봐요 !");
					state = false; // while문 탈출
					break;
				}else {
					System.out.println("좋은 생각입니다!");
					break; // 재시작
				}
				
			default:
				// 잘못된 입력
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
				break;
			}
			
		}
		
		if(member == true) {
			// 멤버 전용 출력문
			
			boolean memberState = true;
			
			while(memberState) {
				// 종료하지 않는 한 계속 실행되도록 while문 실행	
				
				System.out.print("[1] 싱글 게임 , [2] 랭킹 조회 , [3] 로그아웃 , [4] 환경 설정");
				System.out.print("\n선택해 주세요 : ");
				
				int input = sc.nextInt(); // 변수 input에 사용자 선택 담기
				
				String join_id = null;
				
				switch(input) {
				
				case 1 : 
					// [1] 싱글 게임
					System.out.println();
					singleDAO.playGame(); // 싱글 게임 시작
					break;
					
				case 2: 
					// [2] 랭킹 조회
					System.out.println("     .　 ⋀_⋀\r\n"
							+ "　    　 (･ω･)\r\n"
							+ "    .／ Ｕ ∽ Ｕ ＼\r\n"
							+ "     │＊　축　＊│\r\n"
							+ "     │＊　하　＊│\r\n"
							+ "     │＊　해　＊│\r\n"
							+ "     │＊　요　＊│\r\n"
							+ "     │＊　☆　＊│\r\n"
							+ "     .￣￣￣￣￣￣\r\n");
					System.out.println("╔═════ °• ♔ •° ═════╗");
		            ArrayList<LoginDTO> dtoList = dbDAO.selectRanking();
		            
		            for(int i = 0; i< dtoList.size(); i++) {
		               //System.out.println(dtoList.get(i)); // 주소값
		               System.out.println("  "+(i+1)+" " + dtoList.get(i).getId()+" // " + dtoList.get(i).getRank()+"점");
		            }
		            System.out.println("╚═════ °• ♔ •° ═════╝");
					break;

				case 3: 
<<<<<<< HEAD
					// [3] 정보 수정
					// 민중님 작성
					
					System.out.println("정보 수정 페이지 입니다.");
					
					System.out.print("ID를 입력해주세요. : "); 
					String changeID = sc.next();
					
					System.out.print("변경하실 비밀번호를 입력해주세요. : ");
					String changePW = sc.next();

					break;
			
				case 4: 
					// [4] 로그아웃
=======
					// [3] 로그아웃
>>>>>>> branch 'master' of https://github.com/2023-SMHRD-KDT-AI-16/javaRepo_cy.git
					System.out.println("정말 로그아웃 하시겠습니까? [Y/N]");
					String inputString = sc.next().toUpperCase(); // 입력을 inputString에 저장
					
					if(inputString.equals("Y")) {
						System.out.println("다음에 또 봐요 !");
						memberState=false;
						c.stop();
						break;
						
					}else {
						System.out.println("좋은 생각입니다!");
						break;
					}
					
					
<<<<<<< HEAD
				case 5:
					// [5] 환경 설정
					
					break;
					
				case 6: 
					// [6] 종료
					System.out.println("정말 종료하시겠습니까? [Y/N]");
					inputString = sc.next().toUpperCase(); // 입력을 inputString에 저장
					
					if(inputString.equals("Y")) {
						System.out.println("다음에 또 봐요 !");
						memberState = false;
						break;
					}else {
						System.out.println("좋은 생각입니다!");
						break;
=======
				case 4:
					// [4] 환경 설정
					System.out.println();
					System.out.println(""
							+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
							+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
							+ "▒▒▒▒▓▒▒▓▒▒▒▒\r\n"
							+ "▒▒▒▒▓▒▒▓▒▒▒▒\r\n"
							+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
							+ "▒▓▒▒▒▒▒▒▒▒▓▒\r\n"
							+ "▒▒▓▓▓▓▓▓▓▓▒▒\r\n"
							+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
									+ "      설정을 선택해주세요\r\n"
									+ "      ￣￣＼／￣￣￣￣￣￣￣\r\n"
							+ "");
					int sel;//사용자의 선택
					boolean test = true;
					while(test) {

						System.out.println("[1] 재생 [2] 정지 [3] 다음곡 [4] 이전곡 [5] 음악 찾기 [6] 종료 ");
						System.out.print("번호 입력해주세요.>> ");
						sel = sc.nextInt();
						
						switch(sel) {
						case 1 :
							c.play();
							break;
						case 2:
							c.stop();
							System.out.println("노래를 종료할게요");
							break;
						case 3:
							c.next();
							break;
						case 4:
							c.pre();
							break;
						case 5:
							System.out.print("재생할 음악이름 >> ");
							c.search(sc.next());
							break;
						case 6:
							test = false;
							break;
							
						default:
							System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
							break;
						}
			
						
>>>>>>> branch 'master' of https://github.com/2023-SMHRD-KDT-AI-16/javaRepo_cy.git
					}
					
					break;
		
				default:
					// 잘못된 입력
					System.out.println("\n잘못된 입력입니다. 다시 입력해 주세요");
					break;
				}
					
			}	
		}
	}
}
