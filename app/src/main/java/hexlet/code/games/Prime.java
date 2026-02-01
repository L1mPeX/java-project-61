package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс для игры в Prime
 * @author L1mPeX
 */
public class Prime extends Games {
    public Prime(Scanner sc) {
        super(sc);
    }

    /**
     * Метод для определения просто ли число
     * @param firstVar число
     * @return простое ли число
     */
    private boolean isPrime(int firstVar) {
        for (int i = 2; i < firstVar; i++) {
            if (firstVar % i == 0) return false;
        }
        return true;
    }

    /**
     * Метод, который содержит логику игры
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        Cli greetUser = new Cli(sc, userNameString);
        greetUser.greet();

        gameDescriptionString = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        printGameDescriptionString();

        int firstVal;
        do {
            firstVal = generateRandomInt(Integer.MAX_VALUE - 1);
            printQuestion(firstVal);
            userAnswerString = askUserInput();
            correctAnswerString = isPrime(firstVal) ? "yes" : "no";
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
