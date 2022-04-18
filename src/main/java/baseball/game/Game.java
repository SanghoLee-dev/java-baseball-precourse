package baseball.game;

import baseball.computer.Computer;
import baseball.computer.Game3Numbers;
import baseball.computer.ResultHints;

public class Game {
    private final Computer computer;
    private Game3Numbers player3Numbers;
    private ResultHints resultHints;
    private boolean finish;

    public Game() {
        this.computer = Computer.init();
        this.finish = false;
    }

    protected Game(final Computer computer) {
        this.computer = computer;
        this.finish = false;
    }

    public void play(final String playerInput) {
        this.player3Numbers = Game3Numbers.parsingGame3Numbers(playerInput);
        this.resultHints = computer.check(this.player3Numbers);
        if (resultHints.is3Strike()) {
            end();
        }
    }

    private void end() {
        this.finish = true;
    }

    public boolean isPlaying() {
        return !this.finish;
    }

    public ResultHints getResultHints() {
        return resultHints;
    }
}
