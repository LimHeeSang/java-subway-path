package subway.view;

import subway.domain.service.PathStandard;

public class OutputView {

    private static final String MAIN_FEATURE_MESSAGE = "## 메인 화면";
    private static final String PATH_STANDARD_MESSAGE = "## 경로 기준";

    private OutputView() {
    }

    public static void printMainFeature() {
        System.out.println(MAIN_FEATURE_MESSAGE);
        for (MainFeature mainFeature : MainFeature.values()) {
            System.out.println(mainFeature.toDto());
        }
    }

    public static void printPathStandard() {
        System.out.println(PATH_STANDARD_MESSAGE);
        for (PathStandard pathStandard : PathStandard.values()) {
            System.out.println(pathStandard.toDto());
        }
    }
}
