package controller;

import java.awt.*;
import javax.swing.*;

public class NewMemberView extends JFrame{
	
	
	public NewMemberView() {
		setTitle("회원가입");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		c.add(new JLabel("아이디"));
		c.add(new JTextField(20));
		
		c.add(new JLabel("비밀번호"));
		c.add(new JTextField(20));
		
		c.add(new JLabel("이메일"));
		c.add(new JTextField(20));
		
		c.add(new JLabel("닉네임"));
		c.add(new JTextField(20)); // 버튼 추가
		
		c.add(new JButton("회원가입"));
		
		setSize(250,300); 
		setResizable(false); // 사용자가 크기 조절 불가
		setVisible(true);
		
	}

}
