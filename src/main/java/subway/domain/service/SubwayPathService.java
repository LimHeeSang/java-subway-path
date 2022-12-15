package subway.domain.service;

import subway.domain.dto.PathRequestDto;
import subway.domain.dto.PathResponseDto;
import subway.domain.model.path.PathResult;
import subway.domain.model.Section;
import subway.domain.model.path.ShortestDistancePath;
import subway.domain.model.path.ShortestPath;
import subway.domain.model.path.ShortestTimePath;
import subway.domain.model.Station;
import subway.domain.repository.SectionRepository;
import subway.domain.repository.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SubwayPathService {

    private final ShortestPath shortestDistancePath;
    private final ShortestPath shortestTimePath;

    public SubwayPathService() {
        List<Station> stations = StationRepository.stations();
        List<Section> sections = SectionRepository.sections();
        this.shortestDistancePath = new ShortestDistancePath(stations, sections);
        this.shortestTimePath = new ShortestTimePath(stations, sections);
    }

    public PathResponseDto getShortestPath(PathRequestDto pathRequestDto) {
        PathStandard pathStandard = pathRequestDto.getPathStandard();
        Station startStation = StationRepository.findByName(pathRequestDto.getStartStation());
        Station endStation = StationRepository.findByName(pathRequestDto.getEndStation());

        if (pathStandard.isDistance()) {
            return calculateDistancePath(startStation, endStation);
        }
        if (pathStandard.isTime()) {
            return calculateTimePath(startStation, endStation);
        }
        throw new IllegalStateException();
    }

    private PathResponseDto calculateDistancePath(Station startStation, Station endStation) {
        PathResult pathResult = shortestDistancePath.calculatePath(startStation, endStation);
        List<String> stationsNames = mapToName(pathResult.getStations());
        return new PathResponseDto(pathResult.getWeight(), calculateTime(pathResult), stationsNames);
    }

    private PathResponseDto calculateTimePath(Station startStation, Station endStation) {
        PathResult pathResult = shortestTimePath.calculatePath(startStation, endStation);
        List<String> stationsNames = mapToName(pathResult.getStations());
        return new PathResponseDto(calculateDistance(pathResult), pathResult.getWeight(), stationsNames);
    }

    private int calculateTime(PathResult pathResult) {
        List<List<String>> edgeStationNames = pathResult.getEdgeStationNames();
        List<Section> sections = SectionRepository.findByEdgeStationNames(edgeStationNames);
        return calculateTimeSum(sections);
    }

    private int calculateTimeSum(List<Section> sections) {
        return sections.stream()
                .mapToInt(Section::getTime)
                .sum();
    }

    private int calculateDistance(PathResult pathResult) {
        List<List<String>> edgeStationNames = pathResult.getEdgeStationNames();
        List<Section> sections = SectionRepository.findByEdgeStationNames(edgeStationNames);
        return calculateDistanceSum(sections);
    }

    private int calculateDistanceSum(List<Section> sections) {
        return sections.stream()
                .mapToInt(Section::getDistance)
                .sum();
    }

    private List<String> mapToName(List<Station> stations) {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
}
