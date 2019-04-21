import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class KodableController {

	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;

	@FXML
	private ImageView move1;

	@FXML
	private ImageView move2;

	@FXML
	private ImageView move3;

	@FXML
	private ImageView move4;

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
	void click(MouseEvent event) {

		orgSceneX = event.getSceneX();
		orgSceneY = event.getSceneY();
		orgTranslateX = ((Node) (event.getSource())).getTranslateX();
		orgTranslateY = ((Node) (event.getSource())).getTranslateY();
	}

	@FXML
	void move(MouseEvent event) {
		double offsetX = event.getSceneX() - orgSceneX;
		double offsetY = event.getSceneY() - orgSceneY;
		double newTranslateX = orgTranslateX + offsetX;
		double newTranslateY = orgTranslateY + offsetY;

		((Node) (event.getSource())).setTranslateX(newTranslateX);
		((Node) (event.getSource())).setTranslateY(newTranslateY);
	}

	@FXML
	void copy(MouseEvent event) {
		if (move1.getImage() == null) {

			if (event.getSceneX() <= move1.getLayoutX() + 82 && event.getSceneX() >= move1.getLayoutX()
					&& event.getSceneY() <= move1.getLayoutY() + 82 && event.getSceneY() >= move1.getLayoutY()) {

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId().toLowerCase());
				move1.setImage(img);
			}
		} else if (move2.getImage() == null) {
			if (event.getSceneX() <= move2.getLayoutX() + 82 && event.getSceneX() >= move2.getLayoutX()
					&& event.getSceneY() <= move2.getLayoutY() + 82 && event.getSceneY() >= move2.getLayoutY()) {

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId().toLowerCase());
				move2.setImage(img);
			}
		} else if (move3.getImage() == null) {
			if (event.getSceneX() <= move3.getLayoutX() + 82 && event.getSceneX() >= move3.getLayoutX()
					&& event.getSceneY() <= move3.getLayoutY() + 82 && event.getSceneY() >= move3.getLayoutY()) {

				Image img = assignsImage(event.getPickResult().getIntersectedNode().getId().toLowerCase());
				move3.setImage(img);
			}
		}
		resetArrows();
	}// make method called reset
		// make method for setting setImage

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

	void resetArrows() {// moves arrows back to set location
		left.setTranslateX(-left.getX());
		left.setTranslateY(-left.getY());
		right.setTranslateX(-right.getX());
		right.setTranslateY(-right.getY());
		up.setTranslateX(-up.getX());
		up.setTranslateY(-up.getY());
		down.setTranslateX(-down.getX());
		down.setTranslateY(-down.getY());
	}

}
