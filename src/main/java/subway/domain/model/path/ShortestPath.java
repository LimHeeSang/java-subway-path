package subway.domain.model.path;

import subway.domain.model.Station;

public interface ShortestPath {
    PathResult calculatePath(Station start, Station end);
}
