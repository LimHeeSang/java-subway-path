package subway.domain.service;

public enum PathStandard {

    SHORTEST_DISTANCE("최단거리"),
    SHORTEST_TIME("최소시간");

    private final String name;

    PathStandard(String name) {
        this.name = name;
    }

    public boolean isDistance() {
        return this == SHORTEST_DISTANCE;
    }

    public boolean isTime() {
        return this == SHORTEST_TIME;
    }
}
