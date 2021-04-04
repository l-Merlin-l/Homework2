package ru.geekbrains.JavaCore2.Lesson1;

import ru.geekbrains.JavaCore2.Lesson1.Personage.Cat;
import ru.geekbrains.JavaCore2.Lesson1.Personage.Human;
import ru.geekbrains.JavaCore2.Lesson1.Personage.Robot;

import java.util.Random;

public class Team {
    private String nameTeam;
    private Object[] team;
    private boolean[] teamFinish;

    private Random random = new Random();
    private static final String[] nameCat = {"Барсик", "Мурзик", "Рыжик"};//набор для случайных имен котов
    private static final String[] nameHuman = {"Василий", "Валерия", "Петр", "Мария"};//набор для случайных имен людей
    private static final String[] nameRobot = {"T1000", "T800", "СВЧ"};//набор для случайных имен роботов

    public Team(String nameTeam, int quantity) {
        this.nameTeam = nameTeam;
        this.team = createTeam(quantity);
        this.teamFinish = new boolean[team.length];
        information();
    }

    public Object getPersonage(int i) {
        return team[i];
    }

    public int teamLength() {
        return team.length;
    }


    private Object[] createTeam(int quantity) {
        Object[] party = new Object[quantity];
        for (int i = 0; i < party.length; i++) {
            party[i] = randomPersonage();
        }
        return party;
    }

    private Object randomPersonage() {
        switch (random.nextInt(3)) {
            case 0:
                return new Cat(nameRandom(nameCat), randomSkill(2, 1), randomSkill(20, 10));
            case 1:
                return new Human(nameRandom(nameHuman), randomSkill(1, 2), randomSkill(50, 30));
            case 2:
                return new Robot(nameRandom(nameRobot), randomSkill(0, 10), randomSkill(0, 100));
            default:
                return null;
        }
    }

    private String nameRandom(String[] names) {
        return names[random.nextInt(names.length)];
    }

    private int randomSkill(int minValue, int deviation) {//случайное значение возможности существа (минимальное, + случайное увеличение)
        return random.nextInt(deviation + 1) + minValue;
    }

    public void information() {
        System.out.println("Команда " + this.nameTeam + "{");
        for (Object personage : team) {
            System.out.println(personage);
        }
        System.out.println("}");
    }

    public void setPersonageFinish(int i) {
        teamFinish[i] = true;
    }

    public void finished() {
        System.out.println("Финишировали в команде " + nameTeam + "{");
        for (int i = 0; i < team.length; i++) {
            if (teamFinish[i]) {
                System.out.println(team[i]);
            }
        }
        System.out.println("}");
    }
}
