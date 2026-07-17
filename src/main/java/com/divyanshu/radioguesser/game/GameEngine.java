package com.divyanshu.radioguesser.game;

import com.divyanshu.radioguesser.geo.Coordinate;
import com.divyanshu.radioguesser.geo.DistanceCalculator;
import com.divyanshu.radioguesser.radio.RadioStation;

import java.util.Objects;

public final class GameEngine {

        private GameEngine(){}


        public static RoundResult evaluateGuess(
                    RadioStation station,
                    Guess guess
            ){
                Objects.requireNonNull(station, "Station cannot be null");
                Objects.requireNonNull(guess, "Guess cannot be null");

                Coordinate actualCoordinate = station.getLocation();
                Coordinate guessedCoordinate =  guess.coordinate();

                double distanceKm = DistanceCalculator.calculate(
                        actualCoordinate,
                        guessedCoordinate
                );

                int score =  ScoreCalculator.calculate(distanceKm);

                return new RoundResult(
                        station,
                        guess,
                        distanceKm,
                        score
                );
            }

}
