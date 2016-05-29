import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import java.util.Optional;
import javafx.animation.*;
import javafx.util.Duration;

	public class DisplayClock extends Application {
		String timeString;
		Label lblCurrentTime;
		ClockPane clock;
		Timeline animation;
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
	// Create a clock and a label
	clock = new ClockPane();
	timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
	lblCurrentTime = new Label(timeString);
	
	// Place clock and label in border pane
	BorderPane pane = new BorderPane();
	pane.setCenter(clock);
	pane.setBottom(lblCurrentTime);
	BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
	
		animation = new Timeline(new KeyFrame(Duration.millis(10), e -> {
					clock = new ClockPane();
					timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
					lblCurrentTime = new Label(timeString);
						pane.setCenter(clock);
						pane.setBottom(lblCurrentTime);
						BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
		}));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();


	// Create a scene and place it in the stage
	Scene scene = new Scene(pane, 250, 250);
	primaryStage.setTitle("DisplayClock"); // Set the stage title
	primaryStage.setScene(scene); // Place the scene in the stage
	primaryStage.show(); // Display the stage
	}
	}