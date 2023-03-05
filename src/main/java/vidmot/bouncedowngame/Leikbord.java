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
    @FXML
    private Pallur pallur;

    //tilviksbreytur
    private final ObservableList<Bolti> boltinn = FXCollections.observableArrayList();    // boltinn
    private BouncingController sc; // tenging í controllerinn til að geta sett í bið, áfram, uppfæra stig og ljúka leik
    private Bolti ball;    // boltinn
    private final ObservableList<Pallur> pallar = FXCollections.observableArrayList();//eitursnákar


    public Leikbord() {
        bolti = new Bolti(this);
        getChildren().add(bolti);
        pallur = new Pallur();
        getChildren().add(pallur);

    }

    public Bolti getBolti() {
        return bolti;
    }

    public Pallur getPallur() {
        return pallur;
    }

    /**
     * Setur controller fyrir viðmótshlutinn
     *
     * @param sc controllerinn
     */
    public void setController(BouncingController sc) {
        this.sc = sc;
    }

    /**
     * Nær í controllerinn
     *
     * @return controllerinn
     */
    public BouncingController getController() {
        return sc;
    }


    /**
     * Býr til nýjan bolta. Ef bolti er á borðinu þá er hann fjarlægður
     *
     * @return skilar nýjum bolta
     */
    public Bolti nyrBolti() {
        if (ball != null)
            getChildren().remove(ball);
        ball = new Bolti(this);// til að sé hægt að setja í bið
        getChildren().add(ball);
        return ball;
    }

    public Pallur nyrPallur(int fjoldi) {
        for (int i = 0; i < fjoldi; i++) {
            if (pallur != null)
                getChildren().remove(pallur);
            pallur = new Pallur();// til að sé hægt að setja í bið
            getChildren().add(pallur);
        }
        return pallur;
    }

    public void afram() {
        pallur.afram();
    }

    public void nyrLeikur(int fjoldi) {
        nyrPallur(fjoldi);
    }


}
