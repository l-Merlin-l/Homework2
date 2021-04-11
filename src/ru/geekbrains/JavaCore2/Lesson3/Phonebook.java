package ru.geekbrains.JavaCore2.Lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>> phonebook = new HashMap<>();

    public void add(String surname, String number) {
        if (phonebook.containsKey(surname)) {
            phonebook.get(surname).add(number);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(number);
            phonebook.put(surname, numbers);
        }
    }

    public List<String> get(String surname) {
        if (phonebook.containsKey(surname)) {
            return phonebook.get(surname);
        }
        return new ArrayList<>();
    }
}
