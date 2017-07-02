
package kr.ajou.ajou.teamProject.oop.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;



import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelChanger extends JFrame {
	Music introMusic = new Music("intro.mp3", true);
	
	private JPanel contentPane;
	private JPanel panel;

public static void main(String[] args){


	
	PanelChanger frame = new PanelChanger();
	frame.setResizable(false);

	frame.introMusic.start();
}
	/**
	 * Create the frame.
	 */
	public PanelChanger() {

		setTitle("HVYVA JAVA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setResizable(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JButton btnNewButton_1 = new JButton("Go to class");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changetoLogIn();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(146)
					.addComponent(btnNewButton_1)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(btnNewButton_1)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		panel = new LogIn(this);
		setContentPane((LogIn)panel);
		setVisible(true);
	}

	public void changetotest(int testnum){
		panel = new Test(this,testnum);
		getContentPane().removeAll();
		getContentPane().add((Test)panel);
		revalidate();
		repaint();
	}
	public void changetoCodeEducation(){
        introMusic.close();
		panel = new CodeEducation(this);
		getContentPane().removeAll();
		getContentPane().add((CodeEducation)panel);
		revalidate();
		repaint();

	}
	public void changetoLogIn(){
		panel = new LogIn(this);
		getContentPane().removeAll();
		getContentPane().add((LogIn)panel);
		revalidate();
		repaint();

	}
	
	public void changetotestBefore(){
		panel = new TestBefore(this);
		getContentPane().removeAll();
		getContentPane().add((TestBefore)panel);
		revalidate();
		repaint();
	}
	

	
	public void changetomenuwindow(){
		panel = new MenuWindow(this);
		getContentPane().removeAll();
		getContentPane().add((MenuWindow)panel);
		revalidate();
		repaint();
	}

	public void changetoSignUp() {
		panel = new SignUp(this);
		getContentPane().removeAll();
		getContentPane().add((SignUp)panel);
		revalidate();
		repaint();
	}

	
	public void changetocrosspuzzle(){
		kr.ajou.ajou.teamProject.oop.gui.crosspuzzle.main(null);

	}

}