
package kr.ajou.ajou.teamProject.oop.gui;
	import java.awt.BorderLayout;
	import java.awt.EventQueue;
	import java.awt.Graphics;
	import java.awt.Image;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.ImageIcon;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JButton;
	import java.awt.GridBagLayout;

	import java.awt.GridBagConstraints;
	import java.awt.Insets;
	import javax.swing.JList;
	import javax.swing.JOptionPane;
	import javax.swing.JScrollPane;
	import javax.swing.ListSelectionModel;
	import javax.swing.AbstractListModel;
	import javax.swing.JLabel;
	import java.awt.Font;
	import javax.swing.JTextPane;
	import java.awt.event.ActionListener;
	import java.util.List;
	import java.awt.event.ActionEvent;
	import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
	import javax.swing.DefaultComboBoxModel;
	import java.awt.Color;

	public class TestBefore extends Background {

		private JList<String> select;
		private JList<String> list;
		private JComboBox comboBox;



		public TestBefore(PanelChanger win) {
			background = new ImageIcon(BackgroundReSize("/images/MenuwindowBackground.jpg")).getImage();

	
			setSize(SCREEN_WIDTH, SCREEN_HEIGHT);

			setBorder(new EmptyBorder(5, 5, 5, 5));
			setLayout(null);

			
			JButton btnStart = new JButton("start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
		
					switch((String)comboBox.getSelectedItem()){
					case "conditionals : if, else if , switch":
			
						win.changetotest(1);
						break;
					case "loop : while, for":
				
						win.changetotest(2);
						break;
					case "Array":
						win.changetotest(3);
						break;
					case "Create object and use":
						win.changetotest(4);
						break;
						
					}	
				}
			});
			btnStart.setBounds(287, 573, 308, 76);
			add(btnStart);
			
			JLabel lblPleaseSelectTest = new JLabel("please select test");
			lblPleaseSelectTest.setForeground(Color.DARK_GRAY);
			lblPleaseSelectTest.setFont(new Font("Times New Roman", Font.BOLD, 29));
			lblPleaseSelectTest.setBounds(287, 449, 289, 51);
			add(lblPleaseSelectTest);
			
			JTextArea txtpnWelcomeToTest = new JTextArea();
			txtpnWelcomeToTest.setFont(new Font("Monospaced", Font.PLAIN, 20));
			txtpnWelcomeToTest.setLineWrap(true);
			txtpnWelcomeToTest.setText("welcome to test world! in here part,");
			txtpnWelcomeToTest.setBounds(434, 104, 403, 189);
			add(txtpnWelcomeToTest);
			
			comboBox = new JComboBox();
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"conditionals : if, else if , switch", "loop : while, for", "Array", "Create object and use"}));
			comboBox.setBounds(588, 440, 454, 76);
			add(comboBox);
			
			JButton btnNewButton = new JButton("back");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					win.changetomenuwindow();
				}
			});
			btnNewButton.setBounds(761, 573, 276, 76);
			add(btnNewButton);
			

			}


		
		




		}



