package subway.domain.dto;

import subway.domain.service.PathStandard;

public class PathRequestDto {

    private final PathStandard pathStandard;
    private final String startStation;
    private final String endStation;

    public PathRequestDto(PathStandard pathStandard, String startStation, String endStation) {
        this.pathStandard = pathStandard;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public PathStandard getPathStandard() {
        return pathStandard;
    }

    public String getStartStation() {
        return startStation;
    }

    public String getEndStation() {
        return endStation;
    }
}
