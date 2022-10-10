package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest extends NsTest {

    private RacingCar testCar;

    @BeforeEach
    public void setUp() {
        testCar = new RacingCar("test");
    }

    @Test
    @DisplayName("레이싱카 생성 테스트")
    public void makeRacingCar() {

        String testName = "test";
        RacingCar racingCar = new RacingCar(testName);
        assertThat(racingCar.getCarName()).isEqualTo(testName);
        assertThat(racingCar.getForward()).isEqualTo(0);
    }

    @Test
    @DisplayName("한게임을 돌릴 시에 전진한다.")
    public void playGameTest() {
        assertRandomNumberInRangeTest(
                ()-> {testCar.playGame();
                    assertThat(testCar.getForward()).isEqualTo(1);
                },
                5,1
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
