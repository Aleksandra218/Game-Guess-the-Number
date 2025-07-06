package game;

public class Menu {
    private int maxNumber = 100;
    private int attemptsLimit = 10;

    public void run() {
        suggestToTheUser();
        Game game = new Game();
        game.start(maxNumber, attemptsLimit);
    }


    public static void suggestToTheUser() {
        System.out.println("Добро пожаловать в игру \"Угадай число!\" \n" +
                "Загадано число от 1 до 100. У вас 10 попыток.");
//        System.out.println("Выбери уровень сложности:  \n" +
//                "1 — Лёгкий (1–50, 12 попыток)  \n" +

//                "2 — Средний (1–100, 10 попыток)  \n" +
//                "3 — Сложный (1–200, 8 попыток) \n" +
//                "4 - Эксперт (1-500, 6 попытки)");
    }
}