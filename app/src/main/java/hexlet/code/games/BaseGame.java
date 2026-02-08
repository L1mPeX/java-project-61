package hexlet.code.games;

import hexlet.code.Game;
import java.security.SecureRandom;

/**
 * Абстрактный базовый класс для всех игр.
 * Содержит общую логику и вспомогательные методы.
 */
public abstract class BaseGame implements Game {
    /** Генератор случайных чисел. */
    protected static final SecureRandom RANDOM = new SecureRandom();
    /** Количество раундов в игре. */
    protected static final int ROUNDS_COUNT = 3;
    /** Минимальное значение для генерации чисел. */
    protected static final int MIN_NUMBER = 1;
    /** Максимальное значение для генерации чисел. */
    protected static final int MAX_NUMBER = 100;

    /**
     * Генерирует случайное целое число в заданном диапазоне.
     *
     * @param min минимальное значение (включительно)
     * @param max максимальное значение (включительно)
     * @return случайное целое число
     */
    protected int generateRandomNumber(final int min, final int max) {
        if (min > max) {
            throw new IllegalArgumentException(
                "Минимальное значение не может быть больше максимального"
            );
        }

        return RANDOM.nextInt(max - min + 1) + min;
    }

    /**
     * Генерирует случайное целое число в стандартном диапазоне.
     *
     * @return случайное целое число от MIN_NUMBER до MAX_NUMBER
     */
    protected int generateRandomNumber() {
        return generateRandomNumber(MIN_NUMBER, MAX_NUMBER);
    }
}
