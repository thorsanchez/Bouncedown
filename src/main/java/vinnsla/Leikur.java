package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Leikur {
    private int stigin = 0;
    private final ObservableList<Integer> stigatafla = FXCollections.observableArrayList(); // stigatafla


    /**
     * Hækkar stigin um einn
     */
    public void vinningur() {
        stigin++;
    }

    /**
     * Leik er lokið og stigum bætt við stigatölu
     */
    public void leikLokid() {
        stigatafla.add(stigin);
        stigin = 0;
    }

    /**
     * Skilar stigatöflunni
     *
     * @return stigataflan
     */
    public ObservableList<Integer> getStigin() {
        return stigatafla;
    }
}
