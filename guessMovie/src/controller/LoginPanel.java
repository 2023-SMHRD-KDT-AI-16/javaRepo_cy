package controller;

import javax.swing.*;

public class LoginPanel extends JPanel{ // 비회원이 처음 마주하게 되는 화면

	private JLabel logoImageLab;
	
	private ImageIcon logoIcon = new ImageIcon("../GuessMovie_Test/logoPic/movie_logo.png");
	
	public LoginPanel() {
		setLayout(null); // 컴포넌트 위치 초기화
		
		logoImageLab = new JLabel();
		logoImageLab.setLocation(0,80); // 위치 지정
		logoImageLab.setSize(logoIcon.getIconWidth(), logoIcon.getIconHeight());// 크기 설정
		
		add(logoImageLab);
		this.logoImageLab.setIcon(logoIcon); // 출력해줄게
	}
	
	
	public static void operate(String cmd) { // 버튼 처리 -> 이 부분으로 옮기면 됨
		if(cmd.equals("연습 게임")) {
			System.out.println("연습 게임 선택");
			return;
		}else if(cmd.equals("랭킹 조회")) {
			System.out.println("랭킹 조회 선택");
			return;
		}else if(cmd.equals("회원가입")) {
			System.out.println("회원가입 선택");
			NewMemberView loginView = new NewMemberView();
			return;
		}else if(cmd.equals("로그인")) {
			System.out.println("로그인 선택");
			LoginView loginView = new LoginView();
			return;
		}
		
	}
}
