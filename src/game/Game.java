package game;

import utils.InputValidation;

import java.util.Arrays;

public class Game {
    //private static final int HINT_RANGE = 10;// Диапазон подсказки


    public void start(int maxNumber, int attemptsLimit) {
        boolean exitGame = false; //Выход из игры

        while (!exitGame) { //пока не выход false = true

            int secretNumber = guessANumber(maxNumber); //загадываем числj
            int num = 0;

            boolean isGuessed = false; // Флаг для отслеживания угадывания
            int[] attempts = new int[attemptsLimit]; //создаем массив попыток размером на количество попыток

            for (int i = 1; i <= attemptsLimit; i++) {

                num = InputValidation.getValidNumber(maxNumber);

                attempts[i - 1] = num;
                System.out.println("Ваши попытки: " + Arrays.toString(Arrays.copyOf(attempts, i)));

                if (num > secretNumber) {
                    System.out.println("Меньше!");
                } else if (num < secretNumber) {
                    System.out.println("Больше!");
                } else if (num == secretNumber) {
                    isGuessed = true;
                    System.out.println("Поздравляю! Вы угадали число " + num + " за " + i + " попыток!");
                    break;
                }
            }
            if (!isGuessed) {
                System.out.println("К сожалению, вы не угадали число. Загаданное число было: " + secretNumber);
                System.out.println("Ваши попытки: " + Arrays.toString(attempts));

                System.out.println("Спасибо за игру! Ваш рекорд: ");


            }
            System.out.println("Хочешь сыграть ещё? (да/нет)");

            exitGame = InputValidation.askForReplay(exitGame);
        }
    }

    public static int guessANumber(int maxNumber) {
        return (int) (Math.random() * maxNumber) + 1;
    }
}