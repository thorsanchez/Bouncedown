package vidmot.bouncedowngame;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class BouncingController {

    //FASTAR
    //private static final int VINSTRI = 180;
    //private static final int HAEGRI = 360;

    //Búðu til hakkatöflu sem fer frá KeyCode yfir í Stefna
    private Map<KeyCode, Stefna> keyToStefna = new HashMap<>();

    private AnimationTimer animationTimer; //animation (þurfum að búa til animation loop)
    @FXML
    private Pane gamePane;

    // viðmótshlutir
    @FXML
    private Label fxStigin; //stigacounter
    @FXML
    private Leikbord leikbord;    // leiksvæðið

    public void orvatakkar() {
        keyToStefna.put(KeyCode.UP, null);   // not used in this case
        keyToStefna.put(KeyCode.DOWN, Stefna.DOWN); //notum Stefna enum hérna
        keyToStefna.put(KeyCode.RIGHT, Stefna.RIGHT);
        keyToStefna.put(KeyCode.LEFT, Stefna.LEFT);

        fxStigin.getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            Stefna stefna = keyToStefna.get(event.getCode());
            if (stefna != null) {
                int gradur = stefna.getGradur();
                System.out.println("Gráður: " + gradur);
                // set some instance variable in the UI with the degrees value
                leikbord.getBolti().setStefna(stefna.getGradur());

            }
            event.consume();
        });
    }


    public void testBolti() {
        leikbord.getBolti().setRotate(Stefna.RIGHT.getGradur());
        for (int i = 0; i < 50; i++) {
            leikbord.getBolti().afram();
        }
    }


    public void setLeikbord(Leikbord leikbord) {
        this.leikbord = leikbord;
    }

    public void initialize() {
        // other initialization code here
        leikbord.setController(this);
        leikbord.nyrBolti();
        //testBolti();
        //orvatakkars();

        leikbord.nyrPallur();

        //testBall();


    }
}
