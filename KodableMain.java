import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class KodableMain extends Application{

	public static void main(String[] args) {
		launch (args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("KodableDriverTemp.fxml"));
		
		//controller arrow buttons
		Image upArrowImg=new Image("UpArrowBtn.jpg");
		ImageView upArrow=new ImageView(upArrowImg);
		Image downArrowImg=new Image("DownArrowBtn.jpg");
		ImageView downArrow=new ImageView(downArrowImg);
		Image rightArrowImg=new Image("RightArrowBtn.jpg");
		ImageView rightArrow=new ImageView(rightArrowImg);
		Image leftArrowImg=new Image("LeftArrowBtn.jpg");
		ImageView leftArrow=new ImageView(leftArrowImg);
		Image playBtnImg=new Image("PlayBtn.jpg");
		ImageView playBtn=new ImageView(playBtnImg);
		
        playBtn.setOnAction(actionEvent ->
        {
            List<Timeline> timeLines = new ArrayList();//This List will hold the TimeLines so that it can be used later to play the animation in order.

            for (ToggleButton tempToggleButton : order)//Create a press animation and a release animation for each ToggleButton in the List order
            {
                KeyFrame pressButton = new KeyFrame(Duration.seconds(1),
                        (kfActionEvent) ->
                {
                    System.out.println(tempToggleButton.getText() + "Selected!");
                    tempToggleButton.setSelected(true);
                });
                Timeline pressTimeline = new Timeline();
                pressTimeline.getKeyFrames().addAll(pressButton);
                timeLines.add(pressTimeline);

                KeyFrame releaseButton = new KeyFrame(Duration.seconds(1),
                        (kfActionEvent) ->
                {
                    System.out.println(tempToggleButton.getText() + "Unselected!");
                    tempToggleButton.setSelected(false);
                });
                Timeline releaseTimeline = new Timeline();
                releaseTimeline.getKeyFrames().addAll(releaseButton);
                timeLines.add(releaseTimeline);
            }
		
		Scene sn = new Scene(root,1100,800);
		//sn.getStylesheets().add("mystyle.css");
		primaryStage.setScene(sn);
		primaryStage.show();
		
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(timeLines);//Add all the Timelines created to a SequentialTransition
        sequentialTransition.play();
        sequentialTransition.setOnFinished(stActionEvent -> {
            timeLines.clear();//Once done, clear the animations
	}
	
	
	
}
