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

    //Setja eitursnák á borð b á random stað
    public void setjaABord(Leikbord b) {
        setX(random.nextInt((int) (b.getWidth() - getWidth())));
        setY(random.nextInt((int) (b.getHeight() - getHeight())));
        b.getChildren().add(this);
    }

    public void afram() {
        Leikbord p = (Leikbord) this.getParent();
        setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians((getRotate()))) * 5) % (int) p.getWidth());
        setY((int) (getY() + p.getHeight() - (int) Math.sin(Math.toRadians(getRotate())) * 5) % (int) p.getHeight());
    }

}





