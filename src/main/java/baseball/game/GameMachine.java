package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class GameMachine {
    private Game game;

    private static final String QUESTION = "숫자를 입력해 주세요: ";
    private static final String CONGRATULATION = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    public static final String CHOICE = "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.";
    public static final String GAME_END = "게임 종료";
    public static final String RESTART = "1";
    public static final String END = "2";


    public void start() {
        this.game = new Game();

        while (game.isPlaying()) {
            printQuestion();
            game.play(Console.readLine().trim());
            printResult();
        }
        printCongratulation();
        choiceRestart();
    }

    private void choiceRestart() {
        printRestartChoice();
        final String playerInput = Console.readLine().trim();

        if (isReStart(playerInput)) {
            start();
            return;
        }

        if (isEnd(playerInput)) {
            printEnd();
            return;
        }

        throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

    private boolean isReStart(final String playerInput) {
        return playerInput.equals(RESTART);
    }

    private boolean isEnd(final String playerInput) {
        return playerInput.equals(END);
    }

    private void printEnd() {
        System.out.println(GAME_END);
    }

    private void printQuestion() {
        System.out.print(QUESTION);
    }

    private void printCongratulation() {
        System.out.println(CONGRATULATION);
    }

    private void printRestartChoice() {
        System.out.println(CHOICE);
    }

    private void printResult() {
        System.out.println(this.game.getResultHints().text());
    }
}
