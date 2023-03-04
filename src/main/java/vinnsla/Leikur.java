package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Leikur {
    private IntegerProperty stig = new SimpleIntegerProperty(0);

    public IntegerProperty stiginProperty() {
        return stig;
    }

    public void haekkaStigin() {
        stig.set(stig.get() + 1);
    }

}
