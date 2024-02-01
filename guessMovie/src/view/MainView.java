<<<<<<< HEAD
package view;

import java.util.Scanner;

import controller.MainController;

	public class MainView {

		public static void musicPlay() {
			//View 의 역할 : 사용자의 인터페이스(UI)
			//기능을 사용자가 선택할 수 있도록 만들기.
			//재생, 정지, 다음곡, 이전곡, 검색, 종료
			
			Scanner sc = new Scanner(System.in);
			MainController c = new MainController();
			
			System.out.println(""
					+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
					+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
					+ "▒▒▒▒▓▒▒▓▒▒▒▒\r\n"
					+ "▒▒▒▒▓▒▒▓▒▒▒▒\r\n"
					+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
					+ "▒▓▒▒▒▒▒▒▒▒▓▒\r\n"
					+ "▒▒▓▓▓▓▓▓▓▓▒▒\r\n"
					+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
							+ ".      설정을 선택해주세요\r\n"
							+ "      ￣￣＼／￣￣￣￣￣￣￣\r\n"
					+ "");
			int sel;//사용자의 선택
			boolean test = true;
			while(test) {


				System.out.println( "[설정 번호]");
				System.out.print("[1]재생 [2]정지 [3]다음곡 [4]이전곡 [5]음악찾기 [6]시간 [7]음악리스트 [8] ");
				System.out.println(" ");
				System.out.print("번호 입력해주세요.>>");
				sel = sc.nextInt();
				
				switch(sel) {
				case 1 :
					c.play();
					break;
				case 2:
					c.stop();
					System.out.println("정지");
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
					System.out.println("재생길이 ");
					c.getPlaytime();
					break;
				case 7:
					System.out.println("[음악리스트] 선택하셨습니다.");
					
					
				case 8:
					test =false;
					break;
					
				default:
					System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
					break;
				}
				
				
				
				
				
				
			}
			
		}

	}


=======
//package view;
//
//import java.util.Scanner;
//
//import controller.MusicController;
//
//	public class MainView {
//
//		public static void musicPlay() {
//			//View 의 역할 : 사용자의 인터페이스(UI)
//			//기능을 사용자가 선택할 수 있도록 만들기.
//			//재생, 정지, 다음곡, 이전곡, 검색, 종료
//			
//			Scanner sc = new Scanner(System.in);
////			MusicController c = new MusicController();
//			
////			System.out.println(""
////					+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
////					+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
////					+ "▒▒▒▒▓▒▒▓▒▒▒▒\r\n"
////					+ "▒▒▒▒▓▒▒▓▒▒▒▒\r\n"
////					+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
////					+ "▒▓▒▒▒▒▒▒▒▒▓▒\r\n"
////					+ "▒▒▓▓▓▓▓▓▓▓▒▒\r\n"
////					+ "▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
////							+ ".      설정을 선택해주세요\r\n"
////							+ "      ￣￣＼／￣￣￣￣￣￣￣\r\n"
////					+ "");
////			int sel;//사용자의 선택
////			boolean test = true;
////			while(test) {
////
////				System.out.print("[1] 재생 [2] 정지 [3] 다음곡 [4] 이전곡 [5] 음악찾기 [6] 종료 ");
////				System.out.println(" ");
////				System.out.print("번호 입력해주세요.>>");
////				sel = sc.nextInt();
////				
////				switch(sel) {
////				case 1 :
////					c.play();
////					break;
////				case 2:
////					c.stop();
////					System.out.println("정지");
////					break;
////				case 3:
////					c.next();
////					break;
////				case 4:
////					c.pre();
////					break;
////				case 5:
////					System.out.print("재생할 음악이름 >> ");
////					c.search(sc.next());
////					break;
////				case 6:
////					test =false;
////					break;
////					
////				default:
////					System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
////					break;
////				}
////	
////				
////			}
//			
//		}
//
//	}
//
//
>>>>>>> branch 'master' of https://github.com/2023-SMHRD-KDT-AI-16/javaRepo_cy.git
