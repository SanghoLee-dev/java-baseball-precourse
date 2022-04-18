package baseball.computer;

import static baseball.computer.HintTestUtils.ball2Strike1Hints;
import static baseball.computer.HintTestUtils.notThingHints;
import static baseball.computer.HintTestUtils.strike3Hints;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultHintsTest {

    @ParameterizedTest
    @MethodSource("printText")
    void 결과_테스트_확인(List<Hint> hints, String printText) {
        final ResultHints resultHints = ResultHints.of(hints);

        assertThat(resultHints.text()).isEqualTo(printText);
    }

    static Stream<Arguments> printText() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(strike3Hints(), "3스트라이크"))
                .add(Arguments.of(ball2Strike1Hints(), "2볼 1스트라이크"))
                .add(Arguments.of(notThingHints(), "낫싱"))
                .build();
    }

    @ParameterizedTest
    @MethodSource("strikes3")
    void 전부_스트라이크_확인(List<Hint> hints) {
        final ResultHints resultHints = ResultHints.of(hints);

        assertThat(resultHints.is3Strike()).isTrue();
    }

    static Stream<Arguments> strikes3() {
        return Stream.<Arguments>builder()
                .add(Arguments.of(strike3Hints()))
                .build();
    }
}