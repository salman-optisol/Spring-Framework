package com.sallu.spring.gameapplication;

import org.springframework.stereotype.Component;

//@Component
public class GameImpl2 implements Game{
    @Override
    public void up() {
        System.out.println("Game 2 : UP");
    }

    @Override
    public void down() {
        System.out.println("Game 2 : DOWN");
    }
}
