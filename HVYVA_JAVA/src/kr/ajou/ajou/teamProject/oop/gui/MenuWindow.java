package kr.ajou.ajou.teamProject.oop.gui;


import javax.swing.border.EmptyBorder;

import kr.ajou.oop.team.Project.etc.SwingCalender;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;



public class MenuWindow extends Background {

	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public MenuWindow(PanelChanger win) {


		setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		background = new ImageIcon(BackgroundReSize("/images/MenuwindowBackground.jpg")).getImage();

		setBorder(new EmptyBorder(5, 5, 5, 5));

		
		JButton btnNewButton = new JButton("Test");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.changetotestBefore();
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("Can you predict output?");
			}
		});
		btnNewButton.setBounds(699, 496, 150, 57);
		
		JButton btnNewButton_1 = new JButton("Your progress");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				textArea.setText("show your progrss");
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingCalender calender = new SwingCalender();

			}
		});
		btnNewButton_1.setBounds(964, 496, 150, 57);
		
		JButton btnNewButton_2 = new JButton("Concept study");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textArea.setText("Let's study about programmin through video and text");
		
			}
		});
		btnNewButton_2.setBounds(158, 496, 150, 57);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.changetoCodeEducation();
			}
		});
		
		JButton btnNewButton_3 = new JButton("crosspuzzle");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.changetocrosspuzzle();
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textArea.setText("Let's crossword game with JAVA term");
			}
		});
		btnNewButton_3.setBounds(440, 496, 150, 57);
		setLayout(null);
		add(btnNewButton);
		add(btnNewButton_1);
		add(btnNewButton_2);
		add(btnNewButton_3);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("MingLiU_HKSCS-ExtB", Font.PLAIN, 30));
		textArea.setBounds(434, 104, 403, 189);
		add(textArea);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(MenuWindow.class.getResource("/images/logout.png")));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.changetoLogIn();
			}
		});
		btnNewButton_4.setBounds(50, 13, 117, 117);
		add(btnNewButton_4);
	}
}