package vidmot.bouncedowngame;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Random;

public class Pallur extends Rectangle {
    // fastar
    private static final String FXML_SKRA = "pallur-view.fxml";
    private static final Random random = new Random();

    public Pallur() {
        lesa();
    }


    //Lesa inn útlit úr fxml skrá
    protected void lesa() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pallur-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


}
