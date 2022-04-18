package baseball;

import baseball.game.GameMachine;

public class Application {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine();
        gameMachine.start();
    }
}
