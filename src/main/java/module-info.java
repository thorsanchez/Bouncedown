module vidmot.bouncedowngame {
    requires javafx.controls;
    requires javafx.fxml;


    opens vidmot.bouncedowngame to javafx.fxml;
    exports vidmot.bouncedowngame;
}
