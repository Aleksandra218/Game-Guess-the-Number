package service;

import domain.GameSettings;
import factory.LevelSelector;
import presentation.Menu;
import util.InputValidation;

public class Game {
    private final Menu menu;
    private final LevelSelector levelSelector;
    private InputValidation inputValidation;
    private ScoreCalculator scoreCalculator;

    public Game(Menu menu, LevelSelector levelSelector, InputValidation inputValidation, ScoreCalculator scoreCalculator) {
        this.menu = menu;
        this.levelSelector = levelSelector;
        this.inputValidation = inputValidation;
        this.scoreCalculator = scoreCalculator;
    }

    public void start() {
        boolean exitGame = false; //Выход из игры

        while (!exitGame) { //пока не выход false = true
            menu.suggestToTheUser(); // выбор уровня (вывод)
            GameSettings gameSettings = levelSelector.selectLevel(); //настраиваем игру и создаем объект с этими настройками до конца игры
            menu.choiceLevel(gameSettings); //вывод сообщения о выборе уровня

            int secretNumber = NumberGenerator.guessANumber(gameSettings.getMaxNumber()); // случайное число для игры (зависит от уровня)
            menu.messageRecord(scoreCalculator.getBestResult());
            int num; // число от пользователя

            boolean isGuessed = false; // Флаг для отслеживания угадывания
            int[] attempts = new int[gameSettings.getAttemptsLimit()]; //массив попыток
            for (int i = 1; i <= gameSettings.getAttemptsLimit(); i++) {
                String hint = HintProvider.provideHint(gameSettings.getMaxNumber(), gameSettings.getAttemptsLimit(), secretNumber, i);
                if (hint != null) {
                    menu.showHint(hint);
                }
                num = inputValidation.getValidNumber(gameSettings.getMaxNumber());

                attempts[i - 1] = num;

                menu.attemptsMessage(attempts, i); //вывод текущих попыток

                if (num > secretNumber) {
                    System.out.println("Меньше!");
                } else if (num < secretNumber) {
                    System.out.println("Больше!");
                } else if (num == secretNumber) {
                    isGuessed = true;

                    int remainingAttempts = (gameSettings.getAttemptsLimit() - i);

                    int scoring = scoreCalculator.scoring(gameSettings.getLevel(), remainingAttempts, gameSettings.getAttemptsLimit());

                    menu.successMessageGame(num, i, scoring);
                    break;

                }
            }
            if (!isGuessed) {
                menu.messageGameOver(secretNumber, attempts); //сообщение при проигрыше
                if (scoreCalculator.getBestResult() > 0) {
                    System.out.println("Спасибо за игру! Ваш рекорд: " + scoreCalculator.getBestResult());
                }

            }

            System.out.println("Хочешь сыграть ещё? (да/нет)");

            exitGame = inputValidation.askForReplay(scoreCalculator.getBestResult());
        }
    }
}

