package controller;

import java.awt.*;

import javax.swing.JFrame;

public class LoginFrame extends JFrame{
// 컨트롤러부분 -> 뷰를 통해 전달된 사용자 요천 분석, 페이지 이동 확인
	
	private LoginPanel loginPanel = new LoginPanel();
	private MemberPanel memberPanel = new MemberPanel();
	
	
	
	public LoginFrame(Boolean correct) { // 생성자
		
		setTitle("영화 제목 맞추기"); // 창 제목 설정
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 창 종료시 종료
		Container c = getContentPane();
		
		if(correct==true) {
			// 로그인 성공
			
			c.add(new TitlePanel(), BorderLayout.NORTH);
			c.add(memberPanel, BorderLayout.CENTER);
			c.add(new ButtonPanel_Login(), BorderLayout.SOUTH);
			
			setVisible(true); // 보이도록 설정
			
		
		}else { // 로그인 실패 -> 비회원용
			
			c.add(new TitlePanel(), BorderLayout.NORTH);
			c.add(loginPanel, BorderLayout.CENTER);
			c.add(new ButtonPanel(), BorderLayout.SOUTH);
			
			setVisible(true); // 보이도록 설정
		}
		
		setSize(600,400);
		setResizable(false); // 사용자가 크기 조절 불가
		
	}
	
	public static void main(String[] args) {
		new LoginFrame(false);
	}
	
	
	
	
}
