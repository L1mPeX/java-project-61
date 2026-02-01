package hexlet.code.games;

import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Общий класс для игр, от которого потом будут наследоваться все остальные.
 * @author L1mPeX
 */
public class Games {
    /** Генератор случайных чисел. */
    private SecureRandom randomGenerator;
    /** Описание игры. */
    private String gameDescriptionString;
    /** Имя пользователя. */
    private String userNameString;
    /** Текст вопроса. */
    private String questionString;
    /** Ответ пользователя. */
    private String userAnswerString;
    /** Приглашение для ввода ответа. */
    private String answerPromptString;
    /** Правильный ответ. */
    private String correctAnswerString;
    /** Сообщение для проигравшего. */
    private StringBuilder loserMessage;
    /** Сообщение для победителя. */
    private StringBuilder winnerMessage;
    /** Сканер для ввода данных. */
    private Scanner sc;
    /** Флаг победы. */
    private boolean win;
    /** Счет игры. */
    private int score;
    /** Количество очков для победы. */
    private static final int WIN_SCORE = 3;

    /**
     * Конструктор класса.
     * @param scanner Сканнер для ввода данных.
     */
    protected Games(final Scanner scanner) {
        this.sc = scanner;
        this.score = 0;
        this.win = true;
        this.questionString = "Question: ";
        this.answerPromptString = "Your answer: ";
        this.userNameString = askUserName(scanner);
        this.loserMessage = new StringBuilder();
        this.winnerMessage = new StringBuilder();
        this.randomGenerator = new SecureRandom();
    }

    /**
     * Конструктор класса.
     * @param scanner Сканнер для ввода данных.
     * @param name Имя пользователя.
     */
    protected Games(final Scanner scanner, final String name) {
        this.sc = scanner;
        this.score = 0;
        this.win = true;
        this.questionString = "Question: ";
        this.answerPromptString = "Your answer: ";
        this.userNameString = name;
        this.loserMessage = new StringBuilder();
        this.winnerMessage = new StringBuilder();
        this.randomGenerator = new SecureRandom();
    }

    /**
     * Метод, который содержит логику игры.
     */
    @SuppressWarnings("java:S1186")
    public void playGame() {
    }

    /**
     * Метод для генерации случайного целого числа.
     * @return случайное целое число [0, Integer.MAX_VALUE]
     */
    protected int generateRandomInt() {
        return generateRandomInt(Integer.MAX_VALUE - 1);
    }

    /**
     * Метод для генерации случайного целого числа.
     * @param maxInt максимальное значение
     * @return случайное целое число [0, maxInt]
     */
    protected int generateRandomInt(final int maxInt) {
        return randomGenerator.nextInt(maxInt);
    }

    /**
     * Метод для запроса имени пользователя.
     * @param scanner сканнер
     * @return имя пользователя
     */
    @SuppressWarnings("java:S106")
    protected String askUserName(final Scanner scanner) {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        return scanner.nextLine();
    }

    /**
     * Метод для запроса ввода пользователя.
     * @return ввод пользователя
     */
    @SuppressWarnings("java:S106")
    protected String askUserInput() {
        System.out.print(answerPromptString);
        return sc.nextLine();
    }

    /**
     * Метод для проверки победы.
     * @param gameScore счет в игре
     * @return победил ли пользователь
     */
    protected boolean checkWin(final int gameScore) {
        return gameScore == WIN_SCORE;
    }

    /**
     * Метод для проверки проигрыша.
     * @param userAnswer ответ пользователя
     * @param correctAnswer правильный ответ
     * @return проиграл ли пользователь
     */
    protected boolean checkLose(final String userAnswer,
                                final String correctAnswer) {
        return !userAnswer.equals(correctAnswer);
    }

    /**
     * Метод для вывода строки проигрыша.
     * @return строка с сообщением проигрыша
     */
    protected String generateWinnerString() {
        winnerMessage.insert(0, "Congratulations, ")
                .append(userNameString)
                .append("!");
        return winnerMessage.toString();
    }

    /**
     * Метод для вывода строки проигрыша.
     * @param userAnswer ответ пользователя
     * @param correctAnswer правильный ответ
     * @return строка с сообщением проигрыша
     */
    protected String generateLoserString(final String userAnswer,
                                         final String correctAnswer) {
        loserMessage.insert(0, "\'" + userAnswer + "\'")
                .append(" is wrong answer ;(. Correct answer was ")
                .append("\'" + correctAnswer + "\'")
                .append('.')
                .append("\n")
                .append("Let's try again, ")
                .append(userNameString)
                .append("!");
        return loserMessage.toString();
    }

    /**
     * Метод печатающий строку победителя.
     */
    @SuppressWarnings("java:S106")
    protected void printWinnerString() {
        System.out.println(generateWinnerString());
    }

    /**
     * Метод печатающий строку проигравшего.
     */
    @SuppressWarnings("java:S106")
    protected void printLoserString() {
        System.out.println(generateLoserString(userAnswerString,
                correctAnswerString));
    }

    /**
     * Метод печатающий описание игры.
     */
    @SuppressWarnings("java:S106")
    protected void printGameDescriptionString() {
        System.out.println(gameDescriptionString);
    }

    /**
     * Метод печатающий полный вопрос игроку.
     * @param gameQuestionString строка вопроса
     */
    @SuppressWarnings("java:S106")
    protected void printQuestion(final String gameQuestionString) {
        System.out.println(questionString + gameQuestionString);
    }

    /**
     * Метод печатающий полный вопрос игроку.
     * @param gameQuestionInt число для вопроса
     */
    @SuppressWarnings("java:S106")
    protected void printQuestion(final int gameQuestionInt) {
        System.out.println(questionString + gameQuestionInt);
    }

    /**
     * Метод печатающий полный вопрос игроку.
     * @param gameQuestionFirstInt первое число для вопроса
     * @param gameQuestionSecondInt второе число для вопроса
     */
    @SuppressWarnings("java:S106")
    protected void printQuestion(final int gameQuestionFirstInt,
                                 final int gameQuestionSecondInt) {
        System.out.println(questionString + gameQuestionFirstInt
                + " " + gameQuestionSecondInt);
    }

    /**
     * Метод печатающий полный вопрос игроку.
     * @param gameQuestionFirstInt первое число для вопроса
     * @param gameQuestionFirstString строка оператора для вопроса
     * @param gameQuestionSecondInt второе число для вопроса
     */
    @SuppressWarnings("java:S106")
    protected void printQuestion(final int gameQuestionFirstInt,
                                 final String gameQuestionFirstString,
                                 final int gameQuestionSecondInt) {
        System.out.println(questionString + gameQuestionFirstInt
                + " " + gameQuestionFirstString + " " + gameQuestionSecondInt);
    }

    /**
     * Получить сканер для ввода данных.
     * @return сканер
     */
    protected final Scanner getScanner() {
        return sc;
    }

    /**
     * Получить имя пользователя.
     * @return имя пользователя
     */
    protected final String getUserName() {
        return userNameString;
    }

    /**
     * Установить описание игры.
     * @param description описание игры
     */
    protected final void setGameDescription(final String description) {
        this.gameDescriptionString = description;
    }

    /**
     * Установить ответ пользователя.
     * @param answer ответ пользователя
     */
    protected final void setUserAnswer(final String answer) {
        this.userAnswerString = answer;
    }

    /**
     * Получить ответ пользователя.
     * @return ответ пользователя
     */
    protected final String getUserAnswer() {
        return userAnswerString;
    }

    /**
     * Установить правильный ответ.
     * @param answer правильный ответ
     */
    protected final void setCorrectAnswer(final String answer) {
        this.correctAnswerString = answer;
    }

    /**
     * Получить правильный ответ.
     * @return правильный ответ
     */
    protected final String getCorrectAnswer() {
        return correctAnswerString;
    }

    /**
     * Установить счет игры.
     * @param newScore новый счет игры
     */
    protected final void setScore(final int newScore) {
        this.score = newScore;
    }

    /**
     * Получить счет игры.
     * @return счет игры
     */
    protected final int getScore() {
        return score;
    }

    /**
     * Увеличить счет игры на 1.
     */
    protected final void incrementScore() {
        this.score++;
    }
}
