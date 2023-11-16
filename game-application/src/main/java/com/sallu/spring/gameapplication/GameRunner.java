package com.sallu.spring.gameapplication;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    Game game;

    public GameRunner(Game game) {
        this.game = game;
    }

    public void run() {
        game.up();
        game.down();
    }
}
