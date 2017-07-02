package kr.ajou.ajou.teamProject.oop.gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Test extends Background {

	private int TestNum;
	private JLabel lblTitle_1;
	private JTextArea txtQuestion,txtAnswer;
	private Graphics screenGraphic;
	private Image screenImage;
	
	
	public Test(PanelChanger win, int testnum) {
		setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		background = new ImageIcon(BackgroundReSize("/images/TestBackground.png")).getImage();
		
		setTestNum(testnum);
		
		

		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.setBounds(261, 605, 156, 41);

		setLayout(null);
		

		
		lblTitle_1 = new JLabel("title");
		lblTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_1.setForeground(Color.WHITE);
		lblTitle_1.setBounds(340, 32, 633, 31);
		lblTitle_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblTitle_1);
		add(btnSubmit);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.changetotestBefore();
			}
		});
		btnBack.setBounds(850, 601, 143, 48);
		add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBounds(240, 98, 850, 225);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 850, 240);
		panel.add(scrollPane);
		
		txtQuestion = new JTextArea();
		txtQuestion.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtQuestion.setForeground(new Color(0, 0, 0));
		txtQuestion.setBackground(new Color(255, 255, 255));
		txtQuestion.setLineWrap(true);
		scrollPane.setViewportView(txtQuestion);
		txtQuestion.setEditable(false);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(240, 365, 850, 190);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 850, 190);
		panel_1.add(scrollPane_1);
		
		txtAnswer = new JTextArea();
		txtAnswer.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane_1.setViewportView(txtAnswer);
		TimerTest time = new TimerTest();
		JLabel timer = new JLabel("");
		timer.setBounds(864, 336, 260, 31);
		add(timer);
		
		JLabel lblWhatIsA = new JLabel("What is a console output?");
		lblWhatIsA.setForeground(Color.WHITE);
		lblWhatIsA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWhatIsA.setBounds(277, 335, 252, 32);
		add(lblWhatIsA);
	
		ReadFile();
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mark m = new mark();
				m.setrightAnswer(TestNum);
				m.setUserAnswer(txtAnswer.getText());
				m.domarking();
			}
		});
	}
	
	public void ReadFile(){
	    FileReader fr;
		try {
			fr = new FileReader("test"+TestNum+".txt");
	    BufferedReader br = new BufferedReader(fr);
	    
	    
	    String str = null;
	    String text;
	    while((str = br.readLine()) != null){

	    	
	    if(str.equals("/titlestart/")){
	    	text = "";
	    	while(!(str = br.readLine()).equals("/titleend/")){    
	 	    	text += str;
	 	    }
	        	lblTitle_1.setText(text);
	    }
	    
	    if(str.equals("/questionstart/")){
	    	text = "";
	    	 while(!(str = br.readLine()).equals("/questionend/")){    
	    		 text += str + "\n";
	 	    }
	    	 txtQuestion.setText(text);
	    }
	    }
	    br.close();
	    br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Test " + TestNum + " file is not found","ERROR",JOptionPane.ERROR_MESSAGE);
		} 
		
	

	}
		

public void setTestNum(int testNum) {
	if(testNum<1){
		System.out.println("setTestNum error!");
		return;
	}
	else
	TestNum = testNum;
}
}

