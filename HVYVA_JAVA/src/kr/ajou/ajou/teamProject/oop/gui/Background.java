package kr.ajou.ajou.teamProject.oop.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {
	protected final int SCREEN_WIDTH = 1280;
	protected final int SCREEN_HEIGHT = 720;
	protected Image background;
	private Graphics screenGraphic;	
	private Image screenImage;
	
	
	public Image BackgroundReSize(String path){
		//Resize Image  reference "http://sourcestudy.tistory.com/158"

		ImageIcon originIcon = new ImageIcon(Background.class.getResource(path)); 
		
		Image originImg = originIcon.getImage(); 


		Image changedImg= originImg.getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, Image.SCALE_SMOOTH );
		return changedImg;


	}
	
	public void paint(Graphics g) {
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	
	
	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);

		paintComponents(g);
		this.repaint();
	}
}
