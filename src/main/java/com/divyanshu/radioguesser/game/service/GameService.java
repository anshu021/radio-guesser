package com.divyanshu.radioguesser.game.service;
import com.divyanshu.radioguesser.game.*;
import com.divyanshu.radioguesser.game.dto.GameStartResponse;
import com.divyanshu.radioguesser.game.dto.GuessRequest;
import com.divyanshu.radioguesser.game.dto.GuessResponse;
import com.divyanshu.radioguesser.geo.Coordinate;
import org.springframework.stereotype.Service;

import com.divyanshu.radioguesser.radio.RadioStationProvider;
import com.divyanshu.radioguesser.radio.RadioStation;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {

    private final RadioStationProvider radioStationProvider;

    public GameService(RadioStationProvider radioStationProvider) {
        this.radioStationProvider = radioStationProvider;
    }

    public GameStartResponse startGame(){
        RadioStation station = radioStationProvider.getRandomStation();

        UUID gameId = UUID.randomUUID();

        GameSession session = new GameSession(
                gameId,
                station,
                Instant.now()
        );

        return new GameStartResponse(
                gameId,
                station.getStreamUrl()
        );
    }

    public GuessResponse submitGuess(GuessRequest request){
        GameSession session = gameSessionManager.getGameSession(request.gameId());

        Coordinate guessedCoordinate = new Coordinate(request.latitude(), request.longitude());

        Guess guess = new Guess(
                guessedCoordinate,
                Instant.now()
        );

        RoundResult result = GameEngine.evaluateGuess(
                session.radioStation(),
                guess
        );


        return new GuessResponse(
                result.score(),
                result.distanceInKm(),
                session.radioStation().getName(),
                session.radioStation().getCity(),
                session.radioStation().getCountry(),
                session.radioStation().getLocation().latitude(),
                session.radioStation().getLocation().longitude()
        );

    }
}
