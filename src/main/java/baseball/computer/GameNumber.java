package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class GameNumber {
    private final int number;

    private static final int MIN = 1;
    private static final int MAX = 9;

    private GameNumber() {
        this.number = Randoms.pickNumberInRange(MIN, MAX);
    }
    private GameNumber(int number) {
        this.number = number;
    }

    public static GameNumber generate() {
        return new GameNumber();
    }

    public static GameNumber of(final int number) {
        return new GameNumber(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameNumber that = (GameNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
