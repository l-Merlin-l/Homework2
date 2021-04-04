package ru.geekbrains.JavaCore2.Lesson1;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(5);
        Team team = new Team("Лучшие", 4);

        course.overcoming(team);
    }
}
