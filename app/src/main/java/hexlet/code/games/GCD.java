package hexlet.code.games;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Код для игры в GCD
 * @author L1mPeX
 */
public class GCD extends Games{
    public GCD(Scanner sc) {
        super(sc);
    }

    private int calcGCD(int firstVal, int secondVal) {
        BigInteger valA = BigInteger.valueOf(firstVal);
        BigInteger valB = BigInteger.valueOf(secondVal);
        BigInteger gcdVal = valA.gcd(valB);
        
        return gcdVal.intValue();
    }

    /**
     * Метод, который содержит логику игры
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        Cli greetUser = new Cli(sc, userNameString);
        greetUser.greet();

        gameDescriptionString = "Find the greatest common divisor of given numbers.";
        printGameDescriptionString();

        int firstVal;
        int secondVal;
        do {
            firstVal = generateRandomInt();
            secondVal = generateRandomInt();
            printQuestion(firstVal, secondVal);
            userAnswerString = askUserInput();
            correctAnswerString = String.valueOf(calcGCD(firstVal, secondVal));
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
