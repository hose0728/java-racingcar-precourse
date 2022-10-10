package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String carName;
    private int forward;

    public RacingCar(String carName) {
        this.carName = carName;
        this.forward = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getForward() {
        return forward;
    }

    public void playGame() {
        int randNum = Randoms.pickNumberInRange(1, 10) - 1;
        if (randNum >= 4) {
            this.forward += 1;
        }
    }
}
