package kr.ajou.ajou.teamProject.oop.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import kr.ajou.ajou.teamProject.oop.gui.Music;
import kr.ajou.oop.team.Project.etc.Course;
import kr.ajou.oop.teamProject.database.DBConnection;


public class CodeEducation extends Background {

   private Image screenImage;
   private Graphics screenGraphic;
   
   private ImageIcon exitButtonEnteredImage = new ImageIcon(Background.class.getResource("/images/exitButtonEntered.png"));
   private ImageIcon exitButtonBasicImage = new ImageIcon(Background.class.getResource("/images/exitButtonBasic.png"));
   private ImageIcon startButtonEnteredImage = new ImageIcon(Background.class.getResource("/images/startButtonEntered.png"));
   private ImageIcon startButtonBasicImage = new ImageIcon(Background.class.getResource("/images/startButtonBasic.png"));
   private ImageIcon quitButtonEnteredImage = new ImageIcon(Background.class.getResource("/images/quitButtonBasic.png"));
   private ImageIcon quitButtonBasicImage = new ImageIcon(Background.class.getResource("/images/quitButtonBasic.png"));
   private ImageIcon leftButtonEnteredImage = new ImageIcon(Background.class.getResource("/images/leftButtonEntered.png"));
   private ImageIcon leftButtonBasicImage = new ImageIcon(Background.class.getResource("/images/leftButtonBasic.png"));
   private ImageIcon rightButtonEnteredImage = new ImageIcon(Background.class.getResource("/images/rightButtonEntered.png"));
   private ImageIcon rightButtonBasicImage = new ImageIcon(Background.class.getResource("/images/rightButtonBasic.png"));
   private ImageIcon easyButtonEnteredImage = new ImageIcon(Background.class.getResource("/images/easyButtonEntered.png"));
   private ImageIcon easyButtonBasicImage = new ImageIcon(Background.class.getResource("/images/easyButtonBasic.png"));
   private ImageIcon hardButtonEnteredImage = new ImageIcon(Background.class.getResource("/images/hardButtonEntered.png"));
   private ImageIcon hardButtonBasicImage = new ImageIcon(Background.class.getResource("/images/hardButtonBasic.png"));
   private ImageIcon backButtonEnteredImage = new ImageIcon(Background.class.getResource("/images/backButtonEnterted.png"));
   private ImageIcon backButtonBasicImage = new ImageIcon(Background.class.getResource("/images/backButtonBasic.png"));

      private ImageIcon textleftButtonBasicImage = new ImageIcon(Background.class.getResource("/images/leftButtonBasic.png"));
      private ImageIcon textrightButtonBasicImage = new ImageIcon(Background.class.getResource("/images/rightButtonBasic.png"));
      private ImageIcon homeButtonImage=new ImageIcon(Background.class.getResource("/images/home-button.png"));
      private ImageIcon finishButtonImage=new ImageIcon(Background.class.getResource("/images/finishButton.png"));
   
   
   
   private Image background = new ImageIcon(Background.class.getResource("/images/introBackground(Title).jpg"))
         .getImage();
   private JLabel menuBar = new JLabel(new ImageIcon(Background.class.getResource("/images/menuBar.png")));

   private JButton exitButton = new JButton(exitButtonBasicImage);
   private JButton startButton = new JButton(startButtonBasicImage);
   private JButton quitButton = new JButton(quitButtonBasicImage);
   private JButton leftButton = new JButton(leftButtonBasicImage);
   private JButton rightButton = new JButton(rightButtonBasicImage);
   private JButton easyButton = new JButton(easyButtonBasicImage);
   private JButton hardButton = new JButton(hardButtonBasicImage);
   private JButton backButton = new JButton(backButtonBasicImage);
    private JButton textleftButton = new JButton(textleftButtonBasicImage);
      private JButton textrightButton = new JButton(textrightButtonBasicImage);
      private JButton homeButton=new JButton(homeButtonImage);
      private JButton finishButton=new JButton(finishButtonImage);
   
   private int mouseX, mouseY;
   
   private boolean isMainScreen = false;
   private boolean isGameScreen=false;
   
   
   ArrayList<String> textList1 = new ArrayList<String>();
      ArrayList<String> textList2 = new ArrayList<String>();
      ArrayList<String> textList3 = new ArrayList<String>();
      private int textSelected=0;
      private ArrayList<String> title = new ArrayList<String>();
   
   ArrayList<Course> CourseList = new ArrayList<Course>();
   private Image selectedText;
   private Image titleImage;
   private Image selectedImage;
   private Music selectedMusic;
   private int nowSelected = 0;
   
   public CodeEducation(PanelChanger win) {


      setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
      setBackground(new Color(0, 0, 0, 0));
      setLayout(null);

      title.add("Ready to Java");
      title.add("Basic Grammer");
      title.add("Class and Object");
      
      textList1.add("1-1.PNG");
         textList1.add("1-2.PNG");
         textList1.add("1-3.PNG");
         textList2.add("2-1.PNG");
         textList2.add("2-2.PNG");
         textList2.add("2-3.PNG");
         textList3.add("3-1.PNG");
         textList3.add("3-2.PNG");
         textList3.add("3-3.PNG");


      CourseList.add(new Course("1 Title.png", "1.png",
            "Mighty Love Game Image.jpg", "Mighty Love Selected.mp3", "Joakim Karud - Mighty Love.mp3","1_1.PNG","https://youtu.be/Hl-zzrqQoSE?list=PLFE2CE09D83EE3E28",textList1));
      CourseList.add(new Course("2 Title.png", "2.png",
            "Wild Flower Game Image.jpg", "Wild Flower Selected.mp3", "Joakim Karud - Wild Flower.mp3","1_2.PNG","https://www.youtube.com/watch?v=5u8rFbpdvds&list=PLFE2CE09D83EE3E28&index=2",textList2));
      CourseList.add(new Course("3 Title.png", "3.png",
            "Energy Game Image.png", "Energy Selected.mp3", "Bensound - Energy.mp3","1_3.PNG","https://www.youtube.com/watch?v=PAaqgTr7Cx4&list=PLFE2CE09D83EE3E28&index=11",textList3));
      
      exitButton.setBounds(1245, 0, 30, 30);
      exitButton.setBorderPainted(false);
      exitButton.setContentAreaFilled(false);
      exitButton.setFocusPainted(false);
      exitButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            exitButton.setIcon(exitButtonEnteredImage);
            exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }
         @Override
         public void mouseExited(MouseEvent e) {
            exitButton.setIcon(exitButtonBasicImage);
            exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
            buttonEnteredMusic.start();
            try {
               Thread.sleep(1000);
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
            System.exit(0);
         }
      });
      add(exitButton);
      finishButton.setVisible(false);
         finishButton.setBounds(655, 580, 250, 67);
         finishButton.setBorderPainted(false);
         finishButton.setContentAreaFilled(false);
         finishButton.setFocusPainted(false);
         finishButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               finishButton.setIcon(finishButtonImage);
               finishButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
               Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
               buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
               finishButton.setIcon(finishButtonImage);
               finishButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
               Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
               buttonEnteredMusic.start();
               

            int progressDataNum=0;
            
            long time = System.currentTimeMillis(); 
            SimpleDateFormat dayTime = new SimpleDateFormat("yyyy,MM,dd,hh,mm,ss");

            String str = dayTime.format(new Date(time));
            
            //str1 : 강의 끝낸 시간.
            String[] line = str.split(",");
            //년도, 월, 일 로 문자열 파싱.
            String finishYear = line[0];
            String finishMonth = line[1];
            String finishDate = line[2];
            String lecture_name = title.get(textSelected);
            
            ++progressDataNum;
            DBConnection connection = new DBConnection();
            connection.saveUserProgressInDB(finishYear, finishMonth, finishDate, String.valueOf(progressDataNum), lecture_name);
            
               
            }
         });
         add(finishButton);
      
      startButton.setBounds(40, 200, 400, 100);
      startButton.setBorderPainted(false);
      startButton.setContentAreaFilled(false);
      startButton.setFocusPainted(false);
      startButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            startButton.setIcon(startButtonEnteredImage);
            startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }
         @Override
         public void mouseExited(MouseEvent e) {
            startButton.setIcon(startButtonBasicImage);
            startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
            buttonEnteredMusic.start();
            //win.introMusic.close();
            enterMain();
         
         }
      });
      add(startButton);
      
      homeButton.setVisible(true);
         homeButton.setBounds(1080, 580, 100, 100);
         homeButton.setBorderPainted(false);
         homeButton.setContentAreaFilled(false);
         homeButton.setFocusPainted(false);
         homeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               homeButton.setIcon(homeButtonImage);
               homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
               Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
               buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
               homeButton.setIcon(homeButtonImage);
               homeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

         @Override
            public void mousePressed(MouseEvent e) {

   
                
               Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
     
               buttonEnteredMusic.start();
               if(selectedMusic!=null)
               selectedMusic.close();

               win.introMusic = new Music("intro.mp3", true);
               win.introMusic.start();
               win.changetomenuwindow();
            
            }
         });
         add(homeButton);
         
         textleftButton.setVisible(false);
         textleftButton.setBounds(140, 310, 60, 60);
         textleftButton.setBorderPainted(false);
         textleftButton.setContentAreaFilled(false);
         textleftButton.setFocusPainted(false);
         textleftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               textleftButton.setIcon(textleftButtonBasicImage);
               textleftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
               Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
               buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
               textleftButton.setIcon(textleftButtonBasicImage);
               leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
      
               Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
               buttonEnteredMusic.start();
               selectTextLeft();

            }
         });
         add(textleftButton);
         
         
         textrightButton.setVisible(false);
         textrightButton.setBounds(1080, 310, 60, 60);
         textrightButton.setBorderPainted(false);
         textrightButton.setContentAreaFilled(false);
         textrightButton.setFocusPainted(false);
         textrightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               textrightButton.setIcon(textrightButtonBasicImage);
               textrightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
               Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
               buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
               textleftButton.setIcon(textrightButtonBasicImage);
               leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
               Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
               buttonEnteredMusic.start();
               selectTextRight();
            }
         });
         add(textrightButton);
         


      quitButton.setBounds(40, 330, 400, 100);
      quitButton.setBorderPainted(false);
      quitButton.setContentAreaFilled(false);
      quitButton.setFocusPainted(false);
      quitButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            quitButton.setIcon(quitButtonEnteredImage);
            quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }
         @Override
         public void mouseExited(MouseEvent e) {
            quitButton.setIcon(quitButtonBasicImage);
            quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
            buttonEnteredMusic.start();
            try {
               Thread.sleep(1000);
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
            System.exit(0);
         }
      });
      add(quitButton);
      
      leftButton.setVisible(false);
      leftButton.setBounds(140, 310, 60, 60);
      leftButton.setBorderPainted(false);
      leftButton.setContentAreaFilled(false);
      leftButton.setFocusPainted(false);
      leftButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            leftButton.setIcon(leftButtonEnteredImage);
            leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }
         @Override
         public void mouseExited(MouseEvent e) {
            leftButton.setIcon(leftButtonBasicImage);
            leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
            buttonEnteredMusic.start();
            selectLeft();
         }
      });
      add(leftButton);

      rightButton.setVisible(false);
      rightButton.setBounds(1080, 310, 60, 60);
      rightButton.setBorderPainted(false);
      rightButton.setContentAreaFilled(false);
      rightButton.setFocusPainted(false);
      rightButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            rightButton.setIcon(rightButtonEnteredImage);
            rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }
         @Override
         public void mouseExited(MouseEvent e) {
            rightButton.setIcon(rightButtonBasicImage);
            rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
            buttonEnteredMusic.start();
            selectRight();
         }
      });
      add(rightButton);
      
      easyButton.setVisible(false);
      easyButton.setBounds(550, 580, 250, 67);
      easyButton.setBorderPainted(false);
      easyButton.setContentAreaFilled(false);
      easyButton.setFocusPainted(false);
      easyButton.addMouseListener(new MouseAdapter() {
         
         
         @Override
         public void mouseEntered(MouseEvent e) {
            easyButton.setIcon(easyButtonEnteredImage);
            easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
         }
         @Override
         public void mouseExited(MouseEvent e) {
            easyButton.setIcon(easyButtonBasicImage);
            easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
            buttonEnteredMusic.start();
            gameStart(nowSelected, "easy");
         }
      });
      add(easyButton);

      
      backButton.setVisible(false);
      backButton.setBounds(20, 50, 100, 100);
      backButton.setBorderPainted(false);
      backButton.setContentAreaFilled(false);
      backButton.setFocusPainted(false);
      backButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            backButton.setIcon(backButtonEnteredImage);
            backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
            buttonEnteredMusic.start();
            //메인화면으로 돌아가는 이벤트 
         }
         @Override
         public void mouseExited(MouseEvent e) {
            backButton.setIcon(backButtonBasicImage);
            backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
            buttonEnteredMusic.start();
            gameStart(nowSelected, "hard");
            backMain();

         }
      });
      add(backButton);
      
      
      menuBar.setBounds(0, 0, 1280, 30);
      menuBar.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
         }
      });
      menuBar.addMouseMotionListener(new MouseMotionAdapter() {
         @Override
         public void mouseDragged(MouseEvent e) {
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            setLocation(x - mouseX, y - mouseY);
         }
      });
      add(menuBar);
   }

   @Override
   public void paint(Graphics g) {
      screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
      screenGraphic = screenImage.getGraphics();
      screenDraw(screenGraphic);
      g.drawImage(screenImage, 0, 0, null);
   }

   
   @Override
   public void screenDraw(Graphics g) {
      g.drawImage(background, 0, 0, null);
      if(isMainScreen)
      {
         g.drawImage(selectedImage, 340, 100, null);
         g.drawImage(titleImage, 340, 70, null);
      }
      if(isGameScreen){
         g.drawImage(selectedText, 340, 100, null);

      }
      paintComponents(g);
      this.repaint();
   }
   
   
   
   public void selectCourse(int nowSelected) {
      if(selectedMusic != null)
         selectedMusic.close();
      titleImage = new ImageIcon(Background.class.getResource("/images/" + CourseList.get(nowSelected).getTitleImage())).getImage();
      selectedImage = new ImageIcon(Background.class.getResource("/images/" + CourseList.get(nowSelected).getStartImage())).getImage();
      selectedMusic = new Music(CourseList.get(nowSelected).getStartMusic(), true);
      selectedMusic.start();
      
   }
   
   public void selectText(int textSelected){
         
         selectedText=new ImageIcon(Background.class.getResource("/images/" + CourseList.get(nowSelected).gettextList().get(textSelected))).getImage();

      }

   
   public void selectLeft() {
      if(nowSelected == 0)
         nowSelected = CourseList.size() - 1;
      else
         nowSelected--;
      selectCourse(nowSelected);
   }
   
   public void selectRight() {
      if(nowSelected == CourseList.size() - 1)
         nowSelected = 0;
      else
         nowSelected++;
      selectCourse(nowSelected);
   }
   
   public void selectTextLeft() {
         if(textSelected == 0)
            textSelected = CourseList.get(nowSelected).textList.size() - 1;
         else
            textSelected--;
         selectText(textSelected);
      }
      public void selectTextRight() {
         if(textSelected == 0)
            textSelected = CourseList.get(nowSelected).textList.size() - 1;
         else
            textSelected--;
         selectText(textSelected);
      }

   
   public void gameStart(int nowSelected, String difficulty) {
      if(selectedMusic != null)
            selectedMusic.close();
         isMainScreen = false;
         isGameScreen=true;
         leftButton.setVisible(false);
         rightButton.setVisible(false);
         easyButton.setVisible(false);
         hardButton.setVisible(false);
         background = new ImageIcon(Background.class.getResource("/images/" + CourseList.get(nowSelected).getGameImage()))
               .getImage();
         selectedText=new ImageIcon(Background.class.getResource("/images/" + CourseList.get(nowSelected).gettextList().get(textSelected))).getImage();
      
         backButton.setVisible(true);
         textrightButton.setVisible(true);
         textleftButton.setVisible(true);
         finishButton.setVisible(true);
   }
   
   public void backMain(){
       isMainScreen=true;
         leftButton.setVisible(true);
         rightButton.setVisible(true);
         easyButton.setVisible(true);
         hardButton.setVisible(true);
         background = new ImageIcon(Background.class.getResource("/images/mainBackground.jpg"))
               .getImage();
         backButton.setVisible(false);
         selectCourse(nowSelected);
         isGameScreen=false;
         textrightButton.setVisible(false);
         textleftButton.setVisible(false);
         homeButton.setVisible(true);
         finishButton.setVisible(false);
      
      
   }
   public void enterMain(){
      startButton.setVisible(false);
         quitButton.setVisible(false);
         background = new ImageIcon(Background.class.getResource("/images/mainBackground.jpg"))
               .getImage();
         isMainScreen = true;
         isGameScreen=false;
         
         leftButton.setVisible(true);
         rightButton.setVisible(true);
         easyButton.setVisible(true);
         hardButton.setVisible(true);

         selectCourse(0);
         isGameScreen=true;
         textrightButton.setVisible(false);
         textleftButton.setVisible(false);
         homeButton.setVisible(true);


   }

}