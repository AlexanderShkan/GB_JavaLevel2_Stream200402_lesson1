package ru.gb.stream200302.java_2.lesson_1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel { // 6. Игровая канва, на этой панели будет происходить игра

    MainCircles listener; //12 конва сообщает когда переирсовалась
    long lastFrameTime;
    Background background = new Background(this);

    GameCanvas(MainCircles listener) { //12 конва сообщает когда переирсовалась
        this.listener = listener; // 12 конва говорит, что отрисовалась и сообщает об этом слушателю
        lastFrameTime = System.nanoTime(); // 14 нужна для подсчета дельта времени
    }

    @Override
    protected void paintComponent(Graphics g) { //7. любой компонент в свинге может перерисовавываться по средсвам пейнкомпонента
        super.paintComponent(g); // 8. переопределяем пайнт компонет, чтобы канва рисовала все что мы ей дадим и сообщать что отрисовались, но это будет занимать какое-то время
        // System.out.println(System.currentTimeMilles()); промежуточный шаг, определяем время, которое идет с определенной частотой, но оно разное
        long currentTime = System.nanoTime(); //
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f; //13 считаем дельту времени
        lastFrameTime = currentTime; // ласт время = текущему
        listener.onCanvasRepainted(this, g, deltaTime); //12 говорим нашему слушателю
        try {
            Thread.sleep(17); // 10 заставляем конву постпать 1000/60=17 милисекунд,т.е. компонент будет отрисовываться 60 раз в секунду
        } catch (InterruptedException e) {
            e.printStackTrace(); // далее разберем
        }
        repaint(); // 9. бесконечно отрисовываться
    }
 // гетеры, которые возвращают границы панели, показывают какого размера панелька
    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}
