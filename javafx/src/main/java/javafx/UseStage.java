package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UseStage extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vBox = new VBox(new Label("A JavaFX Label"));
		Scene scene = new Scene(vBox); // scene represent content displaied inside the window
		
		Stage stage = new Stage(); // stage represent a window
		stage.setScene(scene);
		stage.setX(350);
		stage.setY(350);
		stage.setWidth(600);
		stage.setHeight(300);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
