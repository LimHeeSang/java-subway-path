package subway.domain.model.path;

import subway.domain.model.Station;

import java.util.ArrayList;
import java.util.List;

public class PathResult {

    private final int weight;
    private final List<Station> stations;
    private final List<List<String>> edgeStationNames;

    public PathResult(int weight, List<Station> stations, List<CustomWeightedEdge> sections) {
        this.weight = weight;
        this.stations = stations;
        this.edgeStationNames = new ArrayList<>();
        parsingEdgeStationsName(sections);
    }

    private void parsingEdgeStationsName(List<CustomWeightedEdge> sections) {
        for (CustomWeightedEdge edge : sections) {
            String stations = edge.toString();
            String[] split = stations.split(",");
            edgeStationNames.add(List.of(split[0], split[1]));
        }
    }

    public int getWeight() {
        return weight;
    }

    public List<Station> getStations() {
        return stations;
    }

    public List<List<String>> getEdgeStationNames() {
        return edgeStationNames;
    }
}
