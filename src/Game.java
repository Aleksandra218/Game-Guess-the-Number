import java.util.Arrays;
import java.util.Scanner;

public class Game {
    static final int HINT_RANGE = 10; // Диапазон подсказки

    public void run() {
        boolean exitGame = false; //Выход из игры
        int bestResult = 0;
        int scoring = 0;

        while (!exitGame) { //пока не выход false = true
            int[] settings = Menu.;
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

    public static int guessANumber(int maxNumber) {
        return (int) (Math.random() * maxNumber) + 1;

    }
}

