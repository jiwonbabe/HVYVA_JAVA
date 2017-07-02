package kr.ajou.oop.team.Project.etc;

import java.util.ArrayList;

public class Course {

   private String titleImage; 
   private String startImage; 
   private String gameImage; 
   private String startMusic; 
   private String gameMusic; 
   private String selectedText;
   private String youtubeVideo;
    public ArrayList textList;
   
   public ArrayList gettextList(){
      
      return textList;
      
   }
   
   public void settextList(){
      
      this.textList=textList;
      
   }
   
   
   public String getYoutubeVideo(){
      
      return youtubeVideo;
      
   }
   
   public void setYoutubeVideo(){
      
      this.youtubeVideo=youtubeVideo;
      
   }
   
   
   public String getSelectedText(){
      
      return selectedText;
      
   }
   
   public void setSelectedText(){
      
      this.selectedText=selectedText;
      
   }
   
   public String getTitleImage() {
      return titleImage;
   }
   public void setTitleImage(String titleImage) {
      this.titleImage = titleImage;
   }
   public String getStartImage() {
      return startImage;
   }
   public void setStartImage(String startImage) {
      this.startImage = startImage;
   }
   public String getGameImage() {
      return gameImage;
   }
   public void setGameImage(String gameImage) {
      this.gameImage = gameImage;
   }
   public String getStartMusic() {
      return startMusic;
   }
   public void setStartMusic(String startMusic) {
      this.startMusic = startMusic;
   }
   public String getGameMusic() {
      return gameMusic;
   }
   public void setGameMusic(String gameMusic) {
      this.gameMusic = gameMusic;
   }
   
   public Course(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic,String selectedText,String youtubeVideo,ArrayList textList) {
      super();
      this.titleImage = titleImage;
      this.startImage = startImage;
      this.gameImage = gameImage;
      this.startMusic = startMusic;
      this.gameMusic = gameMusic;
      this.selectedText=selectedText;
      this.youtubeVideo=youtubeVideo;
      this.textList=textList;
      
   }
   
}