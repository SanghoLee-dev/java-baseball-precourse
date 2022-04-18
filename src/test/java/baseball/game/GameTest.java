package baseball.game;

import static baseball.computer.HintTestUtils.ball2Strike1Hints;
import static baseball.computer.HintTestUtils.notThingHints;
import static baseball.computer.HintTestUtils.strike3Hints;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import baseball.computer.Computer;
import baseball.computer.ComputerTestUtils;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameTest {

    @ParameterizedTest
    @MethodSource("playArguments")
    void 한게임_진행테스트(String mockComputerNumbers, String playerNumbers, String text) {
        Game game = new Game(ComputerTestUtils.mockComputer(mockComputerNumbers));
        game.play(playerNumbers);

        assertThat(game.getResultHints().text()).isEqualTo(text);
    }

    static Stream<Arguments> playArguments() {
        return Stream.<Arguments>builder()
                .add(Arguments.of("123", "123", "3스트라이크"))
                .add(Arguments.of("123", "321", "2볼 1스트라이크"))
                .add(Arguments.of("123", "456", "낫싱"))
                .build();
    }
}