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
    public static void main(final String[] args) {
        Cli.greet();
    }
}
