package kr.ajou.ajou.teamProject.oop.gui;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class mark {
	private String rightAnswer;
	private String userAnswer;
	

	public String getrightAnswer(){
		return rightAnswer;
	}
	

	public void setrightAnswer(int TestNum){
		if(TestNum <1){
			System.out.println("setrightAnswer argument error");
			return;
		}
		
	
    FileReader fr;
	try {
		fr = new FileReader("mark"+TestNum+".txt");
    BufferedReader br = new BufferedReader(fr);
    
	rightAnswer= "";
	String str = null;
    while((str = br.readLine()) != null){
    	rightAnswer += str;
    }
    
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "mark " + TestNum + " file is not found","ERROR",JOptionPane.ERROR_MESSAGE);
	} 
}

	public String getUserAnswer() {
		return userAnswer;
	}


	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}


	public void domarking(){
	if(userAnswer.replaceAll("\\s","").equals(rightAnswer.replaceAll("\\s",""))){
		JOptionPane.showMessageDialog(null, "                    YOU RIGHT","CONGRETULATION!",JOptionPane.PLAIN_MESSAGE);
	}
	else{
		JOptionPane.showMessageDialog(null, "WRONG","WRONG",JOptionPane.ERROR_MESSAGE);
	}
	}
}
