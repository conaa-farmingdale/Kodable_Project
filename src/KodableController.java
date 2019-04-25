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

		switch (event.getPickResult().getIntersectedNode().getId().toLowerCase()) {
		case "up":
			up.setEffect(new DropShadow(15, 5.0, 5.0, Color.BLACK));
			break;
		case "left":
			left.setEffect(new DropShadow(15, 5.0, 5.0, Color.BLACK));
			break;
		case "right":
			right.setEffect(new DropShadow(15, 5.0, 5.0, Color.BLACK));
			break;
		case "down":
			down.setEffect(new DropShadow(15, 5.0, 5.0, Color.BLACK));
			break;
		default:
		}

	}

	@FXML
	void move(MouseEvent event) {// makes clicked move able.
		double offsetX = event.getSceneX() - orgSceneX;
		double offsetY = event.getSceneY() - orgSceneY;
		double newTranslateX = orgTranslateX + offsetX;
		double newTranslateY = orgTranslateY + offsetY;

		((Node) (event.getSource())).setTranslateX(newTranslateX);
		((Node) (event.getSource())).setTranslateY(newTranslateY);
	}

	@FXML
	void copy(MouseEvent event) {// used to set the user answers
		if (ans1.getImage() == null) {

			if (event.getSceneX() <= ans1.getLayoutX() + 82 && event.getSceneX() >= ans1.getLayoutX()
					&& event.getSceneY() <= ans1.getLayoutY() + 82 && event.getSceneY() >= ans1.getLayoutY()) {

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId().toLowerCase());
				ans1.setImage(img);
				
			}
		} else if (ans2.getImage() == null) {
			if (event.getSceneX() <= ans2.getLayoutX() + 82 && event.getSceneX() >= ans2.getLayoutX()
					&& event.getSceneY() <= ans2.getLayoutY() + 82 && event.getSceneY() >= ans2.getLayoutY()) {

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId().toLowerCase());
				ans2.setImage(img);
			}
		} else if (ans3.getImage() == null) {
			if (event.getSceneX() <= ans3.getLayoutX() + 82 && event.getSceneX() >= ans3.getLayoutX()
					&& event.getSceneY() <= ans3.getLayoutY() + 82 && event.getSceneY() >= ans3.getLayoutY()) {

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId().toLowerCase());
				ans3.setImage(img);
			}
		} else if (ans4.getImage() == null) {
			if (event.getSceneX() <= ans4.getLayoutX() + 82 && event.getSceneX() >= ans4.getLayoutX()
					&& event.getSceneY() <= ans4.getLayoutY() + 82 && event.getSceneY() >= ans4.getLayoutY()) {

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId().toLowerCase());
				ans4.setImage(img);
				
			}
		}
		resetArrows();
		try {
			nextLevel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Image assignsImage(String dir) {// sets the image for assignment later

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

	void resetArrows() {// moves arrows back to set location
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

	void nextLevel() throws IOException {// should be added after the animation of prior. level
															// finishes.
		if (level1 != null) {
			Parent par = FXMLLoader.load(getClass().getResource("Test.fxml"));
			Scene sn = new Scene(par);
			Stage stage = (Stage) ((Node) level1).getScene().getWindow();// this line creates the new stage
			stage.setScene(sn);
			stage.show();
		} else if (level2 != null) {
			Parent par = FXMLLoader.load(getClass().getResource("Test2.fxml"));
			Scene sn = new Scene(par);
			Stage stage = (Stage) ((Node) level2).getScene().getWindow();// this line creates the new stage
			stage.setScene(sn);
			stage.show();
		}else if (level3 != null) {
			Parent par = FXMLLoader.load(getClass().getResource("KodableDriverTemp.fxml"));
			Scene sn = new Scene(par);
			Stage stage = (Stage) ((Node) level3).getScene().getWindow();// this line creates the new stage
			stage.setScene(sn);
			stage.show();
		}
	}
}
