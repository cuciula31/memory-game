package data;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;

import static javafx.application.Application.launch;

public class Main extends Application {

    private static double xOffset = 0;
    private static double yOffset = 0;

    public static void main(String[] args) throws FileNotFoundException {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String FXML_PATH = "main.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_PATH));
        Parent root = loader.load();

        primaryStage.setTitle("Memory-Game");
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();




        root.setOnMousePressed(mouseEvent -> {
            xOffset = mouseEvent.getSceneX();
            yOffset = mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            primaryStage.setX(mouseEvent.getScreenX() - xOffset);
            primaryStage.setY(mouseEvent.getScreenY() - yOffset);
        });
    }


}
