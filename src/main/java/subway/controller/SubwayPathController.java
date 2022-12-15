package subway.controller;

import subway.domain.dto.PathRequestDto;
import subway.domain.dto.PathResponseDto;
import subway.domain.service.PathStandard;
import subway.domain.service.SubwayPathService;
import subway.view.InputView;
import subway.view.MainFeature;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayPathController {

    private final SubwayPathService subwayPathService;
    private final InputView inputView;

    public SubwayPathController(SubwayPathService subwayPathService, Scanner scanner) {
        this.subwayPathService = subwayPathService;
        this.inputView = new InputView(scanner);
    }

    public void run() {
        MainFeature mainFeature;
        do {
            OutputView.printMainFeature();
            mainFeature = ExceptionHandler.input(inputView::inputMainFeature);

            if (mainFeature.isPathGet()) {
                pathGet();
            }
        } while (!mainFeature.isQuit());
    }

    private void pathGet() {
        OutputView.printPathStandard();
        PathResponseDto pathResponseDto = subwayPathService.getShortestPath(createRequestDto());
        OutputView.printPathResult(pathResponseDto);
    }

    private PathRequestDto createRequestDto() {
        PathStandard pathStandard = ExceptionHandler.input(inputView::inputPathStandard);
        String startStation = ExceptionHandler.input(inputView::inputStartStation);
        String endStation = ExceptionHandler.input(inputView::inputEndStation);
        return new PathRequestDto(pathStandard, startStation, endStation);
    }
}
