package ru.geekbrains.JavaCore2.Lesson1;

import ru.geekbrains.JavaCore2.Lesson1.Obstacles.Interface.Obstacle;
import ru.geekbrains.JavaCore2.Lesson1.Obstacles.Treadmill;
import ru.geekbrains.JavaCore2.Lesson1.Obstacles.Wall;
import ru.geekbrains.JavaCore2.Lesson1.Personage.Cat;
import ru.geekbrains.JavaCore2.Lesson1.Personage.Human;
import ru.geekbrains.JavaCore2.Lesson1.Personage.Robot;

import java.util.Random;

public class Main {
    static Random random = new Random();
    static String[] nameCat = {"Барсик", "Мурзик", "Рыжик" };
    static String [] nameHuman = {"Василий", "Валерия", "Петр", "Мария" };
    private static String[] nameRobot = {"T1000", "T800", "СВЧ"};


    public static void main(String [] args){
        Object[] party = createParty(4);
        Obstacle[] obstacles = createObstacles(5);

        for (int i = 0; i < party.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if(!obstacles[j].overcome(party[i])){
                    System.out.println(party[i] + " сходит с дистанции");
                    break;
                }
                if(j == obstacles.length -1){
                    System.out.println(party[i] + " прошел всю полосу препятствий");
                }
            }
        }
    }

    private static Object[] createParty(int quantity){
        Object[] party = new Object[quantity];
        for (int i = 0; i < party.length; i++) {
            party[i] = randomPersonage();
        }
        return party;
    }

    private static Object randomPersonage(){
        switch (random.nextInt(3)){
            case 0: return new Cat(nameRandom(nameCat), random.nextInt(2)+2, random.nextInt(10)+20);
            case 1: return new Human(nameRandom(nameHuman), random.nextInt(3)+1, random.nextInt(20)+30);
            case 2: return new Robot(nameRandom(nameRobot), random.nextInt(10), random.nextInt(100));
            default: return null;
        }
    }

    private static Obstacle[] createObstacles(int quantity){
        Obstacle [] obstacles = new Obstacle[quantity];
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = randomObstacle();
        }
        return obstacles;
    }

    private static Obstacle randomObstacle(){
        switch (random.nextInt(2)){
            case 0: return new Treadmill(random.nextInt(30));
            case 1: return new Wall(random.nextInt(3));
            default: return null;
        }
    }

    private static String nameRandom(String [] names){
        return names[random.nextInt(names.length)];
    }
}
