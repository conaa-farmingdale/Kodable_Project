/****************************************************************************
   This is the group project for team StruggleBus.
 
    This program is for a simple game that teaches simple coding instructions.
 ****************************************************************************
 */

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;  
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class GameGroupProject1 extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			Image img=new Image("Spokes2.png");
			ImageView iv=new ImageView(img);
			Group grp = new Group(iv);
			Scene sn = new Scene(grp, 900,900);
			sn.getStylesheets().add("mystyle.css");
			primaryStage.setScene(sn);
			primaryStage.show();	
			
			/* Start the game by displaying the character and moving
			   it to the middle left position.*/
			
			RotateTransition rt=new RotateTransition(new Duration(2000), iv);
			TranslateTransition tt=new TranslateTransition(new Duration(2000), iv);
			tt.setFromX(10);tt.setFromY(10);
			tt.setToX(10);tt.setToY(300);
			rt.setFromAngle(0);;
			rt.setToAngle(1080);
			rt.setCycleCount(1);
					
			rt.play();
			tt.play();
		
	}
	
	public static void main(String[] args) {
		launch (args);
	}
}
