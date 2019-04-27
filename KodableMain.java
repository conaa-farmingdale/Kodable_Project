import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class KodableMain extends Application{

	public static void main(String[] args) {
		launch (args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		 //Load splash screen	
		StackPane pane = FXMLLoader.load(getClass().getResource(("WelcomeScreen.jpg")));
		//Finish splash with fade out effect
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);
        fadeOut.play();
        
        // After splash screen fades out, load actual content
        fadeOut.setOnFinished((e) -> {
            try {        
		Parent root = FXMLLoader.load(getClass().getResource("Level_1.fxml"));
		
		Scene sn = new Scene(root,1100,800);
		primaryStage.setScene(sn);
		primaryStage.show();
            }
            catch (IOException ex) {
            Logger.getLogger(KodableController.class.getName()).log(Level.SEVERE, null, ex);
        }});
	
	}
	
}
	


