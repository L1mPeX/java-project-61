package hexlet.code.games;

/**
 * Игра "Простое ли число?".
 * Пользователю показывается число,
 * нужно ответить "yes" если число простое, иначе "no".
 */
public final class Prime extends BaseGame {
    /** Правило игры. */
    private static final String RULE =
        "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    /** Ответ для простого числа. */
    private static final String PRIME_ANSWER = "yes";
    /** Ответ для составного числа. */
    private static final String NOT_PRIME_ANSWER = "no";
    /** Минимальное значение для простых чисел. */
    private static final int MIN_PRIME_NUMBER = 2;

    /**
     * Проверяет, является ли число простым.
     *
     * @param number число для проверки
     * @return true если число простое, false если составное
     */
    private boolean isPrime(final int number) {
        if (number < MIN_PRIME_NUMBER) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Генерирует пару вопрос-ответ для одного раунда.
     *
     * @return массив [вопрос, правильный ответ]
     */
    private String[] generateQuestionAnswerPair() {
        final int number = generateRandomNumber();
        final String question = Integer.toString(number);

        final String correctAnswer = isPrime(number)
            ? PRIME_ANSWER
            : NOT_PRIME_ANSWER;

        return new String[]{question, correctAnswer};
    }

    @Override
    public String[][] getQuestionsAndAnswers() {
        final String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateQuestionAnswerPair();
        }

        return questionsAndAnswers;
    }

    @Override
    public String getRule() {
        return RULE;
    }
}
