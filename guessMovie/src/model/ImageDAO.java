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

	 private static List<ImageIcon> imageIcons;
	    private JTextField userInputField;
	    private static JLabel imageLabel;

	    public ImageDAO() {
	        setTitle("영화 제목 맞추기 문제");
	        setSize(600,600);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        initializeImages();

	 
	        imageLabel = new JLabel();

	        add(imageLabel, BorderLayout.CENTER);

	        setLocationRelativeTo(null);
	        setVisible(true);
	    }
	    
	    ImageIcon imageIcon;
	    
	    private void initializeImages() {
	        // 이미지를 40개 로드하여 List에 저장
	        imageIcons = new ArrayList<>();
	        for (int i = 1; i <= 10; i++) {
	        	if(i == 2|| i==6||i==9||i==10) {
	        		imageIcon = new ImageIcon("../guessMovie/pictureData/" + i + ".jpg");
	        	}else {
	        		imageIcon = new ImageIcon("../guessMovie/pictureData/" + i + ".png");
	        	}
	            imageIcons.add(imageIcon);
	        }
	        System.out.println(imageIcons.get(0));
	    }

	    public void displayImage(int j) {
	    	initializeImages();
	        int imageNum = j-1;
	        imageLabel.setIcon(imageIcons.get(imageNum));
	            
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
