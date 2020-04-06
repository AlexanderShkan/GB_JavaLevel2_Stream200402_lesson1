package ru.gb.stream200302.java_2.lesson_1;

import java.awt.*;

public abstract class Sprite { // 19 спрайт - это двумерный объекк, который может рисоваться
    protected float x; // концепуия двумерного объекта (где-то находится и что-то имеет)
    protected float y; // остальное асбракция, а вот наследники - шарики уже все занат
    protected float halfWidth; //
    protected float halfHeight; //
// 20 для того что бы эти объекты как-то удобно между собой взаимодействовали пишем гет и сет
    protected float getLeft() {
        return x - halfWidth;
    }
    protected void setLeft(float left) {
        x = left + halfWidth;
    }
    protected float getRight() {
        return x + halfWidth;
    }
    protected void setRight(float right) {
        x = right - halfWidth;
    }
    protected float getTop() {
        return y - halfHeight;
    }
    protected void setTop(float top) {
        y = top + halfHeight;
    }
    protected float getBottom() {
        return y + halfHeight;
    }
    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }
    protected float getWidth() {
        return 2f * halfWidth;
    }
    protected float getHeight() {
        return 2f * halfHeight;
    }

    void update(GameCanvas canvas, float deltaTime) {} // 21 спрайт будет обнолвять свое состояние
    void render(GameCanvas canvas, Graphics g) {} // 22 спрайт будет отрисовавываться с помощью объекта графики

}
