package controller;


import javax.swing.*;

public class MemberPanel extends JPanel{ // 회원이 마주하게 되는 화면

	private JLabel logoImageLab;
	
	private ImageIcon logoIcon = new ImageIcon("../GuessMovie_Test/logoPic/movie_logo.png");
	
	public MemberPanel() {
		setLayout(null); // 컴포넌트 위치 초기화
		
		logoImageLab = new JLabel();
		logoImageLab.setLocation(0,80); // 위치 지정
		logoImageLab.setSize(logoIcon.getIconWidth(), logoIcon.getIconHeight());// 크기 설정
		
		add(logoImageLab);
		this.logoImageLab.setIcon(logoIcon); // 출력해줄게
	}
	
	
	public static void operate(String cmd) { // 버튼 처리 -> 이 부분으로 옮기면 됨
		if(cmd.equals("싱글 게임")) {
			System.out.println("싱글 게임 선택");
			return;
		}else if(cmd.equals("랭킹 조회")) {
			System.out.println("랭킹 조회 선택");
			return;
		}else if(cmd.equals("정보 수정")) {
			System.out.println("정보 수정 선택");
			
			return;
		}else if(cmd.equals("로그아웃")) { // 로그아웃 완성
			System.out.println("로그아웃 선택");
			LoginFrame lgf = new LoginFrame(false);
			return;
		}
		
	}
}
