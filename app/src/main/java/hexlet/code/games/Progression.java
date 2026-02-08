package hexlet.code.games;

/**
 * Игра "Арифметическая прогрессия".
 * Пользователю показывается прогрессия с пропущенным элементом,
 * нужно определить этот элемент.
 */
public final class Progression extends BaseGame {
    /** Правило игры. */
    private static final String RULE =
        "What number is missing in the progression?";
    /** Длина прогрессии. */
    private static final int PROGRESSION_LENGTH = 10;
    /** Минимальное значение первого элемента. */
    private static final int FIRST_ELEMENT_MIN = 1;
    /** Максимальное значение первого элемента. */
    private static final int FIRST_ELEMENT_MAX = 10;
    /** Минимальное значение шага прогрессии. */
    private static final int STEP_MIN = 2;
    /** Максимальное значение шага прогрессии. */
    private static final int STEP_MAX = 5;

    /**
     * Генерирует арифметическую прогрессию.
     *
     * @param firstElement первый элемент прогрессии
     * @param step шаг прогрессии
     * @return массив элементов прогрессии
     */
    private int[] generateProgression(final int firstElement,
                                      final int step) {
        final int[] progression = new int[PROGRESSION_LENGTH];

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            progression[i] = firstElement + step * i;
        }
        return progression;
    }

    /**
     * Форматирует прогрессию со скрытым элементом.
     *
     * @param progression массив прогрессии
     * @param hiddenIndex индекс скрытого элемента
     * @return строковое представление прогрессии
     */
    private String formatProgression(final int[] progression,
                                     final int hiddenIndex) {
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                builder.append("..");
            } else {
                builder.append(progression[i]);
            }

            if (i < progression.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    /**
     * Генерирует пару вопрос-ответ для одного раунда.
     *
     * @return массив [вопрос, правильный ответ]
     */
    private String[] generateQuestionAnswerPair() {
        final int firstElement = generateRandomNumber(
            FIRST_ELEMENT_MIN, FIRST_ELEMENT_MAX
        );

        final int step = generateRandomNumber(STEP_MIN, STEP_MAX);
        final int[] progression = generateProgression(firstElement, step);

        final int hiddenIndex = RANDOM.nextInt(PROGRESSION_LENGTH);
        final String question = formatProgression(progression, hiddenIndex);

        final int correctAnswer = progression[hiddenIndex];

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
