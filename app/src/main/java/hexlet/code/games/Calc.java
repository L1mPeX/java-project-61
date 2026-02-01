package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс для игры в Calc.
 * @author L1mPeX
 */
public class Calc extends Games {
    /** Количество очков для победы. */
    private static final int WIN_SCORE = 3;

    /**
     * Конструктор класса.
     * @param sc Сканнер для ввода данных.
     */
    public Calc(final Scanner sc) {
        super(sc);
    }

    /**
     * Вычисление значения выражения.
     * @param firstVal первое целое число
     * @param secondVal второе целое число
     * @param operator строковое представление оператора
     * @return результат выражения
     */
    private int calculateExpression(final int firstVal, final int secondVal,
                                    final String operator) {
        switch (operator) {
            case "+":
                return firstVal + secondVal;
            case "-":
                return firstVal - secondVal;
            default:
                return firstVal * secondVal;
        }
    }

    /**
     * Определение строкового представления оператора.
     * @param operator числовое представление оператора
     * @return строковое представление оператора
     */
    private String defineOperator(final int operator) {
        switch (operator) {
            case 0:
                return "+";
            case 1:
                return "-";
            default:
                return "*";
        }
    }

    /**
     * Метод, который содержит логику игры.
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        Cli greetUser = new Cli(getScanner(), getUserName());
        greetUser.greet();

        setGameDescription("What is the result of the expression?");
        printGameDescriptionString();

        int firstVal;
        int secondVal;
        String operatorString;
        do {
            firstVal = generateRandomInt(Integer.MAX_VALUE / 2 - 1);
            secondVal = generateRandomInt(Integer.MAX_VALUE / 2 - 1);
            operatorString = defineOperator(generateRandomInt(2));
            printQuestion(firstVal, operatorString, secondVal);
            setUserAnswer(askUserInput());
            setCorrectAnswer(String.valueOf(calculateExpression(
                firstVal, secondVal, operatorString)));
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
