package hexlet.code.games;

/**
 * Игра "Проверка на чётность".
 * Пользователю показывается число, нужно ответить "yes" если число чётное,
 * иначе "no".
 */
public final class Even extends BaseGame {
    /** Правило игры. */
    private static final String RULE =
        "Answer 'yes' if the number is even, otherwise answer 'no'.";
    /** Ответ для чётного числа. */
    private static final String EVEN_ANSWER = "yes";
    /** Ответ для нечётного числа. */
    private static final String ODD_ANSWER = "no";

    /**
     * Проверяет, является ли число чётным.
     *
     * @param number число для проверки
     * @return true если число чётное, false если нечётное
     */
    private boolean isEven(final int number) {
        return number % 2 == 0;
    }

    /**
     * Генерирует пару вопрос-ответ для одного раунда.
     *
     * @return массив [вопрос, правильный ответ]
     */
    private String[] generateQuestionAnswerPair() {
        final int number = generateRandomNumber();
        final String question = Integer.toString(number);
        final String correctAnswer = isEven(number) ? EVEN_ANSWER : ODD_ANSWER;

        return new String[]{question, correctAnswer};
    }

    @Override
    public String getRule() {
        return RULE;
    }

    @Override
    public String[][] getQuestionsAndAnswers() {
        final String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateQuestionAnswerPair();
        }

        return questionsAndAnswers;
    }
}
