package kr.ajou.ajou.teamProject.oop.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;

import kr.ajou.oop.teamProject.database.DBConnection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.SwingConstants;

public class SignUp extends Background implements AccountManage {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private boolean checked;
	private Image background = new ImageIcon(Background.class.getResource("/images/loginbackground.jpg"))
			.getImage();
	private Image screenImage;
	private Graphics screenGraphic;

	

	/**
	 * Create the panel.
	 */
	public SignUp(PanelChanger win) {
		setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Sign up");
		lblNewLabel.setFont(new Font("MD��ü", Font.PLAIN, 55));
		lblNewLabel.setBounds(400, 100, 299, 142);
		add(lblNewLabel);
		
		textField = new JTextField("");
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				checked = false;
			}
		});
		textField.setBounds(387, 282, 379, 42);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(387, 401, 379, 42);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(387, 484, 379, 42);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1.setBounds(200, 262, 77, 68);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(166, 401, 100, 60);
		add(lblNewLabel_2);
		
		JLabel lblCheckPassword = new JLabel("Check again");
		lblCheckPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckPassword.setBounds(154, 484, 123, 60);
		add(lblCheckPassword);
		
		JButton btnNewButton = new JButton("Duplication check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���̵� �ߺ�üũ.

				DBConnection connection = new DBConnection();
				boolean result=connection.checkIDDuplication(textField.getText());
				if(result){
					JOptionPane.showMessageDialog(null, "This ID is already used by others. Please insert the other one.");
					checked = false;
				}
				else{
					JOptionPane.showMessageDialog(null, "You can use this ID");
					checked = true;
				}
			
			}
		});
		btnNewButton.setBounds(821, 279, 150, 49);
		add(btnNewButton);
	
		
		JButton btnNewButton_1 = new JButton(new ImageIcon(SignUp.class.getResource("/images/backButtonBasic.png")));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.changetoLogIn();
			}
		});
		btnNewButton_1.setBounds(67, 48, 123, 93);
		add(btnNewButton_1);

		JButton btnSignUp = new JButton(new ImageIcon(SignUp.class.getResource("/images/sign-up-now.png")));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageAccount(win);
			}
				});
			
		btnSignUp.setBounds(451, 568, 236, 93);
		add(btnSignUp);

	}
	
	@Override
	public void manageAccount(PanelChanger win) {

		if(checked==true){
		if(textField_1.getText().equals(textField_2.getText()))	{
			DBConnection connection = new DBConnection();
			if(connection.insertUserDataToDB(textField.getText(), textField_1.getText())){
			JOptionPane.showMessageDialog(null, "Sign Up success!");
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			win.changetoLogIn();
			}
		}
			
		else
			JOptionPane.showMessageDialog(null, "Passwords are not the same");
		
		}
		else JOptionPane.showMessageDialog(null, "Please do duplication check");
	}

}
