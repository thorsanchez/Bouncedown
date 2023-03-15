package vidmot.bouncedowngame;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class Bolti extends Circle {
    // fastar
    private static final String BOLTI_VIEW_FXML = "bolti-view.fxml";

    private static final double SKREF_STAERD = 10; //skref
    private double stefnaG = 0.0; // stefna í gráðum

    private double velx;
    private double vely;

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

    public void afram(Stefna stefna) {
        double angle = getRotate();
        double x = getLayoutX();
        double y = getLayoutY();

        // calculate the new position based on the current heading angle
        if (stefna.getGradur() == 180) {
            x -= SKREF_STAERD;
        } else if (stefna.getGradur() == 0) {
            x += SKREF_STAERD;
        }

        // move up or down based on the current heading angle
        if (y + SKREF_STAERD < getParent().getBoundsInLocal().getHeight()) {
            // the ball is not at the bottom of the screen
            y += SKREF_STAERD;
            setLayoutX(x);
            setLayoutY(y);
        } else {
            // the ball is at the bottom of the screen
            y = getParent().getBoundsInLocal().getHeight() - getHeight();
            setLayoutX(x);
            setLayoutY(y);
        }
    }


    // set stefna
    public void setStefna(double stefnagradur) {
        this.stefnaG = stefnagradur;
        setRotate(stefnagradur);
    }

    /**
     * Athugar hvort snákur rekst á eitursnák
     *
     * @param d eitursnákur
     * @return satt ef árekstur annars false
     */
    /*
    public boolean erArekstur(Pallur d) {
        return getBoundsInParent().intersects(d.getBoundsInParent());
    }
     */
    //ai
    //public boolean erArekstur(Pallur d) {
    //   return getBoundsInParent().intersects(d.getBoundsInParent());
    //}
    public boolean erArekstur(Pallur d) {
        if (getBoundsInParent().intersects(d.getBoundsInParent())) {
            // Set the y value of the ball to the y value of the snake
            setLayoutY(d.getLayoutY() - getHeight());
            return true;
        }
        return false;
    }


           /*
            setLayoutX(d.getLayoutX() + d.getWidth());
            setLayoutY(palletTopY - getHeight());
            return true;
        }
        return false;
    }
    */


    public double getHeight() {
        return 2 * getRadius();
    }

    public void setVely(double vely) {
        this.vely = vely;
    }


}
