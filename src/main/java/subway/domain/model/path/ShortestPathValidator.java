package subway.domain.model.path;

import subway.domain.model.Station;

public class ShortestPathValidator {

    private static final String ERROR_INVALID_START_END_STATIONS = "[ERROR] 출발역과 도착역이 같을 수 없습니다.";

    public static void validateIsEqualStations(Station start, Station end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException(ERROR_INVALID_START_END_STATIONS);
        }
    }
}
