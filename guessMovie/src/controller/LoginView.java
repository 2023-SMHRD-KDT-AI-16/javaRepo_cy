package controller;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.DatabaseDAO;


public class LoginView extends JFrame { //로그인 창
	
	
	public LoginView() {
		setTitle("로그인");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		c.add(new JLabel("아이디"));
		JTextField idTextF = new JTextField(20);
		c.add(idTextF);
		
		c.add(new JLabel("비밀번호"));
		JTextField pwTextF = new JTextField(20);
		c.add(pwTextF);
		
		JButton loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idTextF.getText(); // id 에 입력한 text 출력
				String pw = pwTextF.getText(); // pw에 입력한 text 출력
				
				// db 연동 및 검증
				DatabaseDAO.getConn();
				Boolean correct = DatabaseDAO.loginInfo(id,pw);
				
				if(correct == true) {
					// 로그인 성공
					setVisible(false);
					LoginFrame memberLoginF = new LoginFrame(correct); // 로그인 완성
					
					
				}else {
					 // 메세지 출력
				}
				
			}
			
		});
		
		c.add(loginBtn);
		
		setSize(250,200);
		setResizable(false); // 사용자가 크기 조절 불가
		setVisible(true);
		
	}
}
