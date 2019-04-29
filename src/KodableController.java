import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class KodableController {

	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	int level;
	String[] userAns = { "0", "1", "2", "3", "4", "5", "6", "7" };

	@FXML
	private ImageView ans1;

	@FXML
	private ImageView ans2;

	@FXML
	private ImageView ans3;

	@FXML
	private ImageView ans4;
	
	@FXML
	private ImageView ans5;
	
	@FXML
	private ImageView ans6;
	
	@FXML
	private ImageView ans7;

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
	private ImageView level4;

	@FXML
	private ImageView level5;

	@FXML
	private ImageView level6;

	@FXML
	private ImageView level7;

	@FXML
	private ImageView level8;

	@FXML
	private ImageView level9;
	
	@FXML
    private Pane congrats;

    @FXML
    private Pane sorry;

	@FXML
	void click(MouseEvent event) {// gets values for the move method

		orgSceneX = event.getSceneX();
		orgSceneY = event.getSceneY();
		orgTranslateX = ((Node) (event.getSource())).getTranslateX();
		orgTranslateY = ((Node) (event.getSource())).getTranslateY();

		switch (event.getPickResult().getIntersectedNode().getId()) {// adds drop shadow to the arrow being used and
																		// moves them to the front making them on top.
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
	void copy(MouseEvent event) {// used to set the user answers on Screen and into array
		if (ans1.getImage() == null) {

			if (event.getSceneX() <= ans1.getLayoutX() + ans1.getFitWidth() && event.getSceneX() >= ans1.getLayoutX()
					&& event.getSceneY() <= ans1.getLayoutY() + ans1.getFitHeight()
					&& event.getSceneY() >= ans1.getLayoutY()) {

				ans1.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[0] = event.getPickResult().getIntersectedNode().getId();

			}
		} else if (ans2.getImage() == null) {
			if (event.getSceneX() <= ans2.getLayoutX() + ans2.getFitWidth() && event.getSceneX() >= ans2.getLayoutX()
					&& event.getSceneY() <= ans2.getLayoutY() + ans2.getFitHeight()
					&& event.getSceneY() >= ans2.getLayoutY()) {// Checks for the bounds of the imageView

				ans2.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[1] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans3.getImage() == null) {
			if (event.getSceneX() <= ans3.getLayoutX() + ans3.getFitWidth() && event.getSceneX() >= ans3.getLayoutX()
					&& event.getSceneY() <= ans3.getLayoutY() + ans3.getFitHeight()
					&& event.getSceneY() >= ans3.getLayoutY()) {

				ans3.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[2] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans4.getImage() == null) {
			if (event.getSceneX() <= ans4.getLayoutX() + ans4.getFitWidth() && event.getSceneX() >= ans4.getLayoutX()
					&& event.getSceneY() <= ans4.getLayoutY() + ans4.getFitHeight()
					&& event.getSceneY() >= ans4.getLayoutY()) {
				
				ans4.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[3] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans5.getImage() == null) { // below Implemented by Matt, having issues with github
			if (event.getSceneX() <= ans5.getLayoutX() + ans5.getFitWidth() && event.getSceneX() >= ans5.getLayoutX()
					&& event.getSceneY() <= ans5.getLayoutY() + ans5.getFitHeight()
					&& event.getSceneY() >= ans5.getLayoutY()) {
				
				ans5.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[4] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans6.getImage() == null) {
			if (event.getSceneX() <= ans6.getLayoutX() + ans6.getFitWidth() && event.getSceneX() >= ans6.getLayoutX()
					&& event.getSceneY() <= ans6.getLayoutY() + ans6.getFitHeight()
					&& event.getSceneY() >= ans6.getLayoutY()) {
				
				ans6.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[5] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans7.getImage() == null) {
			if (event.getSceneX() <= ans7.getLayoutX() + ans7.getFitWidth() && event.getSceneX() >= ans7.getLayoutX()
					&& event.getSceneY() <= ans7.getLayoutY() + ans7.getFitHeight()
					&& event.getSceneY() >= ans7.getLayoutY()) {
				
				ans7.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[6] = event.getPickResult().getIntersectedNode().getId();
			}
		}
		resetArrows();
		
	}
	
	@FXML
	void move(MouseEvent event) {// makes clicked object move-able.
		double offsetX = event.getSceneX() - orgSceneX;
		double offsetY = event.getSceneY() - orgSceneY;
		double newTranslateX = orgTranslateX + offsetX;
		double newTranslateY = orgTranslateY + offsetY;

		((Node) (event.getSource())).setTranslateX(newTranslateX);
		((Node) (event.getSource())).setTranslateY(newTranslateY);
	}

	@FXML
	void play(MouseEvent event) throws IOException {// When play is clicked this checks the level, then the given array and if its
									// correct moves the fuzzy. Implemented by Matt

		if (level1 != null) {
			String levelAns[] = { "right", "up", "right" };

			if (check(levelAns)) {
				SequentialTransition lvl1 = new SequentialTransition(setParMove(2, 0, 2), setParMove(0, -1, 1),
						setParMove(6, 0, 6));
				lvl1.play();
				lvl1.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level2 != null) {
			String levelAns[] = { "right", "down", "right", "down", "right", "down", "right" };

			if (check(levelAns)) {
				SequentialTransition lvl2 = new SequentialTransition(setParMove(1, 0, 1), setParMove(0, 1, 1),
						setParMove(1, 0, 1), setParMove(0, 1, 1), setParMove(3, 0, 3), setParMove(0, 1, 1),
						setParMove(2, 0, 2));
				lvl2.play();
				lvl2.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level3 != null) {
			String levelAns[] = { "up", "right", "up", "right", "down", "right" };

			if (check(levelAns)) {
				SequentialTransition lvl3 = new SequentialTransition(setParMove(0, -2, 2), setParMove(1, 0, 1),
						setParMove(0, -1, 1), setParMove(2, 0, 2), setParMove(0, 3, 3), setParMove(4, 0, 4));
				lvl3.play();
				lvl3.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level4 != null) {
			String levelAns[] = { "down", "right", "up", "right" };

			if (check(levelAns)) {
				SequentialTransition lvl4 = new SequentialTransition(setParMove(0, 2, 2), setParMove(4, 0, 4),
						setParMove(0, -1, 1), setParMove(3, 0, 3));
				lvl4.play();
				lvl4.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level5 != null) {
			String levelAns[] = { "right", "down", "right", "up", "right" };

			if (check(levelAns)) {
				SequentialTransition lvl5 = new SequentialTransition(setParMove(2, 0, 2), setParMove(0, 1, 1),
						setParMove(3, 0, 3), setParMove(0, -3, 3), setParMove(2, 0, 2));
				lvl5.play();
				lvl5.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level6 != null) {
			String levelAns[] = { "right", "up", "right", "up", "right" };

			if (check(levelAns)) {
				SequentialTransition lvl6 = new SequentialTransition(setParMove(1, 0, 1), setParMove(0, -2, 2),
						setParMove(4, 0, 4), setParMove(0, -1, 1), setParMove(2, 0, 2));
				lvl6.play();
				lvl6.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level7 != null) {
			String levelAns[] = { "right", "up", "right", "down", "right" };

			if (check(levelAns)) {
				SequentialTransition lvl7 = new SequentialTransition(setParMove(2, 0, 2), setParMove(0, -2, 2),
						setParMove(2, 0, 2), setParMove(0, 2, 2), setParMove(3, 0, 3));
				lvl7.play();
				lvl7.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level8 != null) {
			String levelAns[] = { "right", "up", "right", "up", "right", "down", "right" };

			if (check(levelAns)) {
				SequentialTransition lvl8 = new SequentialTransition(setParMove(1, 0, 1), setParMove(0, -1, 1),
						setParMove(1, 0, 1), setParMove(0, -1, 1), setParMove(3, 0, 3), setParMove(0, 2, 2),
						setParMove(2, 0, 2));
				lvl8.play();
				lvl8.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level9 != null) {
			String levelAns[] = { "right", "down", "right", "down", "right", "up", "right" };

			if (check(levelAns)) {
				SequentialTransition lvl9 = new SequentialTransition(setParMove(2, 0, 2), setParMove(0, 2, 2),
						setParMove(1, 0, 1), setParMove(0, 1, 1), setParMove(2, 0, 2), setParMove(0, -2, 2),
						setParMove(2, 0, 2));
				lvl9.play();
				lvl9.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		}
	}


    @FXML
    void quit(MouseEvent event) {

    }
	
	ParallelTransition setParMove(int x, int y, int r) {// sets individual ParallelTransitioin to move the Fuzzy.
														// Implemented by Matt
		Duration duration = Duration.seconds(1);
		TranslateTransition move = new TranslateTransition(duration, fuzzy);
		RotateTransition rotate = new RotateTransition(duration, fuzzy);
		move.setByX(138 * x);
		move.setByY(138 * y);
		rotate.setByAngle(360 * r);
		return new ParallelTransition(move, rotate);
	}

	@FXML
	void clear(MouseEvent event) {  //clears input from userAns array and resets them to starting values
		 ans1.setImage(null);
		 ans2.setImage(null);
		 ans3.setImage(null);
		 ans4.setImage(null);
		 ans5.setImage(null);
		 ans6.setImage(null);
		 ans7.setImage(null);
		 sorry.setVisible(false);
		 congrats.setVisible(false);
		
		for (int i = 0; i < userAns.length; i++) {
			userAns[i] = "1";
		}
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
		congrats.toFront();
        sorry.toFront();
        }

	boolean check(String array[]) {
		
		for (int i = 0; i < array.length; i++) {
			if (!userAns[i].equals(array[i])) {
				return false;
			} 
		}
		return true;
	}

	@FXML
    void nextLevel(MouseEvent event) throws IOException {// Moves to the next level by loading the fxml file based on which level is
											// currently being played. // should be added after the animation of prior.
											// level
											// finishes.
		if (level1 != null) {// checks to see which level currently has a value, all other levels should not
								// have a value.
			Parent par = FXMLLoader.load(getClass().getResource("Level_1.fxml"));// needs to be replaced with level2 fxml
			Scene sn = new Scene(par);
			Stage stage = (Stage) ((Node) fuzzy).getScene().getWindow();
			stage.setScene(sn);
			stage.show();
		} else if (level2 != null) {
			Parent par = FXMLLoader.load(getClass().getResource("Test2.fxml"));// needs to be replaced with level3 fxml
			Scene sn = new Scene(par);
			Stage stage = (Stage) ((Node) fuzzy).getScene().getWindow();
			stage.setScene(sn);
			stage.show();
		} else if (level3 != null) {
			Parent par = FXMLLoader.load(getClass().getResource("KodableDriverTemp.fxml"));// needs to be...
			Scene sn = new Scene(par);
			Stage stage = (Stage) ((Node) fuzzy).getScene().getWindow();
			stage.setScene(sn);
			stage.show();
		}
	}
}
