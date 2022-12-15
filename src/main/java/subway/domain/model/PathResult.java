package subway.domain.model;

import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;
import java.util.List;

public class PathResult {

    private final int weight;
    private final List<Station> stations;
    private final List<List<String>> edgeStationNames;

    public PathResult(int weight, List<Station> stations, List<DefaultWeightedEdge> sections) {
        this.weight = weight;
        this.stations = stations;
        this.edgeStationNames = new ArrayList<>();
        parsingEdgeStationsName(sections);
    }

    private void parsingEdgeStationsName(List<DefaultWeightedEdge> sections) {
        for (DefaultWeightedEdge edge : sections) {
            String edgeName = edge.toString();
            String removeMark = edgeName.substring(1, edgeName.length() - 1);
            String[] result = removeMark.split(" : ");
            edgeStationNames.add(List.of(result[0], result[1]));
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
