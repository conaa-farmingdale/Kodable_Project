import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KodableMain extends Application{

	public static void main(String[] args) {
		launch (args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
		
		Scene sn = new Scene(root,1100,800);
		primaryStage.setTitle("Welcome");
		primaryStage.setScene(sn);
		primaryStage.show();
	}
	
	
	
}
