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
    public static final String EITURSNAKUR_DRAP = "Eitursnákur drap þig";

    public Leikbord() {
        bolti = new Bolti(this);
        getChildren().add(bolti);

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

    /**
     * Setur eitursnák á borðið ef það er tímabært
     */
    public void nyrPallur(int fjoldi) {
        for (int i = 0; i < fjoldi; i++) {
            Pallur e = new Pallur();
            e.setjaABord(this);
            pallar.add(e);
        }
    }

    public void afram() {
        bolti.afram();
    }

    public void nyrLeikur(int fjoldi) {
        nyrPallur(fjoldi);
    }

    public void aframPallur() {
        for (Pallur d : pallar) {
            d.afram();
            if (bolti.erArekstur(d)) { // Lagfæring
                sc.leikLokid(EITURSNAKUR_DRAP);
                return;
            }
        }
    }


}


