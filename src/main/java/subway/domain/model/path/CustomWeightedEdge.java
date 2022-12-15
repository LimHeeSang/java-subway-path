package subway.domain.model.path;

import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.model.Station;

public class CustomWeightedEdge extends DefaultWeightedEdge {

    @Override
    public String toString() {
        Station source = (Station) getSource();
        Station target = (Station) getTarget();
        return source.getName() + "," + target.getName();
    }
}
