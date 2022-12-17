package subway.domain.repository;

import subway.domain.model.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final String ERROR_INVALID_STATION_NAME = "[ERROR] 해당 이름의 역은 없습니다.";

    static {
        List<Station> sampleStations = List.of(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("매봉역"),
                new Station("양재시민의숲역")
        );
        stations.addAll(sampleStations);
    }

    private StationRepository() {
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static Station findByName(String stationName) {
        return stations.stream()
                .filter(station -> station.isEqualName(stationName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_STATION_NAME));
    }
}
