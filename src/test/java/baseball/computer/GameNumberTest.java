package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameNumberTest {

    @Test
    void 범위_내의_임의의_숫자_생성_테스트() {
        final GameNumber gameNumber = GameNumber.generate();

        assertThat(gameNumber.getNumber()).isGreaterThan(0);
        assertThat(gameNumber.getNumber()).isLessThan(10);
    }
}