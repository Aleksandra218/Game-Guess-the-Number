package game;

import utils.InputValidation;

public class Menu {
    private int level;
    private int maxNumber;
    private int attemptsLimit;

    public void run() {
        boolean exitGame = false; //Выход из игры
        while (!exitGame) { //пока не выход false = true
            selectLevel();
            Game game = new Game();
            game.start(maxNumber, attemptsLimit);
            exitGame = InputValidation.askForReplay(exitGame, game.bestResult);
        }
    }

    public static void resultChoiceLevel(int level, int maxNumber, int attemptsLimit) {
        System.out.println("Выбран уровень: " +
                (level == 1 ? "Лёгкий" : level == 2 ? "Средний" : level == 3 ? "Сложный" : "Эксперт") +
                ". Угадай число от 1 до " + maxNumber + ". Попыток: " + attemptsLimit);
    }

    public void selectLevel() {
        suggestToTheUser();
        //переменные куда я буду считывать и сохранять значение

        level = InputValidation.validLevelSelection();
        // Настраиваем параметры игры на основе выбора
        if (level == 1) {
            maxNumber = GameSettings.EASY_MAX;
            attemptsLimit = GameSettings.EASY_ATTEMPTS;
        } else if (level == 2) {
            maxNumber = GameSettings.AVERAGE_MAX;
            attemptsLimit = GameSettings.AVERAGE_ATTEMPTS;
        } else if (level == 3) {
            maxNumber = GameSettings.DIFFICULT_MAX;
            attemptsLimit = GameSettings.DIFFICULT_ATTEMPTS;
        } else {
            maxNumber = GameSettings.EXPERT_MAX;
            attemptsLimit = GameSettings.EXPERT_ATTEMPTS;
        }
        resultChoiceLevel(level, maxNumber, attemptsLimit);
    }


    public static void suggestToTheUser() {
        System.out.println("Добро пожаловать в игру \"Угадай число!\" \n");
        System.out.println("Выбери уровень сложности:  \n" +
                "1 — Лёгкий (1–50, 12 попыток)  \n" +
                "2 — Средний (1–100, 10 попыток)  \n" +
                "3 — Сложный (1–200, 8 попыток) \n" +
                "4 - Эксперт (1-500, 6 попытки)");
    }
}