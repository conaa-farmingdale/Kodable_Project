import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
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
		orgTranslateX = ((Node)(event.getSource())).getTranslateX();
		orgTranslateY = ((Node)(event.getSource())).getTranslateY();
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
	void copy(MouseDragEvent event) {

	}
	
	@FXML
	boolean check () {
	
	String level1[] = new String[3];
	String userAns[] = new String[0];
	
	for (int i=0; i<level1.length; i++) {
	
	if(!userAns[i].equals(level1[i])) {
	return false;
	    }
	else {
		return true;
	}
	}
	return false;

}
}
