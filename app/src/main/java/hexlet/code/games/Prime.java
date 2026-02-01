package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс для игры в Prime.
 * @author L1mPeX
 */
public class Prime extends Games {
    /** Количество очков для победы. */
    private static final int WIN_SCORE = 3;

    /**
     * Конструктор класса.
     * @param sc Сканнер для ввода данных.
     */
    public Prime(final Scanner sc) {
        super(sc);
    }

    /**
     * Метод для определения просто ли число.
     * @param firstVar число
     * @return простое ли число
     */
    private boolean isPrime(final int firstVar) {
        for (int i = 2; i < firstVar; i++) {
            if (firstVar % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод, который содержит логику игры.
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        Cli greetUser = new Cli(getScanner(), getUserName());
        greetUser.greet();

        setGameDescription("Answer 'yes' if given number is prime. "
            + "Otherwise answer 'no'.");
        printGameDescriptionString();

        int firstVal;
        do {
            firstVal = generateRandomInt(Integer.MAX_VALUE - 1);
            printQuestion(firstVal);
            setUserAnswer(askUserInput());
            setCorrectAnswer(isPrime(firstVal) ? "yes" : "no");
            if (getUserAnswer().equals(getCorrectAnswer())) {
                incrementScore();
                System.out.println("Correct!");
            }
        }
        while (!checkWin(getScore())
                && !checkLose(getUserAnswer(), getCorrectAnswer()));

        if (getScore() == WIN_SCORE) {
            printWinnerString();
        } else {
            printLoserString();
        }
    }
}
