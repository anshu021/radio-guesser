package com.divyanshu.radioguesser.radio;
import com.divyanshu.radioguesser.geo.Coordinate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class InMemoryRadioStationProvider
implements RadioStationProvider {

    public InMemoryRadioStationProvider() {
        this.stations = createStations();
    }

    private final List<RadioStation> stations;

    private final Random random = new Random();

    @Override
    public RadioStation getRandomStation() {
        int index = random.nextInt(stations.size());
        return stations.get(index);
    }


    private List<RadioStation> createStations() {

        List<RadioStation> stations = new ArrayList<>();

        stations.add(
                new RadioStation(
                        UUID.randomUUID(),
                        "BBC Radio 1",
                        "https://example.com/bbc",
                        new Coordinate(51.5074, -0.1278),
                        "United Kingdom",
                        "London",
                        "English",
                        Set.of("pop", "music")
                )
        );

        stations.add(
                new RadioStation(
                        UUID.randomUUID(),
                        "Radio Mirchi Mumbai",
                        "https://example.com/mirchi",
                        new Coordinate(19.0760, 72.8777),
                        "India",
                        "Mumbai",
                        "Hindi",
                        Set.of("bollywood", "music")
                )
        );

        stations.add(
                new RadioStation(
                        UUID.randomUUID(),
                        "NHK World",
                        "https://example.com/nhk",
                        new Coordinate(35.6762, 139.6503),
                        "Japan",
                        "Tokyo",
                        "Japanese",
                        Set.of("news")
                )
        );

        stations.add(
                new RadioStation(
                        UUID.randomUUID(),
                        "KEXP Seattle",
                        "https://example.com/kexp",
                        new Coordinate(47.6062, -122.3321),
                        "USA",
                        "New York",
                        "English",
                        Set.of("indie", "rock")
                )
        );

        stations.add(
                new RadioStation(
                        UUID.randomUUID(),
                        "ABC Radio Sydney",
                        "https://example.com/abc",
                        new Coordinate(-33.8688, 151.2093),
                        "Australia",
                        "Sydney",
                        "English",
                        Set.of("news", "talk")
                )
        );

        return stations;
    }

    public static void main(String[] args) {

        RadioStationProvider provider = new InMemoryRadioStationProvider();

        for (int i = 0; i < 10; i++) {
            System.out.println(provider.getRandomStation().getName());
        }
    }

}
