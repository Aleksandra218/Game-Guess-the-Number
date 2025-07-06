import java.util.Scanner;

public class Menu {
    private InputValidation inputValidation;
    private int level;
    private int maxNumber;
    private int attemptsLimit;

    public Menu(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }
    public void run() {
        selectLevel();
    }
    public void choiceLevel() {
        System.out.println("Выбран уровень: " +
                (level == 1 ? "Лёгкий" : level == 2 ? "Средний" : level == 3 ? "Сложный" : "Эксперт") +
                ". Угадай число от 1 до " + maxNumber + ". Попыток: " + attemptsLimit);
    }
    public int[] selectLevel() {
        //подсказка для пользователя
        suggestToTheUser();
        //переменные куда я буду считывать и сохранять значение
        int level; //выбранный уровень
        int maxNumber; // Верхняя граница числа (50, 100 или 200)
        int attemptsLimit; // Лимит попыток (10, 7, 6 или 4 )

        level = InputValidation.validLevelSelection();
        // Настраиваем параметры игры на основе выбора
        if (level == 1) {
            maxNumber = 50;
            attemptsLimit = 12;
        } else if (level == 2) {
            maxNumber = 100;
            attemptsLimit = 10;
        } else if (level == 3) {
            maxNumber = 200;
            attemptsLimit = 8;
        } else {
            maxNumber = 500;
            attemptsLimit = 6;
        }
        choiceLevel();

        return new int[]{level, maxNumber, attemptsLimit};
    }

    public static void suggestToTheUser() {
        System.out.println("Добро пожаловать в игру \"Угадай число!\"");
        System.out.println("Выбери уровень сложности:  \n" +
                "1 — Лёгкий (1–50, 12 попыток)  \n" +
                "2 — Средний (1–100, 10 попыток)  \n" +
                "3 — Сложный (1–200, 8 попыток) \n" +
                "4 - Эксперт (1-500, 6 попытки)");
    }
}
