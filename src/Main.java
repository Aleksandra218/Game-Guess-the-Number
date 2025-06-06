
import java.util.Scanner;
import java.util.Arrays;
//Проект: "Угадай число" (с расширенными возможностями)
public class Main {
    static final int HINT_RANGE = 10; // Диапазон подсказки
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exitGame = false; //Выход из игры
        int bestResult = 0;
        int scoring = 0;

        while (!exitGame) { //пока не выход false = true
            int [] settings = selectLevel(sc);
            int maxNumber = settings[1]; // Теперь переменная доступна
            int attemptsLimit = settings[2];

            int secretNumber = guessANumber(maxNumber);
            System.out.println("Текущий рекорд: " + (bestResult > 0 ? bestResult : "ещё нет"));
            int num = 0;

            boolean isGuessed = false; // Флаг для отслеживания угадывания
            int[] attempts = new int[attemptsLimit];

            for (int i = 1; i <= attemptsLimit; i++) {
                provideHint(maxNumber, attemptsLimit, secretNumber, i);

                num = getValidNumber(sc, maxNumber);

                attempts[i - 1] = num;
                System.out.println("Ваши попытки: " + Arrays.toString(Arrays.copyOf(attempts, i)));

                if (num > secretNumber) {
                    System.out.println("Меньше!");
                } else if (num < secretNumber) {
                    System.out.println("Больше!");
                } else if (num == secretNumber) {
                    isGuessed = true;
                    scoring = 1000 * (12 - i) / 10;
                    if (scoring > bestResult) {
                        bestResult = scoring;
                    }
                    System.out.println("Поздравляю! Вы угадали число " + num + " за " + i + " попыток!");
                    System.out.println("Количество очков: " + scoring);
                    break;
                }
            }
            if (!isGuessed) {
                System.out.println("К сожалению, вы не угадали число. Загаданное число было: " + secretNumber);
                System.out.println("Ваши попытки: " + Arrays.toString(attempts));
                if (bestResult > 0) {
                    System.out.println("Спасибо за игру! Ваш рекорд: " + bestResult);
                }

            }
            System.out.println("Хочешь сыграть ещё? (да/нет)");

            exitGame = askForReplay(sc, exitGame, bestResult);
        }
    }

    private static boolean askForReplay(Scanner sc, boolean exitGame, int bestResult) {
        String str;
        while (true) {
            if (!sc.hasNextLine()) {
                System.out.println("Ошибка: введите пожалуйста текст (да/нет)");
            }
            str = sc.nextLine();
            if (str.isEmpty()) continue;
            if (str.equalsIgnoreCase("нет")) {
                exitGame = true;
                System.out.println("Спасибо за игру! Игра завершена. Ваш рекорд: " + bestResult);
                break;
            } else if (str.equalsIgnoreCase("да")) {
                break;
            } else {
                System.out.println("Пожалуйста, введите 'да' или 'нет'.");
            }
        }
        return exitGame;
    }

    private static void provideHint(int maxNumber, int attemptsLimit, int secretNumber, int i) {
        if (i == attemptsLimit / 3) {
            System.out.println("Подсказка: число " + (secretNumber % 2 == 0 ? "четное" : "нечетное"));
        } else if (i == attemptsLimit * 2 / 3) {
            int range = HINT_RANGE * maxNumber / 100;
            int lowerBound = Math.max(1, secretNumber - range);
            int upperBound = Math.min(maxNumber, secretNumber + range);
            System.out.println("Подсказка: число между " + lowerBound + " и " + upperBound);
        }
    }

    public static int[] selectLevel(Scanner sc) {
        //подсказка для пользователя
        suggestToTheUser();
        //переменные куда я буду считывать и сохранять значение
        int level; //выбранный уровень
        int maxNumber; // Верхняя граница числа (50, 100 или 200)
        int attemptsLimit; // Лимит попыток (10, 7, 6 или 4 )
        
        level = validLevelSelection(sc);
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
        itogChoiceLevel(level, maxNumber, attemptsLimit);

        return new int[]{level, maxNumber, attemptsLimit};
    }

    private static void itogChoiceLevel(int level, int maxNumber, int attemptsLimit) {
        System.out.println("Выбран уровень: " +
                (level == 1 ? "Лёгкий" : level == 2 ? "Средний" : level == 3 ? "Сложный" : "Эксперт") +
                ". Угадай число от 1 до " + maxNumber + ". Попыток: " + attemptsLimit);
    }

    private static void suggestToTheUser() {
        System.out.println("Добро пожаловать в игру \"Угадай число!\"");
        System.out.println("Выбери уровень сложности:  \n" +
                "1 — Лёгкий (1–50, 12 попыток)  \n" +
                "2 — Средний (1–100, 10 попыток)  \n" +
                "3 — Сложный (1–200, 8 попыток) \n" +
                "4 - Эксперт (1-500, 6 попытки)");
    }

    private static int validLevelSelection(Scanner sc) {
        // Считываем выбор уровня
        int level;
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.println("Ошибка: введите число от 1 до 4.");
                sc.next();
                continue;
            }
            level = sc.nextInt();
            if (level < 1 || level > 4) {
                System.out.println("Ошибка: выберите 1, 2, 3 или 4");
                continue;
            }
            break;
        }
        return level;
    }

    public static int guessANumber(int maxNumber) {
        return (int) (Math.random() * maxNumber) + 1;

    }
    public static int getValidNumber(Scanner sc, int maxNumber) {
        System.out.println("Введите целое положительное число от 1 до " + maxNumber);
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.println("Ошибка: вы ввели текст или дробное число. Пожалуйста, введите целое положительное число.");
                sc.next();
                continue;
            }
            int num = sc.nextInt();
            sc.nextLine();
            if (num < 0 ||num > maxNumber) {
                System.out.println("Ошибка: введите число от 1 до " + maxNumber);
                continue;
            }
            return num;
        }
    }
}