package subway.view;

import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {

    private static final String INPUT_MAIN_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainFeature inputMainFeature() {
        System.out.println(INPUT_MAIN_FEATURE_MESSAGE);
        return MainFeature.from(scanner.nextLine());
    }

    public <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return input(supplier);
        }
    }
}
