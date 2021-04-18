package ru.geekbrains.JavaCore2.Lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int SIZE = 10000000;
    static final int H = SIZE / 2;
    private static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        initArr();
        estimation();

        initArr();
        long timeStart = System.currentTimeMillis();
        try {
            estimationThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Общее время с параллельной обработкой: " + (System.currentTimeMillis() - timeStart));
    }

    private static void estimation() {
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время прямой работы: " + (System.currentTimeMillis() - timeStart));
    }

    private static void estimationThread() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        float[] a1 = new float[H];
        float[] a2 = new float[H];
        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);
        System.out.println("Время разделения массива: " + (System.currentTimeMillis() - timeStart));

        timeStart = System.currentTimeMillis();
        List<СalculationArray> сalculationArrays = new ArrayList<>(2);
        сalculationArrays.add(new СalculationArray(a1));
        сalculationArrays.add(new СalculationArray(a2));

        List<Thread> threadList = new ArrayList<>(2);
        for (СalculationArray сalculationArray : сalculationArrays) {
            threadList.add(new Thread(сalculationArray));
        }

        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }

        System.arraycopy(сalculationArrays.get(0).getArr(), 0, arr, 0, H);
        System.arraycopy(сalculationArrays.get(1).getArr(), 0, arr, H, H);
        System.out.println("Время параллельной обработки работы: " + (System.currentTimeMillis() - timeStart));
    }

    private static void initArr() {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1f;
        }
    }
}
