package baseball.computer;

import java.util.Objects;

public class Game3Numbers {
    private final GameNumber firstNumber;
    private final GameNumber secondNumber;
    private final GameNumber thirdNumber;

    private static final String NUMERIC = "\\d*";
    public static final String EMPTY_REGEX = "";
    private static final int SIZE = 3;

    private Game3Numbers() {
        this.firstNumber = GameNumber.generate();
        this.secondNumber = generateNumberWithExclusive(this.firstNumber);
        this.thirdNumber = generateNumberWithExclusive(this.firstNumber, this.secondNumber);
    }

    protected Game3Numbers(final GameNumber firstNumber, final GameNumber secondNumber, final GameNumber thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    public static Game3Numbers generate3Numbers() {
        return new Game3Numbers();
    }

    public static Game3Numbers parsingGame3Numbers(final String playerInput) {
        validatePlayerInput(playerInput);
        final int[] inputNumbers = parseIntArray(playerInput);

        return new Game3Numbers(GameNumber.of(inputNumbers[0]), GameNumber.of(inputNumbers[1]),
                GameNumber.of(inputNumbers[2]));
    }

    private GameNumber generateNumberWithExclusive(final GameNumber... gameNumbers) {
        GameNumber gameNumber = GameNumber.generate();

        while (hasExclusive(gameNumber, gameNumbers)) {
            gameNumber = GameNumber.generate();
        }

        return gameNumber;
    }

    private static void validatePlayerInput(final String playerInput) {
        if (!playerInput.matches(NUMERIC)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }

        if (playerInput.length() != SIZE) {
            throw new IllegalArgumentException("3 자리 숫자가 아닙니다.");
        }
    }

    private static int[] parseIntArray(final String playerInput) {
        final String[] inputNumberStrings = playerInput.split(EMPTY_REGEX);
        int[] returnArray = new int[inputNumberStrings.length];

        for (int i = 0; i < inputNumberStrings.length; i++) {
            returnArray[i] = Integer.parseInt(inputNumberStrings[i]);
        }

        return returnArray;
    }

    private boolean hasExclusive(final GameNumber gameNumber, final GameNumber... exclusiveGameNumbers) {
        boolean checkBool = false;
        for (GameNumber exclusiveGameNumber : exclusiveGameNumbers) {
            checkBool = checkBool || gameNumber.equals(exclusiveGameNumber);
        }

        return false;
    }

    public boolean isDiff() {
        return !(this.firstNumber.equals(this.secondNumber) || this.secondNumber.equals(this.thirdNumber));
    }

    public GameNumber getFirstNumber() {
        return firstNumber;
    }

    public GameNumber getSecondNumber() {
        return secondNumber;
    }

    public GameNumber getThirdNumber() {
        return thirdNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Game3Numbers)) {
            return false;
        }
        Game3Numbers that = (Game3Numbers) o;
        return Objects.equals(firstNumber, that.firstNumber) && Objects.equals(secondNumber,
                that.secondNumber) && Objects.equals(thirdNumber, that.thirdNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNumber, secondNumber, thirdNumber);
    }
}
