package controller;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel{ // 상단 패널
	
	Font font = new Font("MBC 1961굴림 Medium", Font.BOLD,20);
	
	private JLabel titleMsg = new JLabel("영화 제목 맞추기 게임 !"); // JLabel 형식 타이틀 메세지 
	
	public TitlePanel() {
		titleMsg.setFont(font);
		titleMsg.setHorizontalAlignment(JLabel.CENTER);
		
		setBackground(Color.lightGray);
		add(titleMsg);
	} // Panel에 위치하도록 세팅

}
