package subway.view;

import subway.domain.service.PathStandard;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String END_STATION_MESSAGE = "## 도착역을 입력하세요.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainFeature inputMainFeature() {
        System.out.println(INPUT_FEATURE_MESSAGE);
        return MainFeature.from(scanner.nextLine());
    }

    public PathStandard inputPathStandard() {
        System.out.println(INPUT_FEATURE_MESSAGE);
        return PathStandard.from(scanner.nextLine());
    }

    public String inputStartStation() {
        System.out.println(START_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public String inputEndStation() {
        System.out.println(END_STATION_MESSAGE);
        return scanner.nextLine();
    }
}
