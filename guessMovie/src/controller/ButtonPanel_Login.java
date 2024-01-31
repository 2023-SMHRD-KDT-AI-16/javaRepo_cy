package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel_Login extends JPanel{// 로그인한 사용자를 위한 버튼
	
	private JButton[] MemberBtn = new JButton[4]; // 4개의 버튼
	// 싱글 게임 , 랭킹 조회, 정보 수정 , 회원가입
	
	Font font = new Font("MBC 1961굴림 Medium", Font.BOLD,20); // 폰트 설정
	
	private String [] name = {"싱글 게임","랭킹 조회","정보 수정","로그아웃"}; // 각 이름 배열 입력
	
	public ButtonPanel_Login() {
		
		for(int i = 0; i<MemberBtn.length;i++) {
			MemberBtn[i] = new JButton(name[i]); // 버튼 생성
			MemberBtn[i].setFont(font); // 폰트 설정
			MemberBtn[i].setBackground(Color.LIGHT_GRAY);
			System.out.println(name[i]);
			add(MemberBtn[i]); // 버튼 추가
			
			MemberBtn[i].addActionListener(new ActionListener() {
				// 모든 버튼에 ActionListener 등록 ( 클릭)
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MemberPanel.operate(e.getActionCommand());
					// 클릭된 버튼 문자열 정보 리턴
					
				}
			});
		}
	}


}
