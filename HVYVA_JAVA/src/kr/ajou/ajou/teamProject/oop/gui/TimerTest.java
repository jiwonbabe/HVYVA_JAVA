package kr.ajou.ajou.teamProject.oop.gui;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.event.*; 
import java.util.*; 

public class TimerTest extends JPanel implements ActionListener 

{ 
      Calendar calendar1 = Calendar.getInstance(); 
      int hour = calendar1.get(Calendar.HOUR_OF_DAY); 
      int min = calendar1.get(Calendar.MINUTE); 
      int sec = calendar1.get(Calendar.SECOND); 
      int starthour = calendar1.get(Calendar.HOUR_OF_DAY);
      int startmin = calendar1.get(Calendar.MINUTE);
      int startsec = calendar1.get(Calendar.SECOND); 
      javax.swing.Timer timer; 
      JLabel lbPresent,lbPresent1,time; 

      public TimerTest() 

      { 
            timer = new javax.swing.Timer(1000, this); 
            timer.setInitialDelay(0); 
            timer.start(); 

            lbPresent = new JLabel(); 
            add(lbPresent); 
            lbPresent1 = new JLabel(); 
            add(lbPresent1); 
  
            time = new JLabel();
            add(time);
      } 

      public void actionPerformed(ActionEvent e) 

      { 
            Calendar calendar2 = Calendar.getInstance(); 
            hour = calendar2.get(Calendar.HOUR_OF_DAY); 
            min = calendar2.get(Calendar.MINUTE); 
            sec = calendar2.get(Calendar.SECOND); 
            int runtime = hour*3600 - starthour*3600 + min*60 - startmin*60 + sec-startsec; 
     
            time.setText("\n경과시간: "+runtime/3600+"hour"+(runtime%3600)/60+"min"+(runtime%3600)%60+"sec");
      } 

      private static void createAndShowGUI() 

      { 
            JFrame.setDefaultLookAndFeelDecorated(true); 
            JFrame frame = new JFrame("TimerTest"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            TimerTest timerTest = new TimerTest(); 
            timerTest.setOpaque(true); 
            frame.setContentPane(timerTest); 
            frame.pack(); 
            frame.setVisible(true); 
      } 

      public static void main(String[] args) 

      { 
            javax.swing.SwingUtilities.invokeLater(new Runnable() {public void run(){createAndShowGUI();}}); 
      } 
} 

 
