package hexlet.code.games;

import java.util.Scanner;

public class Progression extends Games {
    public Progression(Scanner sc) {
        super(sc);
    }

    /**
     * Метод для создания последовательности
     * @return последовательность
     */
    private int[] generateSequence() {
        int step = generateRandomInt(1000);
        int firstElement = generateRandomInt(Integer.MAX_VALUE - (step * 10) - 1);
        int[] sequence = {firstElement, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 1; i < 10; i++) {
            sequence[i] = sequence[i - 1] + step;
        }

        return sequence;
    }

    /**
     * Метод для вывода последовательности без случайного элемента
     * @param sequence последовательность
     * @param secretIndex индекс скрытого элемента
     * @return последовательность со скрытым элементом
     */
    private String maskSequence(int[] sequence, int secretIndex) {
        StringBuilder secretSequenceStringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (i == secretIndex) {
                secretSequenceStringBuilder.append("... ");
                continue;
            }
            secretSequenceStringBuilder.append(sequence[i]).append(" ");
        }
        
        return secretSequenceStringBuilder.toString();
    }

    /**
     * Метод, который содержит логику игры
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        Cli greetUser = new Cli(sc, userNameString);
        greetUser.greet();

        gameDescriptionString = "What number is missing in the progression?";
        printGameDescriptionString();

        int[] sequence;
        int secretIndex;
        String correctAnswerString;
        do {
            sequence = generateSequence();
            secretIndex = generateRandomInt(10);
            printQuestion(maskSequence(sequence, secretIndex));
            userAnswerString = askUserInput();
            correctAnswerString = String.valueOf(sequence[secretIndex]);
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
