package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ModuleLayer.Controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	
	private int count = 0;
	private final Label text = new Label(Integer.toString(count));
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FileInputStream input1 = new FileInputStream("/home/grabowsky/Pictures/BestMindDemo/1.jpg");
			Image image1 = new Image(input1, 1000, 1000, false, false);
			FileInputStream input2 = new FileInputStream("/home/grabowsky/Pictures/BestMindDemo/2.jpg");
			Image image2 = new Image(input2, 1000, 1000, false, false);
			
			ImageView imageView = new ImageView();
			imageView.setImage(image1);

	      //  root.getChildren().add(text);
			HBox hbox = new HBox(text, imageView);

	        Scene scene = new Scene(hbox);
	        
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	        // longrunning operation runs on different thread
	        Thread thread = new Thread(new Runnable() {

	            @Override
	            public void run() {
	                Runnable updater = new Runnable() {

	                    @Override
	                    public void run() {
	                       // incrementCount();
	                    	count++;
	            	        text.setText(Integer.toString(count));
	            	        if (count > 4)
	            	        imageView.setImage(image2);
	                    }
	                };

	                while (true) {
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException ex) {
	                    }

	                    // UI update is run on the Application thread
	                    Platform.runLater(updater);
	                }
	            }

	        });
	        // don't let thread prevent JVM shutdown
	        thread.setDaemon(true);
	        thread.start();
			
			
						
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
