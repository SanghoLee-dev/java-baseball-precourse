package baseball.computer;

import static baseball.computer.HintTestUtils.ball2Strike1Hints;
import static baseball.computer.HintTestUtils.notThingHints;
import static baseball.computer.HintTestUtils.strike3Hints;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerTest {


    @ParameterizedTest
    @MethodSource("checkArguments")
    void 컴퓨터_검사_테스트(Game3Numbers game3Numbers, Game3Numbers player3Numbers, ResultHints expected) {
        Computer computer = new Computer(game3Numbers);

        final ResultHints resultHints = computer.check(player3Numbers);

        assertThat(resultHints).isEqualTo(expected);
    }

    static Stream<Arguments> checkArguments() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(Game3Numbers.parsingGame3Numbers("123"), Game3Numbers.parsingGame3Numbers("456"),
                        ResultHints.of(notThingHints())))
                .add(Arguments.of(Game3Numbers.parsingGame3Numbers("123"), Game3Numbers.parsingGame3Numbers("321"),
                        ResultHints.of(ball2Strike1Hints())))
                .add(Arguments.of(Game3Numbers.parsingGame3Numbers("123"), Game3Numbers.parsingGame3Numbers("123"),
                        ResultHints.of(strike3Hints())))
                .build();
    }
}