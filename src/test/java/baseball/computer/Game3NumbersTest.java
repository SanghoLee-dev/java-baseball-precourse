package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Game3NumbersTest {

    @Test
    void 세가지_다른_숫자_생성확인_테스트() {
        Game3Numbers game3Numbers = Game3Numbers.generate3Numbers();

        assertThat(game3Numbers.isDiff()).isTrue();
    }

    @ParameterizedTest
    @MethodSource("parsingNumbers")
    void 텍스트_파싱_테스트(String inputText, Game3Numbers expected) {
        assertThat(Game3Numbers.parsingGame3Numbers(inputText)).isEqualTo(expected);
    }

    static Stream<Arguments> parsingNumbers() {
        return Stream.<Arguments>builder()
                .add(Arguments.of("234", new Game3Numbers(GameNumber.of(2), GameNumber.of(3), GameNumber.of(4))))
                .add(Arguments.of("741", new Game3Numbers(GameNumber.of(7), GameNumber.of(4), GameNumber.of(1))))
                .build();
    }

    @ParameterizedTest
    @MethodSource("parsingExceptionNumbers")
    void 텍스트_파싱_예외_테스트(String inputText, String exceptionMessage) {
        assertThatThrownBy(() -> Game3Numbers.parsingGame3Numbers(inputText))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

    static Stream<Arguments> parsingExceptionNumbers() {
        return Stream.<Arguments>builder()
                .add(Arguments.of("234as", "숫자가 아닙니다."))
                .add(Arguments.of("23456", "3 자리 숫자가 아닙니다."))
                .build();
    }
}