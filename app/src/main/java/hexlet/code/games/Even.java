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
     * Метод, который содержит логику игры
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        System.out.println("Hello, " + userNameString + "!");

        gameDescriptionString = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        printGameDescriptionString();

        int firstVal;
        do {
            firstVal = generateRandomInt();
            printQuestion(firstVal);
            userAnswerString = askdUserInput();
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

    private boolean isEven(int val) {
        return val % 2 == 0;
    }
}
