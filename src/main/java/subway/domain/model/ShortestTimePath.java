package subway.domain.model;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class ShortestTimePath {

    private final DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraPath;

    public ShortestTimePath(List<Station> stations, List<Section> sections) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = createGraph(stations, sections);
        this.dijkstraPath = new DijkstraShortestPath<>(graph);
    }

    private WeightedMultigraph<Station, DefaultWeightedEdge> createGraph(List<Station> stations, List<Section> sections) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        for (Station station : stations) {
            graph.addVertex(station);
        }
        for (Section section : sections) {
            graph.setEdgeWeight(graph.addEdge(section.getLeft(), section.getRight()), section.getTime());
        }
        return graph;
    }

    public PathResult calculatePath(Station start, Station end) {
        GraphPath<Station, DefaultWeightedEdge> path = dijkstraPath.getPath(start, end);
        int weight = (int) path.getWeight();
        List<Station> verTexes = path.getVertexList();
        List<DefaultWeightedEdge> edges = path.getEdgeList();
        return new PathResult(weight, verTexes, edges);
    }
}
