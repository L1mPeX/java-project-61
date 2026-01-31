package hexlet.code.games;

import java.util.Scanner;

/**
 * @author L1mPeX
 */
public class Calc extends Games {
    public Calc(Scanner sc) {
        super(sc);
    }

    /**
     * Метод, который содержит логику игры
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        Cli greetUser = new Cli(sc, userNameString);
        greetUser.greet();

        gameDescriptionString = "What is the result of the expression?";
        printGameDescriptionString();

        int firstVal;
        int secondVal;
        String operatorString;
        do {
            firstVal = generateRandomInt(Integer.MAX_VALUE / 2 - 1);
            secondVal = generateRandomInt(Integer.MAX_VALUE / 2 - 1);
            operatorString = defineOperator(generateRandomInt(2));
            printQuestion(firstVal + operatorString + secondVal);
            userAnswerString = askUserInput();
            correctAnswerString = String.valueOf(calculateExpression(firstVal, secondVal, operatorString));
            if (userAnswerString.equals(correctAnswerString)) {
                score++;
                System.out.println("Correct!");
            }
        }
        while (!checkWin(score) && !checkLose(userAnswerString, correctAnswerString));

        if (score == 3) {
            printWinnerString();
        }
        else {
            printLoserString();
        }
    }

    /**
     * Вычисление значения выражения
     * @param firstVal первое целое число
     * @param secondVal второе целое число
     * @param operator строковое представление оператора
     * @return результат выражения
     */
    private int calculateExpression(int firstVal, int secondVal, String operator) {
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
     * Определение строкового представления оператора
     * @param operator числовое представление оператора
     * @return строкове представление оператора
     */
    private String defineOperator(int operator) {
        switch (operator) {
            case 0:
                return "+";
            case 1:
                return "-";
            default:
                return "*";
        }
    }
}
