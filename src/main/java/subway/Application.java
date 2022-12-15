package subway;

import subway.controller.SubwayPathController;
import subway.domain.service.SubwayPathService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayPathController subwayPathController = new SubwayPathController(subwayPathService(), scanner);
        subwayPathController.run();
    }

    private static SubwayPathService subwayPathService() {
        return new SubwayPathService();
    }
}
