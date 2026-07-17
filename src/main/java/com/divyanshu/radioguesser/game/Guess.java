package com.divyanshu.radioguesser.game;

import com.divyanshu.radioguesser.geo.Coordinate;

import java.time.Instant;

public record Guess (Coordinate coordinate, Instant guessedAt){
}
