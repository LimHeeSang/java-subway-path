package subway.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.dto.PathRequestDto;
import subway.domain.dto.PathResponseDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SubwayPathServiceTest {

    private SubwayPathService subwayPathService;

    @BeforeEach
    void setUp() {
        subwayPathService = new SubwayPathService();
    }

    @Test
    void 최단거리로_경로조회() {
        PathRequestDto requestDto = new PathRequestDto(PathStandard.SHORTEST_DISTANCE,
                "교대역", "양재역");
        PathResponseDto responseDto = subwayPathService.getShortestPath(requestDto);
        assertThat(responseDto.getDistance()).isEqualTo(4);
        assertThat(responseDto.getTime()).isEqualTo(11);
        assertThat(responseDto.getRoute()).containsExactly("교대역", "강남역", "양재역");
    }

    @Test
    void 최소시간으로_경로조회() {
        PathRequestDto requestDto = new PathRequestDto(PathStandard.SHORTEST_TIME,
                "교대역", "양재역");
        PathResponseDto responseDto = subwayPathService.getShortestPath(requestDto);
        assertThat(responseDto.getDistance()).isEqualTo(12);
        assertThat(responseDto.getTime()).isEqualTo(10);
        assertThat(responseDto.getRoute()).containsExactly("교대역", "남부터미널역", "양재역");
    }

    @Test
    void 최소거리일때_출발역과_도착역이_같으면_예외발생() {
        PathRequestDto requestDto = new PathRequestDto(PathStandard.SHORTEST_TIME,
                "교대역", "교대역");
        assertThatThrownBy(() -> subwayPathService.getShortestPath(requestDto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 출발역과 도착역이 같을 수 없습니다.");
    }

    @Test
    void 최단거리일때_출발역과_도착역이_같으면_예외발생() {
        PathRequestDto requestDto = new PathRequestDto(PathStandard.SHORTEST_DISTANCE,
                "교대역", "교대역");
        assertThatThrownBy(() -> subwayPathService.getShortestPath(requestDto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 출발역과 도착역이 같을 수 없습니다.");
    }
}