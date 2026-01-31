package hexlet.code.games;

import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Общий класс для игр, от которого потом будут наследоваться все остальные
 * 
 * @author L1mPeX
 */
public class Games {
    protected String gameDescriptionString;
    protected String userNameString;
    protected String questionString;
    protected String userAnswerString;
    protected String answerPromptString;
    protected String correctAnswerString;
    protected StringBuilder loserMessage;
    protected StringBuilder winnerMessage;
    protected Scanner sc;
    protected boolean win;
    protected int score;

    /**
     * Конструктор класса 
     */
    protected Games(Scanner sc) {
        this.sc = sc;
        this.score = 0;
        this.win = true;
        this.questionString = "Question: ";
        this.answerPromptString = "Your answer: ";
        this.userNameString = askUserName(sc);
        this.loserMessage = new StringBuilder();
        this.winnerMessage = new StringBuilder();
    }

    /**
     * Конструктор класса 
     */
    protected Games(Scanner sc, String userNameString) {
        this.sc = sc;
        this.score = 0;
        this.win = true;
        this.questionString = "Question: ";
        this.answerPromptString = "Your answer: ";
        this.userNameString = userNameString;
        this.loserMessage = new StringBuilder();
        this.winnerMessage = new StringBuilder();
    }

    /**
     * Метод, который содержит логику игры
     */
    @SuppressWarnings("java:S1186")
    public void playGame() {}

    /**
     * Метод для генерации случайного целого числа
     * @return случайное целое число [0, Integer.MAX_VALUE]
     */
    protected int generateRandomInt() {
        return generateRandomInt(Integer.MAX_VALUE - 1);
    }

    /**
     * Метод для генерации случайного целого числа
     * @param maxInt максимальное значение
     * @return случайное целое число [0, maxInt]
     */
    protected int generateRandomInt(int maxInt) {
        return new SecureRandom().nextInt(maxInt);
    }

    /**
     * Метод для запроса имени пользователя
     * @param sc сканнер
     * @return имя пользователя
     */
    @SuppressWarnings("java:S106")
    protected String askUserName(Scanner sc) {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        return sc.nextLine();
    }

    /**
     * Метод для запроса ввода пользователя
     * @return ввод пользователя
     */
    @SuppressWarnings("java:S106")
    protected String askUserInput() {
        System.out.print(answerPromptString);
        return sc.nextLine();
    }

    /**
     * Метод для проверки победы
     * @param score счет в игре
     * @param userAnswer ответ пользователя
     * @param correctAnswer правильный ответ
     * @return победил ли пользователь
     */
    protected boolean checkWin(int score) {
        return score == 3;
    }

    /**
     * Метод для проверки проигрыша
     * @param userAnswer ответ пользователя
     * @param correctAnswer правильный ответ
     * @return проиграл ли пользователь
     */
    protected boolean checkLose(String userAnswer, String correctAnswer) {
        return !userAnswer.equals(correctAnswer);
    }


    /**
     * Метод для вывода строки проигрыша
     * @return строка с сообщением проигрыша
     */
    protected String generateWinnerString() {
        winnerMessage.insert(0, "Congratulations, ")
                .append(userNameString)
                .append("!");
        return winnerMessage.toString();
    }

    /**
     * Метод для вывода строки проигрыша
     * @param userAnswer ответ пользователя 
     * @param correctAnswer правильный ответ
     * @return строка с сообщением проигрыша
     */
    protected String generateLoserString(String userAnswer, String correctAnswer) {
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
     * Метод печатающий строку победителя
     */
    @SuppressWarnings("java:S106")
    protected void printWinnerString() {
        System.out.println(generateWinnerString());
    }

    /**
     * Метод печатающий строку проигравшего
     */
    @SuppressWarnings("java:S106")
    protected void printLoserString() {
        System.out.println(generateLoserString(userAnswerString, correctAnswerString));
    }

    /**
     * Метод печатающий описание игры
     */
    @SuppressWarnings("java:S106")
    protected void printGameDescriptionString() {
        System.out.println(gameDescriptionString);
    }

    /**
     * Метод печатающий полный вопрос игроку
     */
    @SuppressWarnings("java:S106")
    protected void printQuestion(String gameQuestionString) {
        System.out.println(questionString + gameQuestionString);
    }

    /**
     * Метод печатающий полный вопрос игроку
     */
    @SuppressWarnings("java:S106")
    protected void printQuestion(int gameQuestionInt) {
        System.out.println(questionString + gameQuestionInt);
    }
}
