package presentation;

import domain.GameSettings;
import java.awt.*;
import java.util.Arrays;

public class Menu {

    public void showHint(String hintText) {
        System.out.println("💡 Подсказка: " + hintText);
    }

    public void messageRecord(int bestResult) {
        System.out.println("Текущий рекорд: " + (bestResult > 0 ? bestResult : "ещё нет"));
    }

    public void messageGameOver(int secretNumber, int[] attempts) {
        System.out.println("К сожалению, вы не угадали число. Загаданное число было: " + secretNumber);
        System.out.println("Ваши попытки: " + Arrays.toString(attempts));

    }

    public void successMessageGame(int num, int i, int scoring) {
        System.out.println("Поздравляю! Вы угадали число " + num + " за " + i + " попыток!");
        System.out.println("Количество очков: " + scoring);
    }

    public void attemptsMessage(int[] attempts, int i) {
        System.out.println("Ваши попытки: " + Arrays.toString(Arrays.copyOf(attempts, i)));
    }

    public void choiceLevel(GameSettings gameSettings) {
        System.out.println("Выбран уровень: " +
                (gameSettings.getLevel() == 1 ? "Лёгкий" : gameSettings.getLevel() == 2 ?
                        "Средний" : gameSettings.getLevel() == 3 ? "Сложный" : "Эксперт") +
                ". Угадай число от 1 до " + gameSettings.getMaxNumber() + ". Попыток: " + gameSettings.getAttemptsLimit());
    }


    public void suggestToTheUser() {
        System.out.println("Добро пожаловать в игру \"Угадай число!\"");
        System.out.println("Выбери уровень сложности:  \n" +
                "1 — Лёгкий (1–50, 12 попыток)  \n" +
                "2 — Средний (1–100, 10 попыток)  \n" +
                "3 — Сложный (1–200, 8 попыток) \n" +
                "4 - Эксперт (1-500, 6 попытки)");
    }
}
