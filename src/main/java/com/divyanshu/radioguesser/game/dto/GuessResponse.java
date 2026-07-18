package com.divyanshu.radioguesser.game.dto;

import java.util.UUID;

public record GuessResponse(
        int score,
        double distanceKm,
        String stationName,
        String city,
        String country,
        double actualLatitude,
        double actualLongitude
) {
}
