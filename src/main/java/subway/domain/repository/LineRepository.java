package subway.domain.repository;

import subway.domain.model.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    static {
        List<Line> sampleLines = List.of(
                new Line("2호선"),
                new Line("3호선"),
                new Line("신분당선")
        );
        lines.addAll(sampleLines);
    }

    private LineRepository() {
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
