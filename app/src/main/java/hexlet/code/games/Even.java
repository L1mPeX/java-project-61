package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс для игры в Even
 * @author L1mPeX
 */
public class Even extends Games {
    public Even(Scanner sc) {
        super(sc);
    }

    /**
     * Метод для определения четное ли число
     * @param val число
     * @return четное ли число
     */
    private boolean isEven(int val) {
        return val % 2 == 0;
    }

    /**
     * Метод, который содержит логику игры
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        Cli greetUser = new Cli(sc, userNameString);
        greetUser.greet();

        gameDescriptionString = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        printGameDescriptionString();

        int firstVal;
        do {
            firstVal = generateRandomInt();
            printQuestion(firstVal);
            userAnswerString = askUserInput();
            correctAnswerString = isEven(firstVal) ? "yes" : "no";
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
}
