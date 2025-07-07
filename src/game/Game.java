package game;

import utils.InputValidation;

import java.util.Arrays;

public class Game {
    private static final int HINT_RANGE = 10;// Диапазон подсказки
    public int bestResult = 0;
    public int scoring = 0;


    public void start(int maxNumber, int attemptsLimit) {


        int secretNumber = guessANumber(maxNumber); //загадываем числj
        System.out.println("Текущий рекорд: " + (bestResult > 0 ? bestResult : "ещё нет"));

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

            System.out.println("Спасибо за игру! Ваш рекорд: ");


        }
        System.out.println("Хочешь сыграть ещё? (да/нет)");
    }

    public static int guessANumber(int maxNumber) {
        return (int) (Math.random() * maxNumber) + 1;
    }
}