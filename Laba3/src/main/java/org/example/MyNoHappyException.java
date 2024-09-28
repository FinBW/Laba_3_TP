package org.example;

public class MyNoHappyException extends RuntimeException {
    private int j;
    private int i;
    private String s;
    public MyNoHappyException(int i, int j, String s) {
        super("Найдено моё несчастливое число " + s + " в ячейке номер "  + (i + 1) + " x " + (j + 1));
        this.i = i;
        this.j = j;
        this.s = s;
    }

}
