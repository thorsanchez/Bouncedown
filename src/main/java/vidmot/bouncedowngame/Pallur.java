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
        lesa(FXML_SKRA);
    }

    /**
     * Setja pall á borð b á random stað(hægri eða v)
     *
     * @param b leikjaborð
     */
    public void setjaABord(Leikbord b) {
        double leftOrRight = random.nextDouble();
        if (leftOrRight < 0.5) {
            setX(0);
        } else {
            setX(b.getWidth() - getWidth());
        }
        setY(random.nextInt((int) (b.getHeight() - getHeight())));
        b.getChildren().add(this);
    }

    /**
     * Lesa inn útlit úr fxml skrá
     *
     * @param fxmlSkra nafn á fxml skrá
     */
    protected void lesa(String fxmlSkra) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlSkra));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
