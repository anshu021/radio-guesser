package com.divyanshu.radioguesser.game.service;
import com.divyanshu.radioguesser.game.GameSession;
import com.divyanshu.radioguesser.game.dto.GameStartResponse;
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

    private final Map<UUID, GameSession> activeGames = new ConcurrentHashMap<>();

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

        activeGames.put(gameId, session);

        return new GameStartResponse(
                gameId,
                station.getStreamUrl()
        );
    }
}
