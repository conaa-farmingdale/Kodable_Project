
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// This is the class for the splash screen of the application
public class SplashScreenController extends StackPane {

    @FXML
    private ImageView imageView;

    // -------------------------------------------------------------

    // Logger
    private Logger logger = Logger.getLogger(getClass().getName());

   // Window of the splash screen
    Stage window = new Stage();

    // Constructor
    public SplashScreenController() {

		// FXML Loader 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SplashScreenController.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		
			try {
			    loader.load();
			} catch (IOException ex) {
			    logger.log(Level.SEVERE, "", ex);
			}
		
		// Window for splash screen
		window.setTitle("Splash Screen");
		//window.getIcons().add(new Image(getClass().getResourceAsStream("WelcomeScreen.jpg")))
		window.initStyle(StageStyle.TRANSPARENT);
		window.setScene(new Scene(this));	
	
	    }
	
	  // Shows the window of the splash screen
	    public void showWindow() {
		window.show();
	    }
	
	   // Hides the window of the splash screen
	    public void hideWindow() {
		window.hide();
	    }



}
