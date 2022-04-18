package baseball.computer;

import static baseball.computer.Hint.BALL;
import static baseball.computer.Hint.NOTHING;
import static baseball.computer.Hint.STRIKE;

import java.util.List;
import java.util.Objects;

public class ResultHints {
    private int strikeCount = 0;
    private int ballCount = 0;
    private List<Hint> hints;
    public static final String EMPTY_TEXT = "";

    private ResultHints(List<Hint> hints) {
        this.hints = hints;
        countHint();
    }

    public static ResultHints of(final List<Hint> hints) {
        return new ResultHints(hints);
    }

    public String text() {
        if (isNotThing()) {
            return NOTHING.getText();
        }

        return makeResultText();
    }

    private String makeResultText() {
        String resultText = EMPTY_TEXT;
        resultText = resultText.concat(isNonNullString(ballText()));
        resultText = ballText() != null ? resultText.concat(" ") : resultText;
        resultText = resultText.concat(isNonNullString(strikeText()));
        return resultText;
    }

    private String isNonNullString(final String ballText) {
        return ballText == null ?  EMPTY_TEXT : ballText;
    }

    private String strikeText() {
        if (this.strikeCount == 0) {
            return null;
        }
        return this.strikeCount + STRIKE.getText();
    }

    private String ballText() {
        if (this.ballCount == 0) {
            return null;
        }

        return this.ballCount + BALL.getText();
    }

    private void countHint() {
        for (Hint hint : hints) {
            increaseCount(hint);
        }
    }

    private void increaseCount(Hint hint) {
        if (hint == STRIKE) {
            strikeCount++;
        }

        if (hint == BALL) {
            ballCount++;
        }
    }

    private boolean isNotThing() {
        return !hints.contains(STRIKE) && !hints.contains(BALL);
    }

    public boolean is3Strike() {
        return this.strikeCount == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResultHints)) {
            return false;
        }
        ResultHints that = (ResultHints) o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
