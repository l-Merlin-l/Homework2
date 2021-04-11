package ru.geekbrains.JavaCore2.Lesson3;

import java.util.*;

public class Main {
    static Phonebook phonebook = new Phonebook();

    public static void main(String[] args) {
        System.out.println("Задание 1");
        List<String> words = Arrays.asList(new String[]{"яблоко", "кукла", "лев", "вино", "попугай",
                "пистолет", "яблоко", "маринад", "мясо", "Сталин",
                "Шекспир", "маринад", "лев", "лирика", "фазенда",
                "лев", "чистокол", "пистолет", "Сталин", "кукла"});
        analysisWords(words);


        System.out.println("Задание 2");
        phonebook.add("Кравченко", "+126510");
        phonebook.add("Петров", "+126235010");
        phonebook.add("Сидров", "+12651012");
        phonebook.add("Петров", "+116526510");

        getPhonebook("Петров");
        getPhonebook("Иванов");

    }

    private static void analysisWords(List<String> words) {
        Map<String, Integer> wordCount = getUniqueWords(words);
        printUnique(wordCount);
        printCountWord(wordCount);
    }

    private static Map<String, Integer> getUniqueWords(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, (wordCount.containsKey(word))
                    ? wordCount.get(word) + 1
                    : 1);
        }
        return wordCount;
    }

    private static void printUnique(Map<String, Integer> wordCount) {
        System.out.println("Уникальные слова:");
        for (String word : wordCount.keySet()) {
            System.out.println(word);
        }
    }

    private static void printCountWord(Map<String, Integer> wordCount) {
        System.out.println("Слова и количество повторений:");
        for (Map.Entry<String, Integer> word : wordCount.entrySet()) {
            System.out.println(word.getKey() + " -> " + word.getValue());
        }
    }

    private static void getPhonebook(String surname) {
        System.out.println("Номера телефонов по фамилии " + surname + " -> " + phonebook.get(surname));
    }
}
