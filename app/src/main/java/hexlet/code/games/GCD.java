package hexlet.code.games;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Код для игры в GCD.
 * @author L1mPeX
 */
public class GCD extends Games {
    /** Количество очков для победы. */
    private static final int WIN_SCORE = 3;

    /**
     * Конструктор класса.
     * @param sc Сканнер для ввода данных.
     */
    public GCD(final Scanner sc) {
        super(sc);
    }

    /**
     * Метод для вычисления НОД.
     * @param firstVal число
     * @param secondVal число
     * @return НОД
     */
    private int calcGCD(final int firstVal, final int secondVal) {
        BigInteger valA = BigInteger.valueOf(firstVal);
        BigInteger valB = BigInteger.valueOf(secondVal);
        BigInteger gcdVal = valA.gcd(valB);

        return gcdVal.intValue();
    }

    /**
     * Метод, который содержит логику игры.
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        Cli greetUser = new Cli(getScanner(), getUserName());
        greetUser.greet();

        setGameDescription("Find the greatest common divisor"
                + " of given numbers.");
        printGameDescriptionString();

        int firstVal;
        int secondVal;
        do {
            firstVal = generateRandomInt();
            secondVal = generateRandomInt();
            printQuestion(firstVal, secondVal);
            setUserAnswer(askUserInput());
            setCorrectAnswer(String.valueOf(calcGCD(firstVal, secondVal)));
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
