package com.divyanshu.radioguesser.game.dto;

import java.util.Set;
import java.util.UUID;

public record GameStartResponse(
        UUID gameId,
        String streamUrl
) {
}
