package hexlet.code;

/**
 * Основной класс приложения Brain Games.
 *
 * @author l1mpex
 */
public final class App {
    private App() {
    }

    /**
     * Запускает интерактивное консольное приложение.
     *
     * @param args аргументы командной строки
     */
    @SuppressWarnings("java:S106")
    public static void main(final String[] args) {
        Engine engine = new Engine();
        engine.pickGame();
    }
}
