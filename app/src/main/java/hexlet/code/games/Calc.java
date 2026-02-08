package hexlet.code.games;

/**
 * Игра "Калькулятор".
 * Пользователю показывается арифметическое выражение,
 * нужно вычислить его результат.
 */
public final class Calc extends BaseGame {
    /** Правило игры. */
    private static final String RULE = "What is the result of the expression?";
    /** Оператор сложения. */
    private static final String PLUS_OPERATOR = "+";
    /** Оператор вычитания. */
    private static final String MINUS_OPERATOR = "-";
    /** Оператор умножения. */
    private static final String MULTIPLY_OPERATOR = "*";
    /** Минимальное значение для первого числа. */
    private static final int FIRST_NUMBER_MIN = 1;
    /** Максимальное значение для первого числа. */
    private static final int FIRST_NUMBER_MAX = 20;
    /** Минимальное значение для второго числа. */
    private static final int SECOND_NUMBER_MIN = 1;
    /** Максимальное значение для второго числа. */
    private static final int SECOND_NUMBER_MAX = 10;

    /**
     * Вычисляет результат арифметического выражения.
     *
     * @param firstNumber первое число
     * @param secondNumber второе число
     * @param operator оператор (+, -, *)
     * @return результат вычисления
     */
    private int calculate(final int firstNumber,
                          final int secondNumber,
                          final String operator) {
        switch (operator) {
            case PLUS_OPERATOR:
                return firstNumber + secondNumber;
            case MINUS_OPERATOR:
                return firstNumber - secondNumber;
            case MULTIPLY_OPERATOR:
                return firstNumber * secondNumber;
            default:
                throw new IllegalArgumentException(
                    "Неизвестный оператор: " + operator
                );
        }
    }

    /**
     * Генерирует случайный арифметический оператор.
     *
     * @return строковое представление оператора
     */
    private String generateRandomOperator() {
        final String[] operators = {PLUS_OPERATOR,
                                    MINUS_OPERATOR,
                                    MULTIPLY_OPERATOR};
        final int operatorIndex = RANDOM.nextInt(operators.length);

        return operators[operatorIndex];
    }

    /**
     * Генерирует пару вопрос-ответ для одного раунда.
     *
     * @return массив [вопрос, правильный ответ]
     */
    private String[] generateQuestionAnswerPair() {
        final int firstNumber = generateRandomNumber(
            FIRST_NUMBER_MIN, FIRST_NUMBER_MAX
        );

        final int secondNumber = generateRandomNumber(
            SECOND_NUMBER_MIN, SECOND_NUMBER_MAX
        );

        final String operator = generateRandomOperator();
        final int correctAnswer = calculate(firstNumber,
                                           secondNumber,
                                           operator);

        final String question = String.format(
            "%d %s %d", firstNumber, operator, secondNumber
        );

        return new String[]{question, Integer.toString(correctAnswer)};
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
