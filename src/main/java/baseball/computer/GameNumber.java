package baseball.computer;

import baseball.game.Game;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class GameNumber {
    private final int number;

    private static final int MIN = 1;
    private static final int MAX = 9;

    private GameNumber() {
        this.number = Randoms.pickNumberInRange(MIN, MAX);
    }

    public static GameNumber generate() {
        return new GameNumber();
    }

    public int getNumber() {
        return number;
    }
}
