package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ModuleLayer.Controller;

import application.SoundPlayer.sound;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	private int count = 0;
	private final Label lblGameTime = new Label(Integer.toString(count));
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			SoundPlayer.play(SoundPlayer.sound.BACKGROUND);
			ImageContainer.readFileInputs();
			//
			ImageView imageView = new ImageView();
			imageView.setImage(ImageContainer.backGround);
			//
			StackPane root = new StackPane();
		    root.getChildren().addAll(	imageView,
							    		lblGameTime);

	        Scene scene = new Scene(root);
	        //
	        //sceneImage.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	        // longrunning operation runs on different thread
	        Thread thread = new Thread(new Runnable() {

	            @Override
	            public void run() {
	                Runnable updater = new Runnable() {

	                    @Override
	                    public void run() {
	                       // incrementCount();
	                    	count++;
	                    	lblGameTime.setText(Integer.toString(count));
	            	        if (count > 1) {
	            	        imageView.setImage(ImageContainer.image2);
	            	        //imageView.setVisible(false);
	            	        SoundPlayer.play(SoundPlayer.sound.DOOR);
	            	        }
	                    }
	                };

	                while (true) {
	                    try {
	                        Thread.sleep(3000);
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
			
			
	        //scene.setCursor(Cursor.NONE);		
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
