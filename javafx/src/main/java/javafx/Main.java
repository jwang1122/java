package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author John Q. Wang
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world Application");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);

//        InputStream iconStream = getClass().getResourceAsStream("/icon.png");
//        Image image = new Image(iconStream);
//        primaryStage.getIcons().add(image);

        Label l = new Label("Hello world!");
//        TextField txt = new TextField("Hello, world.");
        HBox box = new HBox(l);
        Scene primaryScene = new Scene(box, 600, 400);
        primaryStage.setScene(primaryScene);

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}