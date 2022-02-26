package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	

	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			/*FileInputStream input = new FileInputStream("/home/grabowsky/Pictures/BestMindDemo/ur.jpg");
			Image image = new Image(input, 1920, 1080, false, false);
			ImageView imageView = new ImageView(image);
			imageView.setImage(image);*/
			FileInputStream input1 = new FileInputStream("/home/grabowsky/Pictures/BestMindDemo/1.jpg");
			Image image1 = new Image(input1, 1000, 1000, false, false);
			FileInputStream input2 = new FileInputStream("/home/grabowsky/Pictures/BestMindDemo/2.jpg");
			Image image2 = new Image(input2, 1000, 1000, false, false);
			
			ImageView imageView = new ImageView();
			imageView.setImage(image1);
			
			Button button = new Button("Click");

	        button.setOnAction(value ->  {
	           imageView.setImage(image2);
	        });
			
			
			HBox hbox = new HBox(button, imageView);

	        Scene scene = new Scene(hbox);
			primaryStage.setScene(scene);
			//primaryStage.setFullScreen(true);
			primaryStage.setMaximized(true);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		launch(args);
				
	}
}
