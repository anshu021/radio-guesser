package com.divyanshu.radioguesser.game;

import com.divyanshu.radioguesser.radio.RadioStation;

public record RoundResult (
        RadioStation station,
        Guess guess,
        double distanceInKm,
        int score){

}
