import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
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
	String[] userAns = { "0", "1", "2", "3", "4", "5", "6", "7" };

	@FXML
	private ImageView ans1, ans2, ans3, ans4, ans5, ans6, ans7; // Answer Boxes

	@FXML
	private ImageView down, up, left, right; // Arrows

	@FXML
	private ImageView fuzzy; // Fuzzy guy

	@FXML
	private ImageView welcome, level1, level2, level3, level4, level5, level6, level7, level8, level9; // Levels

	@FXML
	private Pane congrats, sorry; // Overlay screens

	@FXML // clears input from userAns array and resets them to starting values
	void clear(MouseEvent event) {

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

	@FXML // gets values for the move method
	void click(MouseEvent event) {

		orgSceneX = event.getSceneX();
		orgSceneY = event.getSceneY();
		orgTranslateX = ((Node) (event.getSource())).getTranslateX();
		orgTranslateY = ((Node) (event.getSource())).getTranslateY();

		switch (event.getPickResult().getIntersectedNode().getId()) {// adds drop shadow to the arrow being clicked and
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

	@FXML // used to set the user answers on Screen and into array and copy onto screen
	void copy(MouseEvent event) {
		
		// checks weather the ImageView is loaded allowing for it to be written to. This
		// applies to all that follow
		if (ans1.getImage() == null) {
			if (checkBounds(event, ans1)) {
				// sets the ImageView based on the current image being dragged. This applies to
				// all that follow
				ans1.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				// saves Id value into userAns for future validation. This applies to all that
				// follow
				userAns[0] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans2.getImage() == null) {
			if (checkBounds(event, ans2)) {
				ans2.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[1] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans3.getImage() == null) {
			if (checkBounds(event, ans3)) {
				ans3.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[2] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans4.getImage() == null) {
			if (checkBounds(event, ans4)) {
				ans4.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[3] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans5.getImage() == null) { // below Implemented by Matt, having issues with github
			if (checkBounds(event, ans5)) {
				ans5.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[4] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans6.getImage() == null) {
			if (checkBounds(event, ans6)) {
				ans6.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[5] = event.getPickResult().getIntersectedNode().getId();
			}
		} else if (ans7.getImage() == null) {
			if (checkBounds(event, ans7)) {
				ans7.setImage(assignsImage(event.getPickResult().getIntersectedNode().getId()));
				userAns[6] = event.getPickResult().getIntersectedNode().getId();
			}
		}
		// returns arrows after release of button
		resetArrows();
	}

	@FXML // loads HowToPlay fxml when user presses How To Play button
	void howTo(MouseEvent event) throws IOException {

		Parent par = FXMLLoader.load(getClass().getResource("HowToPlay.fxml"));
		Scene sn = new Scene(par);
		Stage stage = new Stage();
		stage.setTitle("How to Play");
		stage.setScene(sn);
		stage.show();
	}

	@FXML // Allows fuzzy to appear as if it has jumped by scaling and returning to
			// orginal position
	void jump(MouseEvent event) {
		
		ScaleTransition scale = new ScaleTransition(Duration.seconds(1), fuzzy);
		scale.setByX(.3);
		scale.setByY(.3);
		scale.setCycleCount(2);
		scale.setAutoReverse(true);
		fuzzy.setEffect(new DropShadow(15, 5.0, 5.0, Color.BLACK));
		scale.play();
		scale.setOnFinished(e -> fuzzy.setEffect(new DropShadow(0, 0, 0, Color.BLACK)));
	}

	@FXML // makes clicked object move-able.
	void move(MouseEvent event) {

		double offsetX = event.getSceneX() - orgSceneX;
		double offsetY = event.getSceneY() - orgSceneY;
		double newTranslateX = orgTranslateX + offsetX;
		double newTranslateY = orgTranslateY + offsetY;

		((Node) (event.getSource())).setTranslateX(newTranslateX);
		((Node) (event.getSource())).setTranslateY(newTranslateY);
	}

	@FXML // Moves to the next level by loading the fxml file based on which level is
			// currently being played.
	void nextLevel(MouseEvent event) throws IOException {
		
		// checks to see which level currently has a value, all other levels should not
		// have a value.
		if (welcome != null) {
			levelSelect("Level_1", welcome);
		} else if (level1 != null) {
			levelSelect("Level_2");
		} else if (level2 != null) {
			levelSelect("Level_3");
		} else if (level3 != null) {
			levelSelect("Level_4");
		} else if (level4 != null) {
			levelSelect("Level_5");
		} else if (level5 != null) {
			levelSelect("Level_6");
		} else if (level6 != null) {
			levelSelect("Level_7");
		} else if (level7 != null) {
			levelSelect("Level_8");
		} else if (level8 != null) {
			levelSelect("Level_9");
		} else if (level9 != null) {
			levelSelect("Level_1");
		}
	}

	@FXML // Creates Parallel Transitions to rotate and translate then puts those into a
			// Sequential Transition. Applied to the fuzzy Image. Implemented by Matt
	void play(MouseEvent event) throws IOException {
		
		// Checks the current level
		if (level1 != null) {
			String levelAns[] = { "right", "up", "right" };
			// Checks if levelAns is equal to the userAns. This applies to all that follow
			if (checkAns(levelAns)) {
				SequentialTransition lvl = new SequentialTransition(setParMove(2, 0, 2), setParMove(0, -1, 1),
						setParMove(6, 0, 6));
				lvl.play();
				// After the transition makes the congrats pane visible allowing user to go to
				// next level. This applies to all that follow
				lvl.setOnFinished(e -> congrats.setVisible(true));
			} else {
				// if the transition doesn't play the sorry pane is displayed allowing user to
				// reset or quit. This applies to all that follow
				sorry.setVisible(true);
			}
		} else if (level2 != null) {
			String levelAns[] = { "right", "up", "right", "up", "right", "down", "right" };
			if (checkAns(levelAns)) {
				SequentialTransition lvl = new SequentialTransition(setParMove(1, 0, 1), setParMove(0, -1, 1),
						setParMove(1, 0, 1), setParMove(0, -1, 1), setParMove(3, 0, 3), setParMove(0, 2, 2),
						setParMove(3, 0, 3));
				lvl.play();
				lvl.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level3 != null) {
			String levelAns[] = { "up", "right", "up", "right", "down", "right" };
			if (checkAns(levelAns)) {
				SequentialTransition lvl = new SequentialTransition(setParMove(0, -2, 2), setParMove(1, 0, 1),
						setParMove(0, -1, 1), setParMove(2, 0, 2), setParMove(0, 3, 3), setParMove(5, 0, 5));
				lvl.play();
				lvl.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level4 != null) {
			String levelAns[] = { "down", "right", "up", "right" };
			if (checkAns(levelAns)) {
				SequentialTransition lvl = new SequentialTransition(setParMove(0, 2, 2), setParMove(4, 0, 4),
						setParMove(0, -1, 1), setParMove(4, 0, 4));
				lvl.play();
				lvl.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level5 != null) {
			String levelAns[] = { "right", "down", "right", "up", "right" };
			if (checkAns(levelAns)) {
				SequentialTransition lvl = new SequentialTransition(setParMove(2, 0, 2), setParMove(0, 1, 1),
						setParMove(3, 0, 3), setParMove(0, -3, 3), setParMove(3, 0, 3));
				lvl.play();
				lvl.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level6 != null) {
			String levelAns[] = { "right", "up", "right", "up", "right" };
			if (checkAns(levelAns)) {
				SequentialTransition lvl = new SequentialTransition(setParMove(1, 0, 1), setParMove(0, -2, 2),
						setParMove(4, 0, 4), setParMove(0, -1, 1), setParMove(3, 0, 3));
				lvl.play();
				lvl.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level7 != null) {
			String levelAns[] = { "right", "up", "right", "down", "right" };
			if (checkAns(levelAns)) {
				SequentialTransition lvl = new SequentialTransition(setParMove(2, 0, 2), setParMove(0, -2, 2),
						setParMove(2, 0, 2), setParMove(0, 2, 2), setParMove(4, 0, 4));
				lvl.play();
				lvl.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level8 != null) {
			String levelAns[] = { "right", "down", "right", "down", "right", "down", "right" };
			if (checkAns(levelAns)) {
				SequentialTransition lvl = new SequentialTransition(setParMove(1, 0, 1), setParMove(0, 1, 1),
						setParMove(1, 0, 1), setParMove(0, 1, 1), setParMove(3, 0, 3), setParMove(0, 1, 1),
						setParMove(3, 0, 3));
				lvl.play();
				lvl.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		} else if (level9 != null) {
			String levelAns[] = { "right", "down", "right", "down", "right", "up", "right" };
			if (checkAns(levelAns)) {
				SequentialTransition lvl = new SequentialTransition(setParMove(2, 0, 2), setParMove(0, 2, 2),
						setParMove(1, 0, 1), setParMove(0, 1, 1), setParMove(2, 0, 2), setParMove(0, -2, 2),
						setParMove(3, 0, 3));
				lvl.play();
				lvl.setOnFinished(e -> congrats.setVisible(true));
			} else {
				sorry.setVisible(true);
			}
		}
	}

	@FXML // quits the program
	void quit(MouseEvent event) {
		
		System.exit(0);
	}

	// sets individual ParallelTransitioin to move the Fuzzy. Implemented by Matt
	ParallelTransition setParMove(int x, int y, int r) {
		
		Duration duration = Duration.seconds(1);
		TranslateTransition move = new TranslateTransition(duration, fuzzy);
		RotateTransition rotate = new RotateTransition(duration, fuzzy);
		move.setByX(138 * x);
		move.setByY(138 * y);
		rotate.setByAngle(360 * r);
		return new ParallelTransition(move, rotate);
	}

	// sets the image for assignment into the user answers based on the passed
	// variable
	Image assignsImage(String dir) {

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

	//Compares passed array to userAns array if any of the answers don't match it returns false
	boolean checkAns(String array[]) {

		for (int i = 0; i < array.length; i++) {
			if (!userAns[i].equals(array[i])) {
				return false;
			}
		}
		return true;
	}

	// Checks if the MouseEvent is within the ImageView that is passed into the
	// method
	Boolean checkBounds(MouseEvent event, ImageView box) {

		if (event.getSceneX() <= box.getLayoutX() + box.getFitWidth() && event.getSceneX() >= box.getLayoutX()
				&& event.getSceneY() <= box.getLayoutY() + box.getFitHeight()
				&& event.getSceneY() >= box.getLayoutY()) {
			return true;
		}
		return false;
	}

	// takes passed variable and loads and displays that fxml as long as it exists.
	void levelSelect(String level) throws IOException {

		Parent par = FXMLLoader.load(getClass().getResource(level + ".fxml"));
		Scene sn = new Scene(par);
		Stage stage = (Stage) ((Node) fuzzy).getScene().getWindow();
		stage.setTitle("Kodable " + level);
		stage.setScene(sn);
		stage.show();
	}

	// takes passed variable and loads and displays that fxml as long as it exists
	// and gets the window for the img. used once in code
	void levelSelect(String level, ImageView img) throws IOException {

		Parent par = FXMLLoader.load(getClass().getResource(level + ".fxml"));
		Scene sn = new Scene(par);
		Stage stage = (Stage) ((Node) img).getScene().getWindow();
		stage.setTitle("Kodable " + level);
		stage.setScene(sn);
		stage.show();
	}

	// moves arrows back to set location and removes the drop shadow and sets the
	// panes forward to be above the arrows
	void resetArrows() {

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
}