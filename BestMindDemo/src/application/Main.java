package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {

	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FileInputStream input = new FileInputStream("/home/grabowsky/Pictures/BestMindDemo/ur.jpg");
			Image image = new Image(input, 1920, 1080, false, false);
			ImageView imageView = new ImageView(image);

			
			HBox hbox = new HBox(imageView);

	        Scene scene = new Scene(hbox);
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
