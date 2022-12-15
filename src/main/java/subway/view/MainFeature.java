package subway.view;

import java.util.Arrays;

public enum MainFeature {

    PATH_GET("1", "경로조회"),
    QUIT("Q", "종료");

    private static final String ERROR_INVALID_FEATURE_MESSAGE = "[ERROR] 메인 기능은 1, Q 중에서 입력 가능합니다.";
    private final String number;
    private final String name;

    MainFeature(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public static MainFeature from(String number) {
        return Arrays.stream(MainFeature.values())
                .filter(mainFeature -> mainFeature.isEqualNumber(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_FEATURE_MESSAGE));
    }

    private boolean isEqualNumber(String number) {
        return this.number.equals(number);
    }

    public String toDto() {
        return String.format("%s. %s", number, name);
    }

    public boolean isPathGet() {
        return this == PATH_GET;
    }

    public boolean isQuit() {
        return this == QUIT;
    }
}
