package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{// 비회원 사용자 선택을 위한 Button

	private JButton[] loginBtn = new JButton[4]; // 4개의 버튼
	// 연습게임 , 랭킹 조회, 로그인 , 회원가입
	
	Font font = new Font("MBC 1961굴림 Medium", Font.BOLD,20);
	
	private String [] name = {"연습 게임","랭킹 조회","로그인","회원가입"}; // 각 이름 배열 입력
	
	public ButtonPanel() {
		for(int i = 0; i<loginBtn.length;i++) {
			loginBtn[i] = new JButton(name[i]); // 버튼 생성
			loginBtn[i].setFont(font); // 폰트 설정
			loginBtn[i].setBackground(Color.LIGHT_GRAY);
			
			add(loginBtn[i]); // 버튼 추가
			
			loginBtn[i].addActionListener(new ActionListener() {
				// 모든 버튼에 ActionListener 등록 ( 클릭)
				
				@Override
				public void actionPerformed(ActionEvent e) {
					LoginPanel.operate(e.getActionCommand());
					// 클릭된 버튼 문자열 정보 리턴
					
				}
			});
		}
	}
	
}
