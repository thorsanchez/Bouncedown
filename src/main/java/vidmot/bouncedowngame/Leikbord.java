package vidmot.bouncedowngame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class Leikbord extends Pane {

    // fastar
    private static final String FXML_SKRA = "leikbord-view.fxml";

    @FXML
    private Bolti bolti;

    //tilviksbreytur
    private final ObservableList<Bolti> boltinn = FXCollections.observableArrayList();    // boltinn
    private BouncingController bc; // tenging í controllerinn til að geta sett í bið, áfram, uppfæra stig og ljúka leik
    private Bolti ball;    // boltinn

    public Leikbord() {
        bolti = new Bolti(this);
        getChildren().add(bolti);
    }

    public Bolti getBolti() {
        return bolti;
    }

    /**
     * Setur controller fyrir viðmótshlutinn
     *
     * @param bc controllerinn
     */
    public void setController(BouncingController bc) {
        this.bc = bc;
    }


    /**
     * Býr til nýjan snák. Ef snákur er á borðinu þá er hann fjarlægður
     *
     * @return skilar nýjum snák
     */
    public Bolti nyrBolti() {
        if (ball != null)
            getChildren().remove(ball);
        ball = new Bolti(this);// til að sé hægt að setja í bið
        getChildren().add(ball);
        return ball;
    }

    public void setBolti(Bolti bolti) {
        this.bolti = bolti;
    }

    public double getHaed() {
        return getHeight();
    }

    public double getBreidd() {
        return getWidth();
    }

    public double getHorn() {
        return getLayoutX();
    }
}
