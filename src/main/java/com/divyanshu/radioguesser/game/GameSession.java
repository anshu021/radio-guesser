package com.divyanshu.radioguesser.game;

import com.divyanshu.radioguesser.radio.RadioStation;

import java.time.Instant;
import java.util.UUID;

public record GameSession(
        UUID gameId,
        RadioStation radioStation,
        Instant startedAt
) {
}
