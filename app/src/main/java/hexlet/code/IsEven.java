package hexlet.code;

import java.util.Scanner;
import java.security.SecureRandom;

public class IsEven {
    private String greeting;
    private String name;
    private String question;
    private StringBuilder loserMessage;
    private StringBuilder winnerMessage;
    private Scanner sc;
    private boolean win;
    private int score;

    IsEven() {
        this.greeting = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        this.question = "Question: ";
        this.loserMessage = new StringBuilder();
        this.winnerMessage = new StringBuilder();
        this.sc = new Scanner(System.in);
        this.score = 0;
        this.win = true;
    }

    @SuppressWarnings("java:S106")
    public void playGame() {
        String userAnswer;
        int randomNumber;
        printGreetingString();
        while (score != 3 && win) {
            randomNumber = new SecureRandom().nextInt(Integer.MAX_VALUE - 1);
            System.out.println(question + randomNumber);
            userAnswer = sc.nextLine();
            if (isEven(randomNumber)) {
                if (userAnswer.trim().equals("yes"))
                    score++;
                else {
                    printLoserString(userAnswer, "yes");
                    win = false;
                }
            } else {
                if (userAnswer.trim().equals("no"))
                    score++;
                else {
                    printLoserString(userAnswer, "no");
                    win = false;
                }
            }
        }
        if (win) {
            printWinnerString();
        }
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    @SuppressWarnings("java:S106")
    private void printGreetingString() {
        System.out.println(greeting);
    }

    @SuppressWarnings("java:S106")
    private void printWinnerString() {
        winnerMessage.insert(0, "Congratulations, ")
                .append(name);
        System.out.println(winnerMessage.toString());
    }

    @SuppressWarnings("java:S106")
    private void printLoserString(String userInpuString, String correctAnswer) {
        loserMessage.insert(0, "\'" + userInpuString + "\'")
                .append(" is wrong answer ;(. Correct answer was ")
                .append("\'" + correctAnswer + "\'")
                .append('.')
                .append("\n")
                .append("Let's try again, ")
                .append(name);
        System.out.println(loserMessage.toString());
    }

    @SuppressWarnings("java:S106")
    public void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
        scanner.close();
        System.out.println("Hello, " + name + "!");
    }

    @Override
    public String toString() {
        return new StringBuilder("IsEven{").append(score).append('}').toString();
    }

}
