package hexlet.code.games;

/**
 * Игра "Наибольший общий делитель".
 * Пользователю показывается два числа,
 * нужно найти их наибольший общий делитель.
 */
public final class GCD extends BaseGame {
    /** Правило игры. */
    private static final String RULE =
        "Find the greatest common divisor of given numbers.";

    /**
     * Вычисляет наибольший общий делитель двух чисел.
     *
     * @param a первое число
     * @param b второе число
     * @return наибольший общий делитель
     */
    private int calculateGcd(final int a, final int b) {
        int tempA = a;
        int tempB = b;

        while (tempB != 0) {
            final int temp = tempB;
            tempB = tempA % tempB;
            tempA = temp;
        }

        return Math.abs(tempA);
    }

    /**
     * Генерирует пару вопрос-ответ для одного раунда.
     *
     * @return массив [вопрос, правильный ответ]
     */
    private String[] generateQuestionAnswerPair() {
        final int firstNumber = generateRandomNumber();
        final int secondNumber = generateRandomNumber();
        final int gcd = calculateGcd(firstNumber, secondNumber);

        final String question = String.format(
            "%d %d", firstNumber, secondNumber
        );

        return new String[]{question, Integer.toString(gcd)};
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
