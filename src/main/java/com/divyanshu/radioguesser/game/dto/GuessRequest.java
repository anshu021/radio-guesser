package com.divyanshu.radioguesser.game.dto;

import java.util.UUID;

public record GuessRequest(
        UUID gameId,
        double latitude,
        double longitude
) {
}
