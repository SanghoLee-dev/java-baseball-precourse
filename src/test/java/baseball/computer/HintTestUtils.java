package baseball.computer;

import static baseball.computer.Hint.BALL;
import static baseball.computer.Hint.NOTHING;
import static baseball.computer.Hint.STRIKE;

import java.util.ArrayList;
import java.util.List;

public class HintTestUtils {
    public static List<Hint> notThingHints() {
        List<Hint> hints = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            hints.add(NOTHING);
        }
        return hints;
    }

    public static List<Hint> ball2Strike1Hints() {
        List<Hint> hints = new ArrayList<>();
        hints.add(BALL);
        hints.add(BALL);
        hints.add(STRIKE);
        return hints;
    }

    public static List<Hint> strike3Hints() {
        List<Hint> hints = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            hints.add(STRIKE);
        }
        return hints;
    }
}
