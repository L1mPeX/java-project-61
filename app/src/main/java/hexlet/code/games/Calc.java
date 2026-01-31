package hexlet.code.games;

import java.util.Scanner;

/**
 * @author L1mPeX
 */
public class Calc extends Games {
    public Calc(Scanner sc) {
        super(sc);
    }

    /**
     * Метод, который содержит логику игры
     */
    @SuppressWarnings("java:S106")
    @Override
    public void playGame() {
        Cli greetUser = new Cli(sc);
        greetUser.greet();
    }
}
