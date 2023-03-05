package vidmot.bouncedowngame;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class Bolti extends Circle {
    // fastar
    private static final String BOLTI_VIEW_FXML = "bolti-view.fxml";

    private static final double SKREF_STAERD = 1.0; //skref
    private double stefnaG = 0.0; // stefna í gráðum

    //Ebba er með þetta í Faeda snakur
    public Bolti(Leikbord b) {
        lesa();
    }

    public void lesa() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bolti-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    //ai
    public void afram() {
        double angle = getRotate();
        double x = getLayoutX();
        double y = getLayoutY();

        // calculate the new position based on the current heading angle
        double dx = Math.cos(Math.toRadians(angle));
        double dy = Math.sin(Math.toRadians(angle));

        // move left or right based on the current heading angle
        if (dx == 0) {
            // moving straight up or down, no left/right movement
        } else if (dx > 0) {
            // moving to the right
            x += SKREF_STAERD;
        } else {
            // moving to the left
            x -= SKREF_STAERD;
        }

        // move up or down based on the current heading angle
        y += dy * SKREF_STAERD;

        setLayoutX(x);
        setLayoutY(y);
    }
    

    // set stefna
    public void setStefna(double stefnagradur) {
        this.stefnaG = stefnagradur;
        setRotate(stefnagradur);
    }
}

