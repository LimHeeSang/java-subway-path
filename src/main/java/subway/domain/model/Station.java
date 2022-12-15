package subway.domain.model;

public class Station {

    private String name;

    public Station(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
