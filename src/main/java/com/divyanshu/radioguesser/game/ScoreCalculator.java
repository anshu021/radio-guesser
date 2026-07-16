package com.divyanshu.radioguesser.game;

import static com.divyanshu.radioguesser.common.constants.GameConstants.DISTANCE_SCALE;
import static com.divyanshu.radioguesser.common.constants.GameConstants.MAX_SCORE;

public final class ScoreCalculator {

    private ScoreCalculator() {}

    public static int calculate(double distanceInKm) {
        if (distanceInKm < 0) {
            throw new IllegalArgumentException(
                    "Distance cannot be negative."
            );
        }

        double normalizedDistance = distanceInKm / DISTANCE_SCALE;
        double score = MAX_SCORE * Math.exp(-normalizedDistance);

        return (int) Math.round(score);
    }
}
