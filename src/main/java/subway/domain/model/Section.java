package subway.domain.model;

import java.util.List;

public class Section {

    private static final int LEFT_STATION_NAME_INDEX = 0;
    private static final int RIGHT_STATION_NAME_INDEX = 1;

    private final Station left;
    private final Station right;

    private final int distance;
    private final int time;

    public Section(Station left, Station right, int distance, int time) {
        this.left = left;
        this.right = right;
        this.distance = distance;
        this.time = time;
    }

    public boolean hasStations(List<String> stationsName) {
        return (this.left.isEqualName(stationsName.get(LEFT_STATION_NAME_INDEX)))
                && (this.right.isEqualName(stationsName.get(RIGHT_STATION_NAME_INDEX)));
    }

    @Override
    public String toString() {
        return "Section{" +
                "left=" + left +
                ", right=" + right +
                ", distance=" + distance +
                ", time=" + time +
                '}';
    }

    public Station getLeft() {
        return left;
    }

    public Station getRight() {
        return right;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
