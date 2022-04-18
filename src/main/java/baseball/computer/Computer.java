package baseball.computer;

import static baseball.computer.GameNumberIndex.FIRST;
import static baseball.computer.GameNumberIndex.SECOND;
import static baseball.computer.GameNumberIndex.THIRD;
import static baseball.computer.Hint.BALL;
import static baseball.computer.Hint.NOTHING;
import static baseball.computer.Hint.STRIKE;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final Game3Numbers game3Numbers;

    private Computer() {
        this.game3Numbers = Game3Numbers.generate3Numbers();
    }

    protected Computer(Game3Numbers game3Numbers) {
        this.game3Numbers = game3Numbers;
    }

    public static Computer init() {
        return new Computer();
    }

    public ResultHints check(final Game3Numbers player3Numbers) {
        List<Hint> hints = new ArrayList<>();

        hints.add(checkHint(player3Numbers.getFirstNumber(), FIRST));
        hints.add(checkHint(player3Numbers.getSecondNumber(), SECOND));
        hints.add(checkHint(player3Numbers.getThirdNumber(), THIRD));

        return ResultHints.of(hints);
    }

    private Hint checkHint(final GameNumber playerNumber, final GameNumberIndex gameNumberIndex) {
        if (isStrike(playerNumber, gameNumberIndex.findStrikeGameNumber(this.game3Numbers))) {
            return STRIKE;
        }

        if (isBall(playerNumber, gameNumberIndex.findBallGameNumbers(this.game3Numbers))) {
            return BALL;
        }

        return NOTHING;
    }

    private boolean isStrike(final GameNumber playerNumber, final GameNumber computerNumber) {
        return playerNumber.equals(computerNumber);
    }

    private boolean isBall(final GameNumber playerNumber, List<GameNumber> ballGameNumbers) {
        boolean checkBool = false;
        for (GameNumber ballGameNumber : ballGameNumbers) {
            checkBool = checkBool || playerNumber.equals(ballGameNumber);
        }

        return checkBool;
    }

}