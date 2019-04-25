import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class KodableController {

	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	int level;
	String[]userAns = new String[10];// <------ Jeanne this is the string I commented about

	@FXML
	private ImageView ans1;

	@FXML
	private ImageView ans2;

	@FXML
	private ImageView ans3;

	@FXML
	private ImageView ans4;

	@FXML
	private ImageView down;

	@FXML
	private ImageView up;

	@FXML
	private ImageView left;

	@FXML
	private ImageView right;

	@FXML
	private ImageView fuzzy;
	
	@FXML
	private ImageView level1;

	@FXML
	private ImageView level2;
	
	@FXML
	private ImageView level3;
	
	@FXML
	void click(MouseEvent event) {// gets values for the move method

		orgSceneX = event.getSceneX();
		orgSceneY = event.getSceneY();
		orgTranslateX = ((Node) (event.getSource())).getTranslateX();
		orgTranslateY = ((Node) (event.getSource())).getTranslateY();

		switch (event.getPickResult().getIntersectedNode().getId()) {// adds drop shadow to the arrow being used and moves them to the front making them on top. 
		case "up":
			up.setEffect(new DropShadow(15, 5.0, 5.0, Color.BLACK));
			up.toFront();
			break;
		case "left":
			left.setEffect(new DropShadow(15, 5.0, 5.0, Color.BLACK));
			left.toFront();
			break;
		case "right":
			right.setEffect(new DropShadow(15, 5.0, 5.0, Color.BLACK));
			right.toFront();
			break;
		case "down":
			down.setEffect(new DropShadow(15, 5.0, 5.0, Color.BLACK));
			down.toFront();
			break;
		default:
		}

	}

	@FXML
	void move(MouseEvent event) {// makes clicked object moveable.
		double offsetX = event.getSceneX() - orgSceneX;
		double offsetY = event.getSceneY() - orgSceneY;
		double newTranslateX = orgTranslateX + offsetX;
		double newTranslateY = orgTranslateY + offsetY;

		((Node) (event.getSource())).setTranslateX(newTranslateX);
		((Node) (event.getSource())).setTranslateY(newTranslateY);
	}

	@FXML
	void copy(MouseEvent event) {// used to set the user answers on Screen and into array
		if (ans1.getImage() == null) {

			if (event.getSceneX() <= ans1.getLayoutX() + ans1.getFitWidth() && event.getSceneX() >= ans1.getLayoutX()
					&& event.getSceneY() <= ans1.getLayoutY() + ans1.getFitHeight() && event.getSceneY() >= ans1.getLayoutY()) {

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId());
				ans1.setImage(img);
				userAns[0] = event.getPickResult().getIntersectedNode().getId();//<------------------- Jeanne, this is where we are going to store the value of that array.
				
			}
		} else if (ans2.getImage() == null) {
			if (event.getSceneX() <= ans2.getLayoutX() + ans2.getFitWidth() && event.getSceneX() >= ans2.getLayoutX()
					&& event.getSceneY() <= ans2.getLayoutY() + ans2.getFitHeight() && event.getSceneY() >= ans2.getLayoutY()) {//Checks for the bounds of the imageView

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId());
				ans2.setImage(img);
				userAns[1] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans3.getImage() == null) {
			if (event.getSceneX() <= ans3.getLayoutX() + ans3.getFitWidth() && event.getSceneX() >= ans3.getLayoutX()
					&& event.getSceneY() <= ans3.getLayoutY() + ans3.getFitHeight() && event.getSceneY() >= ans3.getLayoutY()) {

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId());
				ans3.setImage(img);
				userAns[2] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans4.getImage() == null) {
			if (event.getSceneX() <= ans4.getLayoutX() + ans4.getFitWidth() && event.getSceneX() >= ans4.getLayoutX()
					&& event.getSceneY() <= ans4.getLayoutY() + ans4.getFitHeight() && event.getSceneY() >= ans4.getLayoutY()) {

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId());
				ans4.setImage(img);
				userAns[3] = event.getPickResult().getIntersectedNode().getId();
			}
		}
		resetArrows();
//		try {
//			nextLevel();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	
	  @FXML
	    void play(MouseEvent event) {
		  
	    }
	  
	  @FXML
	    void clear(MouseEvent event) {

	    }

	Image assignsImage(String dir) {// sets the image for assignment into the user answers

		switch (dir) {
		case "up":
			return up.getImage();
		case "left":
			return left.getImage();
		case "right":
			return right.getImage();
		case "down":
			return down.getImage();
		default:
			break;

		}
		return null;
	}

	void resetArrows() {// moves arrows back to set location and removes the drop shadow
		left.setTranslateX(-left.getX());
		left.setTranslateY(-left.getY());
		left.setEffect(new DropShadow(0, Color.BLACK));

		right.setTranslateX(-right.getX());
		right.setTranslateY(-right.getY());
		right.setEffect(new DropShadow(0, Color.BLACK));

		up.setTranslateX(-up.getX());
		up.setTranslateY(-up.getY());
		up.setEffect(new DropShadow(0, Color.BLACK));

		down.setTranslateX(-down.getX());
		down.setTranslateY(-down.getY());
		down.setEffect(new DropShadow(0, Color.BLACK));
	}

	void nextLevel() throws IOException {// Moves to the next level by loading the fxml file based on which level is currently being played. // should be added after the animation of prior. level
															// finishes.
		if (level1 != null) {// checks to see which level currently has a value, all other levels should not have a value. 
			Parent par = FXMLLoader.load(getClass().getResource("Test.fxml"));// needs to be replaced with level2 fxml
			Scene sn = new Scene(par);
			Stage stage = (Stage) ((Node) level1).getScene().getWindow();
			stage.setScene(sn);
			stage.show();
		} else if (level2 != null) {
			Parent par = FXMLLoader.load(getClass().getResource("Test2.fxml"));//needs to be replaced with level3 fxml
			Scene sn = new Scene(par);
			Stage stage = (Stage) ((Node) level2).getScene().getWindow();
			stage.setScene(sn);
			stage.show();
		}else if (level3 != null) {
			Parent par = FXMLLoader.load(getClass().getResource("KodableDriverTemp.fxml"));//needs to be...
			Scene sn = new Scene(par);
			Stage stage = (Stage) ((Node) level3).getScene().getWindow();
			stage.setScene(sn);
			stage.show();
		}
	}
}
