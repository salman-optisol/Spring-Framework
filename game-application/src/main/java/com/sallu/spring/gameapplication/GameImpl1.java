package com.sallu.spring.gameapplication;

import org.springframework.stereotype.Component;

@Component
public class GameImpl1 implements Game{
    @Override
    public void up() {
        System.out.println("Game 1 : UP");
    }

    @Override
    public void down() {
        System.out.println("Game 1 : DOWN");
    }
}
