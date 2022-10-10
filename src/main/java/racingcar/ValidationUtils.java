package racingcar;

import java.util.Arrays;
import java.util.List;

public class ValidationUtils {

    public static final String RACING_CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름 입력값이 잘못되었습니다.";

    public static boolean validCarName(String input) {
        if (input.length() > 5 || input.length() == 0) {
            throw new IllegalArgumentException(RACING_CAR_NAME_ERROR_MESSAGE);
        }
        return true;
    }

    public static List<String> inputSplit(String carNameInput) {
        return Arrays.asList(carNameInput.split(","));
    }


    public static boolean validCarNames(List<String> carNames) {
        try {
            for (String carName : carNames) {
                validCarName(carName);
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
