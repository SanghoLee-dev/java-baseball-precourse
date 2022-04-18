package baseball.computer;

public enum Hint {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱")
    ;

    Hint(String text) {
        this.text = text;
    }

    private final String text;

    public String getText() {
        return text;
    }
}
