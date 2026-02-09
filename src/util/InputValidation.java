package util;

import java.util.Scanner;

public class InputValidation {
    private static final Scanner SCANNER = new Scanner(System.in);

    public boolean askForReplay(int bestResult) {
        boolean exitGame2 = false;
        String str;
        while (true) {
            str = SCANNER.nextLine();
            if (str.isEmpty()) continue;
            if (str.equalsIgnoreCase("нет")) {
                exitGame2 = true;
                System.out.println("Спасибо за игру! Игра завершена. Ваш рекорд: " + bestResult);
                break;
            } else if (str.equalsIgnoreCase("да")) {
                break;
            } else {
                System.out.println("Пожалуйста, введите 'да' или 'нет'.");
            }
        }
        return exitGame2;
    }
    public int getValidNumber(int maxNumber) {
        System.out.println("Введите целое положительное число от 1 до " + maxNumber);
        while (true) {
            if (!SCANNER.hasNextInt()) {
                System.out.println("Ошибка: вы ввели текст или дробное число. Пожалуйста, введите целое положительное число.");
                SCANNER.next();
                continue;
            }
            int num = SCANNER.nextInt();
            SCANNER.nextLine();
            if (num < 0 || num > maxNumber) {
                System.out.println("Ошибка: введите число от 1 до " + maxNumber);
                continue;
            }
            return num;
        }
    }

    public int validLevelSelection() {
        // Считываем выбор уровня
        while (true) {
            if (!SCANNER.hasNextInt()) {
                System.out.println("Ошибка: введите число от 1 до 4.");
                SCANNER.next();
                continue;
            }
            int level = SCANNER.nextInt();
            SCANNER.nextLine();

            if (level < 1 || level > 4) {
                System.out.println("Ошибка: введите число от 1 до 4.");
                continue;
            }
            return level;
        }
    }
}
