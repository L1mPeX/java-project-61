package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс для игры в Progression.
 * @author L1mPeX
 */
public class Progression extends Games {
    /** Длина прогрессии. */
    private static final int PROGRESSION_LENGTH = 10;
    /** Максимальный шаг прогрессии. */
    private static final int MAX_STEP = 1000;
    /** Количество очков для победы. */
    private static final int WIN_SCORE = 3;

    /**
     * Конструктор класса.
     * @param sc Сканнер для ввода данных.
     */
    public Progression(final Scanner sc) {
        super(sc);
    }

    /**
     * Метод для создания последовательности.
     * @return последовательность
     */
    private int[] generateSequence() {
        int step = generateRandomInt(MAX_STEP);
        int firstElement = generateRandomInt(Integer.MAX_VALUE
                - (step * PROGRESSION_LENGTH) - 1);
        int[] sequence = {firstElement, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 1; i < PROGRESSION_LENGTH; i++) {
            sequence[i] = sequence[i - 1] + step;
        }

        return sequence;
    }

    /**
     * Метод для вывода последовательности без случайного элемента.
     * @param sequence последовательность
     * @param secretIndex индекс скрытого элемента
     * @return последовательность со скрытым элементом
     */
    private String maskSequence(final int[] sequence, final int secretIndex) {
        StringBuilder secretSequenceStringBuilder = new StringBuilder();
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            if (i == secretIndex) {
                secretSequenceStringBuilder.append(".. ");
                continue;
            }
            secretSequenceStringBuilder.append(sequence[i]).append(" ");
        }

        return secretSequenceStringBuilder.toString();
    }

    /**
     * Метод, который содержит логику игры.
     */
    @Override
    @SuppressWarnings("java:S106")
    public void playGame() {
        Cli greetUser = new Cli(getScanner(), getUserName());
        greetUser.greet();

        setGameDescription("What number is missing in the progression?");
        printGameDescriptionString();

        int[] sequence;
        int secretIndex;
        String correctAnswerString;
        do {
            sequence = generateSequence();
            secretIndex = generateRandomInt(PROGRESSION_LENGTH);
            printQuestion(maskSequence(sequence, secretIndex));
            setUserAnswer(askUserInput());
            correctAnswerString = String.valueOf(sequence[secretIndex]);
            setCorrectAnswer(correctAnswerString);
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
