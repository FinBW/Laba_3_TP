package org.example;

public class MyArrayDataException extends RuntimeException {
    private int j;
    private int i;
    private String s;
    public MyArrayDataException(int i, int j, String s) {
        super("Неверное значение в массиве. Некорректный символ - " + s + " Ошибка в ячейке " + (i + 1) + " x " + (j + 1));
        this.i = i;
        this.j = j;
        this.s = s;
    }
}
