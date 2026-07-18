package com.divyanshu.radioguesser.game.controller;


import com.divyanshu.radioguesser.game.dto.GameStartResponse;
import com.divyanshu.radioguesser.game.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {

        private final GameService gameService;

        public GameController(GameService gameService) {
            this.gameService = gameService;
        }

        @PostMapping("/start")
        public GameStartResponse startGame(){
            return gameService.startGame();
        }

}
