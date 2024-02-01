package model;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ImageDAO extends JFrame {

	 private List<ImageIcon> imageIcons;
	    private JTextField userInputField;
	    private JLabel imageLabel;

	    public ImageDAO() {
	        setTitle("영화 제목 맞추기 문제");
	        setSize(800, 600);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        initializeImages();

	        userInputField = new JTextField(5);
	        JButton displayButton = new JButton("문제 출력");
	        displayButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                displayImage();
	            }
	        });

	        imageLabel = new JLabel();

	        JPanel panel = new JPanel();
	        panel.add(new JLabel("번호 입력"));
	        panel.add(userInputField);
	        panel.add(displayButton);

	        add(panel, BorderLayout.NORTH);
	        add(imageLabel, BorderLayout.CENTER);

	        setLocationRelativeTo(null);
	        setVisible(true);
	    }
	    
	    ImageIcon imageIcon;
	    
	    private void initializeImages() {
	        // 이미지를 40개 로드하여 List에 저장
	        imageIcons = new ArrayList<>();
	        for (int i = 1; i <= 10; i++) {
	        	if(i == 2|| i == 5|| i==6||i==9||i==10) {
	        		imageIcon = new ImageIcon("../GuessMovie_Test/pictureData/" + i + ".jpg");
	        	}else {
	        		imageIcon = new ImageIcon("../GuessMovie_Test/pictureData/" + i + ".png");
	        	}
	            imageIcons.add(imageIcon);
	        }
	    }

	    private void displayImage() {
	        try {
	            int imageNumber = Integer.parseInt(userInputField.getText());

	            if (imageNumber >= 1 && imageNumber <= 10) {
	                // 사용자가 입력한 번호에 해당하는 이미지 표시
	                imageLabel.setIcon(imageIcons.get(imageNumber - 1));
	            } else {
	                JOptionPane.showMessageDialog(this, "");
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "");
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new ImageDAO();
	            }
	        });
	    }

}
