package baseball.computer;

import java.util.ArrayList;
import java.util.List;

public enum GameNumberIndex {
    FIRST, SECOND, THIRD;

    public GameNumber findStrikeGameNumber(final Game3Numbers game3Numbers) {
        if (this == FIRST) {
            return game3Numbers.getFirstNumber();
        }

        if (this == SECOND) {
            return game3Numbers.getSecondNumber();
        }

        if (this == THIRD) {
            return game3Numbers.getThirdNumber();
        }

        throw new IllegalArgumentException("잘못된 매개변수 입니다.");
    }

    public List<GameNumber> findBallGameNumbers(final Game3Numbers game3Numbers) {
        List<GameNumber> findBallList = new ArrayList<>();
        findFirstBall(game3Numbers, findBallList);
        findSecondBall(game3Numbers, findBallList);
        findThirdBall(game3Numbers, findBallList);

        return findBallList;
    }

    private void findThirdBall(Game3Numbers game3Numbers, List<GameNumber> findBallList) {
        if (this == THIRD) {
            findBallList.add(game3Numbers.getFirstNumber());
            findBallList.add(game3Numbers.getSecondNumber());
        }
    }

    private void findSecondBall(Game3Numbers game3Numbers, List<GameNumber> findBallList) {
        if (this == SECOND) {
            findBallList.add(game3Numbers.getFirstNumber());
            findBallList.add(game3Numbers.getThirdNumber());
        }
    }

    private void findFirstBall(Game3Numbers game3Numbers, List<GameNumber> findBallList) {
        if (this == FIRST) {
            findBallList.add(game3Numbers.getSecondNumber());
            findBallList.add(game3Numbers.getThirdNumber());
        }
    }
}
