package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс для игры в Even.
 * @author L1mPeX
 */
public class Even extends Games {
    /** Количество очков для победы. */
    private static final int WIN_SCORE = 3;

    /**
     * Конструктор класса.
     * @param sc Сканнер для ввода данных.
     */
    public Even(final Scanner sc) {
        super(sc);
    }

    /**
     * Метод для определения четное ли число.
     * @param val число
     * @return четное ли число
     */
    private boolean isEven(final int val) {
        return val % 2 == 0;
    }

    /**
     * Метод, который содержит логику игры.
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        Cli greetUser = new Cli(getScanner(), getUserName());
        greetUser.greet();

        setGameDescription("Answer 'yes' if the number is even, "
            + "otherwise answer 'no'.");
        printGameDescriptionString();

        int firstVal;
        do {
            firstVal = generateRandomInt();
            printQuestion(firstVal);
            setUserAnswer(askUserInput());
            setCorrectAnswer(isEven(firstVal) ? "yes" : "no");
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
