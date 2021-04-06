package ru.geekbrains.JavaCore2.Lesson2;

public class Main {
    private static final int lengthArray = 4;
    private static int sum = 0;

    public static void main(String[] args) {

        //Правильный массив
        try {
            arrayFour(new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}});
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        //Массив с тектсом
        try {
            arrayFour(new String[][]{{"1", "2", "3", "4"}, {"5", "6f", "7", "8"}, {"9", "10", "11", "12d"}, {"13", "14", "15", "16"}});
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        //Массив не соответвтсвующий размерам
        try {
            arrayFour(new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11"}, {"13", "14", "15", "16"}});
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            arrayFour(new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12в"},{"13", "14", "15", "16"},{"17", "18", "19", "20"}});
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    private static void arrayFour(String[][] myArray) throws MyArraySizeException, MyArrayDataException {
        if (myArray.length != lengthArray) {
            throw new MyArraySizeException();
        } else {
            for (String[] arr : myArray) {
                if (arr.length != lengthArray) {
                    throw new MyArraySizeException();
                }
            }
        }

        for (int i = 0; i < lengthArray; i++) {
            for (int j = 0; j < lengthArray; j++) {
                try {
                    sum += Integer.parseInt(myArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не число в ячейке " + i + " " + j);
                }
            }
        }

        System.out.println("Сумма значений в массиве равна -> " + sum);
    }
}
