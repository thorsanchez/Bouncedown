package vidmot.bouncedowngame;

public enum Stefna {
    LEFT(180),

    RIGHT(0),

    DOWN(270);

    private int gradur;

    Stefna(int gradur) {
        this.gradur = gradur;
    }

    public int getGradur() {
        return gradur;
    }
    

}
