package subway.domain.model;

import org.junit.jupiter.api.Test;
import subway.domain.model.path.PathResult;
import subway.domain.model.path.ShortestTimePath;
import subway.domain.repository.SectionRepository;
import subway.domain.repository.StationRepository;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestTimePathTest {

    @Test
    void 최단시간_계산용_그래프_테스트() {
        ShortestTimePath path = new ShortestTimePath(StationRepository.stations(), SectionRepository.sections());
        PathResult pathResult = path.calculatePath(new Station("교대역"), new Station("양재역"));
        assertThat(pathResult.getWeight()).isEqualTo(10);
        assertThat(pathResult.getStations()).containsExactly(new Station("교대역"), new Station("남부터미널역"), new Station("양재역"));
    }
}