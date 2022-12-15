package subway;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();

        GraphPath<String, DefaultWeightedEdge> path = dijkstraShortestPath.getPath("v3", "v1");


        assertThat(shortestPath.size()).isEqualTo(3);
    }

    @Test
    void 거리로_테스트() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        graph.addVertex("교대역");
        graph.addVertex("강남역");
        graph.addVertex("역삼역");
        graph.addVertex("남부터미널역");
        graph.addVertex("양재역");
        graph.addVertex("매봉역");
        graph.addVertex("양재시민의숲역");
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 2);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 2);
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 6);
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 2);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 6);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 10);


        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        GraphPath<String, DefaultWeightedEdge> path = dijkstraShortestPath.getPath("교대역", "양재역");

        /*System.out.println(path.getWeight());
        System.out.println(path.getVertexList());
        System.out.println(path.getEdgeList());*/
        List<DefaultWeightedEdge> edgeList = path.getEdgeList();
        DefaultWeightedEdge edge = edgeList.get(0);
        String result = edge.toString();
        String substring = result.substring(1, result.length() - 1);
        String[] split = substring.split(" : ");
        System.out.println(List.of(split[0], split[1]));
    }
}
