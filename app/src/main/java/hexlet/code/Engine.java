package hexlet.code;

import java.util.Scanner;

public class Engine {
    private String userName;

    /**
     * Конструктор класса
     */
    public Engine () {
        this.userName = askUserName();
    }

    /**
     * Метод, который запрашивает имя пользователя
     * 
     * @return String 
    */
    private String askUserName() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextLine();
        }
    }
}
