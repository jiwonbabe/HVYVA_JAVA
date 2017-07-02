
package kr.ajou.ajou.teamProject.oop.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.ajou.oop.teamProject.database.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public  class LogIn extends Background {


	private JTextField textField;
	private JTextField textField_1;
	private JButton btnSignUp;

	private static String logInID;
	private Image screenImage;
	private Graphics screenGraphic;

	

	public LogIn(PanelChanger win){
		
		background = new ImageIcon(BackgroundReSize("/images/loginbackground.jpg")).getImage();

		setLayout(null);
		


		setSize(SCREEN_WIDTH,SCREEN_HEIGHT);

		setBorder(new EmptyBorder(5, 5, 5, 5));

		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblPassword.setBounds(120, 326, 171, 86);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblId.setBounds(226, 216, 76, 71);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(373, 216, 509, 65);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(373, 339, 509, 56);
		textField_1.setColumns(10);
			
		JButton btnSignIn = new JButton("");
		btnSignIn.setIcon(new ImageIcon(LogIn.class.getResource("/images/login1.png")));
		btnSignIn.setBackground(null);
		btnSignIn.setBounds(381, 443, 464, 115);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					String id = textField.getText();
					
					String password = textField_1.getText();
					DBConnection db = new DBConnection();
					if(db.checkUserDataInDB(id, password)){
						logInID = id;
						win.changetomenuwindow();
					}
						
					else
					JOptionPane.showMessageDialog(null, "Plese check the ID and password!");
				
				

			}
		});
		
		btnSignUp = new JButton("");
		btnSignUp.setIcon(new ImageIcon(LogIn.class.getResource("/images/sign-up-now.png")));
		btnSignUp.setBackground(new Color(255, 255, 255));
		btnSignUp.setBounds(614, 600, 239, 58);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.changetoSignUp();
				
			}
		
		});
		setLayout(null);
		add(lblId);
		add(textField);
		add(lblPassword);
		add(textField_1);
		add(btnSignIn);
		add(btnSignUp);

		JLabel lblNewLabel = new JLabel("Do you want JOIN US?");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(320, 600, 304, 56);
		add(lblNewLabel);
	}
	
	public static String getlogInID(){
		return logInID;
	}
	
}

