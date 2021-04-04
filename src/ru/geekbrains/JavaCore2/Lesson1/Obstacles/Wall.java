package ru.geekbrains.JavaCore2.Lesson1.Obstacles;

import ru.geekbrains.JavaCore2.Lesson1.Obstacles.Interface.Obstacle;
import ru.geekbrains.JavaCore2.Lesson1.Personage.Interface.Jumpable;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Object personage){
        if (personage instanceof Jumpable) {
            return ((Jumpable) personage).jump(height);
        }else {
            System.out.println("Не способен прыгать");
            return false;
        }
    }
}
