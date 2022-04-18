package baseball.computer;

public class ComputerTestUtils {
    public static Computer mockComputer(String mockNumbers) {
        return new Computer(Game3Numbers.parsingGame3Numbers(mockNumbers));
    }
}
