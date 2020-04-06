package ru.gb.stream200302.java_2.lesson_1;

import java.awt.*;

public class Ball extends Sprite { // 25 создаем мячики, наследники спрайта

    private final Color color = new Color ( // 29 цвет шарикиа
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)
    );
    private float vX = (float)(100f + (Math.random() * 200f)); // 30 скорость шарикиа
    private float vY = (float)(100f + (Math.random() * 200f));

    Ball() { // 28 конструктор мячика
        halfHeight = 20 + (float)(Math.random() * 50f);
        halfWidth = halfHeight;
    }

    @Override
    void update(GameCanvas canvas, float deltaTime) { // 32 шарик может обновляться
        x += vX * deltaTime; // 33 изменять координаты
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) { 
            setLeft(canvas.getLeft());
            vX = -vX; // 34 если край мячика ушел за граница каонтвы, то мы меням знак скорости
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    void render(GameCanvas canvas, Graphics g) { // 31. шарик должен рентедриться
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }


}
