
package kr.ajou.oop.team.Project.etc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.ajou.oop.teamProject.database.DBConnection;

import java.text.SimpleDateFormat;

public class SwingCalender extends JFrame implements ActionListener {

	String [] days = {"일","월","화","수","목","금","토"};
	String [] studied = new String[1000];
    int year ,month,day,todays,memoday=0;
    Font f;
    Color bc,fc;
    Calendar today;
    Calendar cal;
    JButton btnBefore,btnAfter;
    JButton[] calBtn = new JButton[49];
    JLabel thing;
    JLabel time;
    JPanel panWest;
    JPanel panNorth;
    JTextField txtMonth,txtYear;
    JTextField txtTime;
    BorderLayout bLayout= new BorderLayout();  
    String [] date;
    String [] lecture_num;
	DBConnection connection = new DBConnection();
    ////////////////////////////////////////
    public SwingCalender(){
    	
  
 
          today = Calendar.getInstance(); 
          cal = new GregorianCalendar();
          year = today.get(Calendar.YEAR);
          month = today.get(Calendar.MONTH)+1;
          
          panNorth = new JPanel();
          
          panNorth.add(btnBefore = new JButton("Before"));            
          panNorth.add(txtYear = new JTextField(year+"년"));
          panNorth.add(txtMonth = new JTextField( month+"월",3));
          txtYear.setEnabled(false);
          txtMonth.setEnabled(false);
          
          panNorth.add(btnAfter = new JButton("After"));
          f=new Font("Sherif",Font.BOLD,18);
          txtYear.setFont(f);
          txtMonth.setFont(f);       
          add(panNorth,"North");
          
          panWest = new JPanel(new GridLayout(7,7));
          f=new Font("Sherif",Font.BOLD,12);
          gridInit();
          calSet();
          hideInit();
          add(panWest,"Center");
          
          btnBefore.addActionListener(this);
          btnAfter.addActionListener(this);       
          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          setTitle("Schedule");
          setBounds(0, 0,400,300);          
         

          setVisible(true);

    }//end constuctor
    
    
    public void calSet(){
          cal.set(Calendar.YEAR,year);
          cal.set(Calendar.MONTH,(month-1));
          cal.set(Calendar.DATE,1);
          int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
          
          int j=0;
          int hopping=0;
          calBtn[0].setForeground(new Color(255,0,0));
          calBtn[6].setForeground(new Color(0,0,255));
          for(int i=cal.getFirstDayOfWeek();i<dayOfWeek;i++){  j++;  }
          hopping=j;
          for(int kk=0;kk<hopping;kk++){
                 calBtn[kk+7].setText("");
          }
          for(int i=cal.getMinimum(Calendar.DAY_OF_MONTH);
                        i<=cal.getMaximum(Calendar.DAY_OF_MONTH);i++){
              cal.set(Calendar.DATE,i);
                 if(cal.get(Calendar.MONTH) !=month-1){
                        break;
                 }
           
                 todays=i;
		            if(memoday==1){
                        calBtn[i+6+hopping].setForeground(new Color(0,255,0));                         
                 }
                 else{
                        calBtn[i+6+hopping].setForeground(new Color(0,0,0));
                        if((i+hopping-1)%7==0){
                              calBtn[i+6+hopping].setForeground(new Color(255,0,0));
                        }
                        if((i+hopping)%7==0){
                              calBtn[i+6+hopping].setForeground(new Color(0,0,255));
                        }
                 }
		        
                 calBtn[i+6+hopping].setText((i)+"");
          }//for
    }//end Calset()
    
    
    public void actionPerformed(ActionEvent ae){         
         if(ae.getSource() == btnBefore){
                 this.panWest.removeAll();
                 calInput(-1);
                 gridInit();
                 panelInit();               
                 calSet();
                 hideInit();
                 this.txtYear.setText(year+"��");
                 this.txtMonth.setText(month+"��");                   
          }                   
          else if(ae.getSource() == btnAfter){
                 this.panWest.removeAll();
                 calInput(1);
                 gridInit();
                 panelInit();
                 calSet();
                 hideInit();
                 this.txtYear.setText(year+"��");
                 this.txtMonth.setText(month+"��");                                       
          }
        else if(Integer.parseInt(ae.getActionCommand()) >= 1 && 
                 Integer.parseInt(ae.getActionCommand()) <=31){
        			
    			if(!connection.saveUserProgressInCal(year,month,Integer.parseInt(ae.getActionCommand())).equals(""))
    				JOptionPane.showMessageDialog(null, "You have studied"+" "+ connection.saveUserProgressInCal(year,month,Integer.parseInt(ae.getActionCommand())));
    				else
    					JOptionPane.showMessageDialog(null, "You have studied nothing"+ connection.saveUserProgressInCal(year,month,Integer.parseInt(ae.getActionCommand())));


        		
        		
          }

   }//end actionperformed()
    
    
    public void hideInit(){
         for(int i = 0 ; i < calBtn.length;i++){
                 if((calBtn[i].getText()).equals(""))
                        calBtn[i].setEnabled(false);
                
          }//end for
    }//end hideInit()

    public void gridInit(){
      for(int i = 0 ; i < days.length;i++)
		   {
           panWest.add(calBtn[i] = new JButton(days[i]));
			  calBtn[i].setContentAreaFilled(false);
			  calBtn[i].setBorderPainted(false);
			  calBtn[i].addActionListener(this);
		   }	
			  for(int i = days.length ; i < 49;i++){                
                 panWest.add(calBtn[i] = new JButton(""));                   
                 calBtn[i].addActionListener(this);
          }              
    }//end gridInit()
	   public void panelInit(){
      GridLayout gridLayout1 = new GridLayout(7,7);
      panWest.setLayout(gridLayout1);   
    }//end panelInit()
    public void calInput(int gap){
          month+=(gap);
          if (month<=0){
                        month = 12;
                        year  =year- 1;
          }else if (month>=13){
                        month = 1;
                        year =year+ 1;
          }
    }//end calInput()
    

}//end class
