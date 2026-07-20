package com.divyanshu.radioguesser.game;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GameSessionManager {

        private final Map<UUID, GameSession> activeGames = new ConcurrentHashMap<>();

        public void addGameSession(GameSession session) {
            activeGames.put(session.gameId(), session);
        }

        public GameSession getGameSession(UUID gameId) {
            GameSession session = activeGames.get(gameId);

            if(session == null) {
                throw new IllegalArgumentException("Game Session Not Found");
            }

            return session;
        }

        public void removeGameSession(UUID gameId) {
            activeGames.remove(gameId);
        }
}
