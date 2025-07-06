package game;

import java.util.Scanner;

public class InputValidation {
    private static Scanner scanner;

    public InputValidation(Scanner scanner) {
        this.scanner = scanner;

    }
    public static boolean askForReplay(boolean exitGame) {
        String str;
        while (true) {
            if (!scanner.hasNextLine()) {
                System.out.println("Ошибка: введите пожалуйста текст (да/нет)");
            }
            str = scanner.nextLine();
            if (str.isEmpty()) continue;
            if (str.equalsIgnoreCase("нет")) {
                exitGame = true;
                System.out.println("Спасибо за игру! Игра завершена. Ваш рекорд: ");
                break;
            } else if (str.equalsIgnoreCase("да")) {
                break;
            } else {
                System.out.println("Пожалуйста, введите 'да' или 'нет'.");
            }
        }
        return exitGame;
    }
    public static int getValidNumber(int maxNumber) {
        System.out.println("Введите целое положительное число от 1 до " + maxNumber);
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: вы ввели текст или дробное число. Пожалуйста, введите целое положительное число.");
                scanner.next();
                continue;
            }
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num < 0 || num > maxNumber) {
                System.out.println("Ошибка: введите число от 1 до " + maxNumber);
                continue;
            }
            return num;
        }
    }

    public static int validLevelSelection() {
        // Считываем выбор уровня
        int level;
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите число от 1 до 4.");
                scanner.next();
                continue;
            }
            level = scanner.nextInt();
            if (level < 1 || level > 4) {
                System.out.println("Ошибка: выберите 1, 2, 3 или 4");
                continue;
            }
            break;
        }
        return level;
    }
}
