package ru.geekbrains.JavaCore2.Lesson1.Obstacles;

import ru.geekbrains.JavaCore2.Lesson1.Obstacles.Interface.Obstacle;
import ru.geekbrains.JavaCore2.Lesson1.Personage.Interface.Runnable;


public class Treadmill implements Obstacle {

    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcome(Object personage){
        if (personage instanceof Runnable){
            return ((Runnable) personage).run(distance);
        }else {
            System.out.println("Не способен бегать");
            return false;
        }
    }

}
