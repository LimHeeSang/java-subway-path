package subway.domain.model;

import org.junit.jupiter.api.Test;
import subway.domain.model.path.PathResult;
import subway.domain.model.path.ShortestDistancePath;
import subway.domain.repository.SectionRepository;
import subway.domain.repository.StationRepository;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestDistancePathTest {

    @Test
    void 최단거리_계산용_그래프_테스트() {
        ShortestDistancePath path = new ShortestDistancePath(StationRepository.stations(), SectionRepository.sections());
        PathResult pathResult = path.calculatePath(new Station("교대역"), new Station("양재역"));
        assertThat(pathResult.getWeight()).isEqualTo(4);
        assertThat(pathResult.getStations()).containsExactly(new Station("교대역"), new Station("강남역"), new Station("양재역"));
    }
}