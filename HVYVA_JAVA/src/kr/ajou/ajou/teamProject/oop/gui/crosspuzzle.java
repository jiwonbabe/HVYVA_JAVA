package kr.ajou.ajou.teamProject.oop.gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;

public class crosspuzzle extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private ArrayList<JButton> Switch = new ArrayList<JButton>();
	private ArrayList<JButton> API = new ArrayList<JButton>();
	private ArrayList<JButton> Scanner = new ArrayList<JButton>();
	private ArrayList<JButton> Array = new ArrayList<JButton>();
	private ArrayList<JButton> Polymorphism = new ArrayList<JButton>();
	private ArrayList<JButton> Private = new ArrayList<JButton>();
	private ArrayList<JButton> Final = new ArrayList<JButton>();
	private ArrayList<JButton> Overriding = new ArrayList<JButton>();
	private ArrayList<JButton> Gui = new ArrayList<JButton>();
	private ArrayList<JButton> Method = new ArrayList<JButton>();
	private ArrayList<JButton> Static = new ArrayList<JButton>();
	private ArrayList<JButton> Object = new ArrayList<JButton>();
	private ArrayList<JButton> Thread = new ArrayList<JButton>();
	private ArrayList<JButton> Modifier = new ArrayList<JButton>();
	private ArrayList<JButton> Class = new ArrayList<JButton>();
	private ArrayList<JButton> Overroading = new ArrayList<JButton>();
	String answer;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crosspuzzle frame = new crosspuzzle(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void setbutton(final ArrayList<JButton> array, final String Question, final String ans,int i){ //setting button method
			contentPane.add(array.get(i));
			array.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(Question);
					
					answer = ans;
				}
			});
			array.get(i).addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent e) {
					if(array.get(0).isEnabled())
					for(int j =0; j<array.size(); j++)
						array.get(j).setBackground(Color.red);
				}

			
				public void mouseExited(MouseEvent e) {
					for(int j =0; j<array.size(); j++)
						array.get(j).setBackground(Color.getColor(null));
				}
			});
			}
	public void fillblank(){
		
	}
		
	
	public crosspuzzle(PanelChanger win) {

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1200, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
	//setting button and answer
		String a = "Allows a variable to be tested for equality against a list of values.";
		for(int i =0; i<6; i++){
			Switch.add(new JButton());
			Switch.get(i).setBounds(60+60*i,0, 60, 60);
			setbutton(Switch,a,"SWITCH",i);
		}
		
		String b = "A collection of prewritten packages, classes, and interfaces with their respective methods, fields and constructors.";
		for(int i =0; i<3; i++){
			API.add(new JButton());
			API.get(i).setBounds(60+60*i,120, 60, 60);
			setbutton(API,b,"API", i);
		
			}
		
		String c = "Allows the user to read values of various types.";
		for(int i =0; i<7; i++){
			Scanner.add(new JButton());
			Scanner.get(i).setBounds(60,60*i, 60, 60);
			setbutton(Scanner,c,"SCANNER", i);
		}
			
		String d = "The ability of an object to take many forms.";
		for(int i =0; i<12; i++){
			Polymorphism.add(new JButton());
			Polymorphism.get(i).setBounds(240,180+60*i, 60, 60);
			setbutton(Polymorphism,d,"POLYMORPHISM", i);
			
			}
		
		String e = "Can only be accessed within the declared class itself.";
		for(int i =0; i<7; i++){
			Private.add(new JButton());
			Private.get(i).setBounds(540,180+60*i, 60, 60);
			setbutton(Private,e,"PRIVATE", i);
			
			}
			
		String f = "Tells the compiler that subclasses may not override a method regardless of its access level.";
		for(int i =0; i<5; i++){
			Final.add(new JButton());
			Final.get(i).setBounds(780,180+60*i, 60, 60);
			setbutton(Final,f,"FINAL", i);
			
			}
			
		String g = "Be used to provide specific implementation of a method that is already provided by its super class.";
		for(int i =0; i<10; i++){
			Overriding.add(new JButton());
			Overriding.get(i).setBounds(360+60*i,240, 60, 60);
			setbutton(Overriding,g,"OVERRIDING", i);
			
			}
		
		String h = "A type of user interface that allows users to interact through graphical icons and visual indicators.";
		for(int i =0; i<3; i++){
			Gui.add(new JButton());
			Gui.get(i).setBounds(900,240+60*i, 60, 60);
			setbutton(Gui,h,"GUI", i);
			
		}
		
		String ii = "Be used to store a collection of data.";
		for(int i =0; i<5; i++){
			Array.add(new JButton());
			Array.get(i).setBounds(60*i,360, 60, 60);
			setbutton(Array,ii,"ARRAY", i);
			
			}
		
		String j = "A procedure associated with a message and an object.";
		for(int i =0; i<6; i++){
			Method.add(new JButton());
			Method.get(i).setBounds(60*7,420+60*i, 60, 60);
			setbutton(Method,j,"METHOD", i);
			
			}

		String k = "A member variable, or method, can be accessed without requiring an instantiation of the class to which it belongs.";
		for(int i =0; i<6; i++){
			Static.add(new JButton());
			Static.get(i).setBounds(60,480+60*i, 60, 60);
			setbutton(Static,k,"STATIC", i);
			
			}
		
		String l = "A software bundle of variables and related methods.";
		for(int i =0; i<6; i++){
			Object.add(new JButton());
			Object.get(i).setBounds(240+60*i,480, 60, 60);
			setbutton(Object,l,"OBJECT", i);
			
			}
			
		String m = "The path followed when executing a program.";
		for(int i =0; i<6; i++){
			Thread.add(new JButton());
			Thread.get(i).setBounds(60*13,540+60*i, 60, 60);
			setbutton(Thread,m,"THREAD", i);
			
			}
			
		String n = "Provides static methods and constants to decode class and member access modifiers.";
		for(int i =0; i<8; i++){
			Modifier.add(new JButton());
			Modifier.get(i).setBounds(60*6+60*i,60*11, 60, 60);
			setbutton(Modifier,n,"MODIFIER", i);
			
			}
			
		String o = "The blueprint from which individual objects are created.";
		for(int i =0; i<5; i++){
			Class.add(new JButton());
			Class.get(i).setBounds(60+60*i,60*13, 60, 60);
			setbutton(Class,o,"CLASS", i);
			
			}
			
		String p = "A feature that allows a class to have two or more methods having same name,";
		for(int i =0; i<11; i++){
			Overroading.add(new JButton());
			Overroading.get(i).setBounds(60*6+60*i,60*14, 60, 60);
			setbutton(Overroading,p,"OVERROADING", i);
			
			}
		

		
		JPanel panel = new JPanel();
		panel.setBounds(972, 13, 198, 707);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setColumns(20);
		textArea.setRows(100);
		textArea.setFont(new Font("Footlight MT Light", Font.PLAIN, 19));
		textArea.setEditable(false);
		textArea.setBounds(12, 56, 174, 269);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {         
			public void actionPerformed(ActionEvent e) {
				try{
				if(answer.equals(textField.getText().toUpperCase())){    // if user submit right answer
				
					switch(answer){
					
					case"SWITCH":
						for(int i=0; i<Switch.size(); i++){
						Switch.get(i).setText(Character.toString(answer.charAt(i)));
						Switch.get(i).setEnabled(false);
						}
						Scanner.get(0).setText("S");
						Switch.get(0).setBounds(0, 0, 0, 0);
						break;
						
					case"API":
						for(int i=0; i<API.size(); i++){
							
						API.get(i).setText(Character.toString(answer.charAt(i)));
						API.get(i).setEnabled(false);
						}
						Scanner.get(2).setText("A");
						API.get(0).setBounds(0, 0, 0, 0);
						break;
						
					
				case "SCANNER":
					for(int i=0; i<Scanner.size(); i++){
						
					Scanner.get(i).setText(Character.toString(answer.charAt(i)));
					Scanner.get(i).setEnabled(false);
					}
					
					API.get(0).setText("A");
					Switch.get(0).setText("S");
					Array.get(1).setText("R");
					Scanner.get(0).setBounds(0, 0, 0, 0);
					Scanner.get(2).setBounds(0, 0, 0, 0);
					Scanner.get(6).setBounds(0, 0, 0, 0);
					break;
					
				case "ARRAY":
					for(int i=0; i<Array.size(); i++){
						
					Array.get(i).setText(Character.toString(answer.charAt(i)));
					Array.get(i).setEnabled(false);
					}
					Scanner.get(6).setText("R");
					Polymorphism.get(3).setText("Y");
					Array.get(1).setBounds(0, 0, 0, 0);
					Array.get(4).setBounds(0, 0, 0, 0);
					break;
					
				case "POLYMORPHISM":
					for(int i=0; i<Polymorphism.size(); i++){
						
					Polymorphism.get(i).setText(Character.toString(answer.charAt(i)));
					Polymorphism.get(i).setEnabled(false);
					}
					Array.get(4).setText("Y");
					Object.get(0).setText("O");
					Class.get(3).setText("S");
					Polymorphism.get(3).setBounds(0, 0, 0, 0);
					Polymorphism.get(10).setBounds(0, 0, 0, 0);
					break;
					
				case "PRIVATE":
					for(int i=0; i<Private.size(); i++){
						
					Private.get(i).setText(Character.toString(answer.charAt(i)));
					Private.get(i).setEnabled(false);
					}
					Overriding.get(3).setText("R");
					Object.get(5).setText("T");
					Private.get(1).setBounds(0, 0, 0, 0);
					Private.get(5).setBounds(0, 0, 0, 0);
					break;
					
				case "FINAL":
					for(int i=0; i<Final.size(); i++){
						
					Final.get(i).setText(Character.toString(answer.charAt(i)));
					Final.get(i).setEnabled(false);
					}
					Overriding.get(7).setText("I");
					Final.get(1).setBounds(0, 0, 0, 0);
					break;
					
				case "OVERRIDING":
					for(int i=0; i<Overriding.size(); i++){
						
					Overriding.get(i).setText(Character.toString(answer.charAt(i)));
					Overriding.get(i).setEnabled(false);
					}
					Private.get(1).setText("R");
					Final.get(1).setText("I");
					Overriding.get(3).setBounds(0, 0, 0, 0);
					Overriding.get(7).setBounds(0, 0, 0, 0);
					Overriding.get(9).setBounds(0, 0, 0, 0);
					break;
					
				case "GUI":
					for(int i=0; i<Gui.size(); i++){
						
					Gui.get(i).setText(Character.toString(answer.charAt(i)));
					Gui.get(i).setEnabled(false);
					}
					Overriding.get(9).setText("G");
					Gui.get(0).setBounds(0, 0, 0, 0);
					break;
					
				case "METHOD":
					for(int i=0; i<Method.size(); i++){
						
					Method.get(i).setText(Character.toString(answer.charAt(i)));
					Method.get(i).setEnabled(false);
					}
					Object.get(4).setText("E");
					Modifier.get(1).setText("O");
					Method.get(1).setBounds(0, 0, 0, 0);
					Method.get(4).setBounds(0, 0, 0, 0);
					break;
					
				case "STATIC":
					for(int i=0; i<Static.size(); i++){
						
					Static.get(i).setText(Character.toString(answer.charAt(i)));
					Static.get(i).setEnabled(false);
					}
					Class.get(0).setText("C");
					Static.get(5).setBounds(0, 0, 0, 0);
					break;
					
				case "OBJECT":
					for(int i=0; i<Object.size(); i++){
						
					Object.get(i).setText(Character.toString(answer.charAt(i)));
					Object.get(i).setEnabled(false);
					}
					Polymorphism.get(5).setText("O");
					Method.get(1).setText("E");
					Private.get(5).setText("T");
					Object.get(0).setBounds(0, 0, 0, 0);
					Object.get(3).setBounds(0, 0, 0, 0);
					Object.get(5).setBounds(0, 0, 0, 0);
					break;
					
				case "THREAD":
					for(int i=0; i<Thread.size(); i++){
						
					Thread.get(i).setText(Character.toString(answer.charAt(i)));
					Thread.get(i).setEnabled(false);
					}
					Modifier.get(8).setText("E");
					Overroading.get(8).setText("D");
					Thread.get(2).setBounds(0, 0, 0, 0);
					Thread.get(5).setBounds(0, 0, 0, 0);
					break;
					
				case "MODIFIER":
					for(int i=0; i<Modifier.size(); i++){
						
					Modifier.get(i).setText(Character.toString(answer.charAt(i)));
					Modifier.get(i).setEnabled(false);
					}
					Method.get(4).setText("O");
					Thread.get(2).setText("R");
					Modifier.get(1).setBounds(0, 0, 0, 0);
					Modifier.get(8).setBounds(0, 0, 0, 0);
					break;
					
				case "CLASS":
					for(int i=0; i<Class.size(); i++){
						
					Class.get(i).setText(Character.toString(answer.charAt(i)));
					Class.get(i).setEnabled(false);
					}
					Static.get(5).setText("C");
					Polymorphism.get(10).setText("S");
					Class.get(0).setBounds(0, 0, 0, 0);
					Class.get(3).setBounds(0, 0, 0, 0);
					break;
					
				case "OVERROADING":
					for(int i=0; i<Overroading.size(); i++){
						
					Overroading.get(i).setText(Character.toString(answer.charAt(i)));
					Overroading.get(i).setEnabled(false);
					}
					Thread.get(5).setText("D");
					Overroading.get(7).setBounds(0, 0, 0, 0);
					break;
					
					}
			
				}
				 // if user submit wrong answer
				else{
					JOptionPane.showConfirmDialog(null, "Try again!", "Error Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
				}
				textField.setText("");
				textArea.setText("");

				}catch(NullPointerException e1){
					JOptionPane.showConfirmDialog(null, "Try again!", "Error Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
				}
			}
				
		});
		btnNewButton.setBounds(24, 449, 162, 46);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(12, 375, 174, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(22, 522, 164, 57);
		panel.add(btnNewButton_1);
	}
}
