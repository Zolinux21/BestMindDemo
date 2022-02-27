package application;

import java.io.FileInputStream;

import javafx.scene.image.Image;


public class ImageContainer {
	
	class ratio{
		static int X = 1920;
		static int Y = 1080;
	}
	
	private static FileInputStream backGroundInput;
	private static FileInputStream input1;
	private static FileInputStream input2;
	private static FileInputStream input3;
	
	public static Image backGround;
	public static Image image1;
	public static Image image2;
	public static Image image3;
	
	// reed files location
	static void readFileInputs() {
		try {
			
			backGroundInput = new FileInputStream("/home/grabowsky/Pictures/BestMindDemo/backGround.jpg");
			input1 = new FileInputStream("/home/grabowsky/Pictures/BestMindDemo/1.jpg");
			input2 = new FileInputStream("/home/grabowsky/Pictures/BestMindDemo/2.jpg");
			input3 = new FileInputStream("/home/grabowsky/Pictures/BestMindDemo/3.jpg");
			
			backGround = new Image(backGroundInput, ratio.X, ratio.Y, false, false);
			image1 = new Image(input1, ratio.X, ratio.Y, false, false);
			image2 = new Image(input2, ratio.X, ratio.Y, false, false);
			image3 = new Image(input3, ratio.X, ratio.Y, false, false);
				
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}	
	}
	 
	 

}
