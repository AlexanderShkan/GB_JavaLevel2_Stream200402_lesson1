package ru.gb.stream200302.java_2.lesson_1;

import javax.swing.*;
import java.awt.*;

public class MainCircles extends JFrame { // 1. приложение с летающими шариками МЦ основной контроллер игры
    private static final int POS_X = 400; //
    private static final int POS_Y = 200; //
    private static final int WINDOW_WIDTH = 800; //
    private static final int WINDOW_HEIGHT = 600; //

    Sprite[] sprites = new Sprite[10]; // 23 в нащей программе будет масов спрайтов из 10 элементов

    public static void main(String[] args) { //
        SwingUtilities.invokeLater(new Runnable() { // 2. класс SwingUtilities метод invokeLater вызов конструктора Runnable
            @Override
            public void run() { // 3. переопределение метода рун
                new MainCircles(); //
            }
        });
    }

    private MainCircles() { // 4. игровое окно с размерами
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this); //10. добавдяем канву (передаем себя)
        add(canvas, BorderLayout.CENTER);
        setTitle("Circles");
        initApplication(); // 24 Инициализируем наше приложение
        setVisible(true); //отрисовка рабоыт программы, (т.е. результат работы цикла)
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onCanvasRepainted(GameCanvas canvas, Graphics g, float deltaTime) { // 11 выполяем метод когда конва перерисовалась, передаем дельту времени
        update(canvas, deltaTime); // 15 обновление объектов которые находятся на конве, относительно прошедшего времени
        render(canvas, g); // 16 отрисовывать будем компоенеты, которые находятся на конве при помощи объектов графики
    }

    private void update(GameCanvas canvas, float deltaTime) { // 17
        for (int i = 0; i < sprites.length; i++) { //26 обновляем мячики
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) { // 18 рисуем при помощи графики, рендерим
        for (int i = 0; i < sprites.length; i++) { // 27 рендерим мячики
            sprites[i].render(canvas, g);
        }
    }
}
