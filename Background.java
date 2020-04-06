package ru.gb.stream200302.java_2.lesson_1;

import java.awt.*;

public class Background {

    GameCanvas listener;

    Background (GameCanvas listener) {
        this.listener = listener;
    }

    void update (float gameTime){
        listener.setBackground(new Color (
                (int)(255-gameTime*5),
                (int)(255-gameTime*5),
                (int)(255-gameTime*5)
        ));
    }

}
