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
			while(true) {


				System.out.println( "[설정 번호]");
				System.out.print("[1]재생 [2]정지 [3]다음곡 [4]이전곡 [5]음악찾기 [6]시간 [7]종료 ");
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
					System.out.println("재생시간 ");
					c.getPlaytime();
				default:
					break;
				}
				
				
				
				
				
				
			}
			
		}

	}


