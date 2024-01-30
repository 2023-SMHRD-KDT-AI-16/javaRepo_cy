import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		System.out.println("팀장 첫번째 커밋!");

		System.out.println("팀원1 두번째 커밋!");
		System.out.println("팀원2 세번째 커밋!");
		System.out.println("팀원3 네번째 커밋!");
		System.out.println("팀원5 다번째 커밋!");
		
		// 박경완
		int num1 = 10;
		int num2 = 20;
		System.out.println(num1+num2);
		


		// 김경민
		String java = "우리집 강아지의";
		   String AS ="구름";
		   System.out.println(java+"별명은"+AS+"입니다");
		   
		// 장민중
		Ex01 ex = new Ex01(); // 객체 생성   
		
		
		
		
		
		System.out.println("승영아 힘내");

		
		
		for(int i = 21; i <= 57; i++) {
			System.out.print(i+ " ");
		}
		System.out.println();
		
		for(int i = 96; i >= 53; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i = 21; i <= 57; i+=2) {
			System.out.print(i + " ");
			
			
	}//점수 입력받는 스캐너
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요 : "); // 단순 출력문
		int score = sc.nextInt(); // 입력해서 변수 score에 값을 담아두는 문장.		
		
		if(60<score) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");

		}
	}
}
