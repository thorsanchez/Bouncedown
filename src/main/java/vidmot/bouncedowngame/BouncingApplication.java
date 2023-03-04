package vidmot.bouncedowngame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BouncingApplication extends Application {
    public static final String BOUNCE = "BOUNCE"; // Nafn á leiknum

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BouncingApplication.class.getResource("bouncing-view.fxml"));


        Parent root = fxmlLoader.load();
        BouncingController sc = fxmlLoader.getController();

        Scene scene = new Scene(root, 600, 600);

        sc.orvatakkar();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

}
