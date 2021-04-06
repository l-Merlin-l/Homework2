package ru.geekbrains.JavaCore2.Lesson2;

public class MyArraySizeException extends Exception{
    public MyArraySizeException(){
        super("Размер массива не соответствует условию");
    }
}
