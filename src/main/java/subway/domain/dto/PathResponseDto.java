package subway.domain.dto;

import java.util.List;

public class PathResponseDto {

    private final int distance;
    private final int time;
    private final List<String> route;

    public PathResponseDto(int distance, int time, List<String> route) {
        this.distance = distance;
        this.time = time;
        this.route = route;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public List<String> getRoute() {
        return route;
    }
}
