import java.util.concurrent.TimeUnit;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class KodableMain extends Application{
	
	// Splash screen to be used in start method, added by Kathleen
		 SplashScreenController spashScreen = new SplashScreenController();
	
	public void start(Stage primaryStage) throws Exception {
        
        // Load actual content
		Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));		
		Scene sn = new Scene(root,1100,800);
		primaryStage.setTitle("Welcome");
		primaryStage.setScene(sn);
		
		//Show the splash screen
		spashScreen.showWindow();
		// Display splash screen for 2 seconds, then load main application
		PauseTransition splashScreenDelay = new PauseTransition(Duration.seconds(3));
		splashScreenDelay.setOnFinished(f -> {
		    primaryStage.show();
		    // Close the splash screen
		    spashScreen.hideWindow();
		});
		splashScreenDelay.playFromStart();
		
	}
	
	public static void main(String[] args) {
		
		
		launch (args);
	}
	
	
	
}
	


