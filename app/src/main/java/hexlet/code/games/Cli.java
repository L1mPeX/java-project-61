package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс для взаимодействия с пользователем через командную строку.
 * @author l1mpex
 */
public class Cli extends Games {
    public Cli(Scanner sc) {
        super(sc);
    }

    /**
     * Метод, который содержит логику игры
     */
    @SuppressWarnings("java:S106")
    @Override
    public void playGame() {
        System.out.println("Hello, " + userNameString + "!");
    }
}
