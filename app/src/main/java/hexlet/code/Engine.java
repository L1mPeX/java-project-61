package hexlet.code;

import java.util.Scanner;

/**
 * Движок для запуска игр.
 * Отвечает за взаимодействие с пользователем и проверку ответов.
 * Не знает о конкретных играх, работает только с интерфейсом Game.
 */
public class Engine {
    /** Приветственное сообщение. */
    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    /** Формат сообщения приветствия. */
    private static final String GREETING_FORMAT = "Hello, %s!";
    /** Сообщение о правильном ответе. */
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    /** Формат сообщения при ошибке. */
    private static final String WRONG_ANSWER_FORMAT =
        "'%s' is wrong answer ;(. Correct answer was '%s'.";
    /** Формат сообщения при победе. */
    private static final String WIN_FORMAT = "Congratulations, %s!";
    /** Формат сообщения при проигрыше. */
    private static final String LOSE_FORMAT = "Let's try again, %s!";
    /** Запрос имени пользователя. */
    private static final String NAME_REQUEST = "May I have your name? ";
    /** Запрос ответа пользователя. */
    private static final String ANSWER_REQUEST = "Your answer: ";
    /** Формат вопроса. */
    private static final String QUESTION_FORMAT = "Question: %s";

    /**
     * Запрашивает имя пользователя и приветствует его.
     *
     * @param scanner сканер для ввода данных
     * @return имя пользователя
     */
    private String greetUser(final Scanner scanner) {
        System.out.println(WELCOME_MESSAGE);
        System.out.print(NAME_REQUEST);
        final String userName = scanner.nextLine();
        System.out.println(String.format(GREETING_FORMAT, userName));
        return userName;
    }

    /**
     * Обрабатывает один раунд игры.
     *
     * @param scanner сканер для ввода данных
     * @param question вопрос текущего раунда
     * @param correctAnswer правильный ответ на вопрос
     * @return true если ответ правильный, false если нет
     */
    private boolean processRound(final Scanner scanner,
                                 final String question,
                                 final String correctAnswer) {
        System.out.println(String.format(QUESTION_FORMAT, question));
        System.out.print(ANSWER_REQUEST);
        final String userAnswer = scanner.nextLine();

        return checkAnswer(userAnswer, correctAnswer);
    }

    /**
     * Проверяет ответ пользователя.
     *
     * @param userAnswer ответ пользователя
     * @param correctAnswer правильный ответ
     * @return true если ответ правильный, false если нет
     */
    private boolean checkAnswer(final String userAnswer,
                                final String correctAnswer) {
        if (userAnswer.equals(correctAnswer)) {
            System.out.println(CORRECT_ANSWER_MESSAGE);
            return true;
        } else {
            System.out.println(
                String.format(WRONG_ANSWER_FORMAT, userAnswer, correctAnswer)
            );
            return false;
        }
    }

    /**
     * Завершает игру с выводом результата.
     *
     * @param userName имя пользователя
     * @param isWin true если пользователь выиграл, false если проиграл
     */
    private void finishGame(final String userName, final boolean isWin) {
        if (isWin) {
            System.out.println(String.format(WIN_FORMAT, userName));
        } else {
            System.out.println(String.format(LOSE_FORMAT, userName));
        }
    }

    /**
     * Запускает игру, используя предоставленный объект игры.
     *
     * @param game объект игры для запуска
     */
    public void play(final Game game) {
        final Scanner scanner = new Scanner(System.in);

        try {
            final String userName = greetUser(scanner);
            System.out.println(game.getRule());

            final String[][] questionAndAnswer = game.getQuestionsAndAnswers();

            for (int i = 0; i < questionAndAnswer.length; i++) {
                final String question = questionAndAnswer[i][0];
                final String correctAnswer = questionAndAnswer[i][1];

                final boolean isCorrect = processRound(scanner,
                                                       question,
                                                       correctAnswer);

                if (!isCorrect) {
                    finishGame(userName, false);
                    return;
                }
            }

            finishGame(userName, true);
        } finally {
            scanner.close();
        }
    }
}
