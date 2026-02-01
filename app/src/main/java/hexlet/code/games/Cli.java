package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс для приветствия пользователя через командную строку.
 * @author l1mpex
 */
public class Cli extends Games {
    /**
     * Конструктор класса.
     * @param sc Сканнер для ввода данных.
     */
    public Cli(final Scanner sc) {
        super(sc);
    }

    /**
     * Конструктор класса.
     * @param sc Сканнер для ввода данных.
     * @param userNameString Имя пользователя.
     */
    public Cli(final Scanner sc, final String userNameString) {
        super(sc, userNameString);
    }

    /**
     * Метод, который содержит логику игры.
     */
    @SuppressWarnings("java:S106")
    public void greet() {
        System.out.println("Hello, " + getUserName() + "!");
    }
}
