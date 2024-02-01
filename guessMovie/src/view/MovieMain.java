package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.DatabaseDAO;
import model.LoginDTO;

public class MovieMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DatabaseDAO dbdao = new DatabaseDAO();

		while (true) {
			System.out.println("==========회원관리 프로그램==========");
			System.out.println("1.회원 가입");
			System.out.println("2.비밀 번호 수정");
			System.out.println("3.회원정보 삭제");
			System.out.println("4.로그인하세요");
			System.out.println("5.랭킹 조회");
			System.out.println("6.프로그램 종료");

			int choice = sc.nextInt();

			if (choice == 6) {
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
				System.out.println("로그인창입니다");
				System.out.println("아이디 입력 : ");
				String dbID = sc.next();
				System.out.println("비밀번호 입력 : ");
				String dbPW = sc.next();

				if (dbdao.loginInfo(dbID, dbPW) == true) {
					System.out.println("로그인 성공");

				} else {
					System.out.println("로그인 실패");
				}

			} else if (choice == 5) {

				System.out.println("게임 랭킹 순위입니다");

				ArrayList<LoginDTO> dtoList = dbdao.showRank();
				for (int i = 0; i < dtoList.size(); i++) {
					// System.out.println(dtoList.get(i)); // 주소값
					System.out.println(
							(i + 1) + "위 : " + dtoList.get(i).getId2() + " ===> 점수 : " + dtoList.get(i).getRank());

				}

			} else {
				System.out.println("잘못 눌렀습니다!");
			}
		}

	}

}
