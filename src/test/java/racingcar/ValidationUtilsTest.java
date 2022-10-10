package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

    @Test
    @DisplayName("레이싱카 이름이 5자리 이하일 때 확인")
    public void 레이싱카_이름_길이_확인() {
        assertThat(ValidationUtils.validCarName("주호세")).isTrue();
    }

    @Test
    @DisplayName("레이싱카 이름이 5자리 넘어갔을 때 확인")
    public void 레이싱카_이름_길이_5자리_넘어감_확인() {
        assertThatThrownBy(() -> ValidationUtils.validCarName("틀린케이스만들기"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름 입력값이 잘못되었습니다.");
    }

    @Test
    @DisplayName("레이싱카 이름이 0자리일 때 에러 확인")
    public void 레이싱카_이름_길이_0자리_에러_확인() {
        assertThatThrownBy(() -> ValidationUtils.validCarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름 입력값이 잘못되었습니다.");
    }

    @Test
    @DisplayName("사용자의 자동차 이름 입력값 , 나누기 확인")
    public void inputSplit() {
        List<String> result = ValidationUtils.inputSplit("test1,test2,test3");
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자의 자동차 이름 입력값이 타당한지 확인")
    public void inputError() {
        List<String> testInput = new ArrayList<>();
        testInput.add("");
        boolean result = ValidationUtils.validCarNames(testInput);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("사용자의 자동차 이름 입력값이 타당한지 확인")
    public void inputSuccess() {
        List<String> testInput = new ArrayList<>();
        testInput.add("호세");
        testInput.add("영미");
        boolean result = ValidationUtils.validCarNames(testInput);
        assertThat(result).isTrue();
    }
}
