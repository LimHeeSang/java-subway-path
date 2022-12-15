package subway.domain.repository;

import subway.domain.model.Section;
import subway.domain.model.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    static {
        List<Section> sampleSections = List.of(
                new Section(new Station("교대역"), new Station("강남역"), 2, 3),
                new Section(new Station("강남역"), new Station("역삼역"), 2, 3),
                new Section(new Station("교대역"), new Station("남부터미널역"), 6, 5),
                new Section(new Station("강남역"), new Station("양재역"), 2, 8),
                new Section(new Station("남부터미널역"), new Station("양재역"), 6, 5),
                new Section(new Station("양재역"), new Station("매봉역"), 1, 1),
                new Section(new Station("양재역"), new Station("양재시민의숲역"), 10, 3)
        );
        sections.addAll(sampleSections);
    }

    private SectionRepository() {
    }

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static List<Section> findByEdgeStationNames(List<List<String>> stationsNames) {
        List<Section> result = new ArrayList<>();
        for (List<String> stationsName : stationsNames) {
            hasStations(result, stationsName);
        }
        return result;
    }

    private static void hasStations(List<Section> result, List<String> stationsName) {
        for (Section section : sections) {
            if (section.hasStations(stationsName)) {
                result.add(section);
            }
        }
    }
}
