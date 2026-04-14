package service;

import domain.GameSettings;
import factory.Level;
import factory.LevelSelector;
import presentation.Message;
import presentation.UserInterface;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Game {
    private final UserInterface ui;
    private final LevelSelector levelSelector;
    private InputValidation inputValidation;
    private ScoreCalculator scoreCalculator;

    public Game(UserInterface ui, LevelSelector levelSelector, InputValidation inputValidation, ScoreCalculator scoreCalculator) {
        this.ui = ui;
        this.levelSelector = levelSelector;
        this.inputValidation = inputValidation;
        this.scoreCalculator = scoreCalculator;
    }

    public void start() {
        boolean exitGame = false; //Выход из игры

        while (!exitGame) { //пока не выход false = true
            ui.showMessage(Message.INFO_START_GAME_MESSAGE);
            ui.showMessage(Message.INFO_ASK_LEVEL);
            GameSettings gameSettings = levelSelector.selectLevel(); //настраиваем игру и создаем объект с этими настройками до конца игры

            Level selectedLevel = Level.findByNumber(gameSettings.getLevel());
            String levelName = selectedLevel.getDisplayName();
            ui.showMessage(Message.INFO_SELECTED_LEVEL, levelName, gameSettings.getMaxNumber(), gameSettings.getAttemptsLimit());

            int secretNumber = NumberGenerator.guessANumber(gameSettings.getMaxNumber()); // случайное число для игры (зависит от уровня)
            ui.showMessage(Message.INFO_CURRENT_RECORD, scoreCalculator.getBestResult());
            int num; // число от пользователя

            boolean isGuessed = false; // Флаг для отслеживания угадывания
            int[] attempts = new int[gameSettings.getAttemptsLimit()]; //массив попыток
            for (int i = 1; i <= gameSettings.getAttemptsLimit(); i++) {
                String hint = HintProvider.provideHint(gameSettings.getMaxNumber(), gameSettings.getAttemptsLimit(), secretNumber, i);
                if (hint != null) {
                    ui.showMessage(Message.HINT_PROVIDE, hint);
                }
                num = inputValidation.getValidNumber(gameSettings.getMaxNumber());

                attempts[i - 1] = num;

                int[] currentAttempts = Arrays.copyOf(attempts, i);
                ui.showMessage(Message.INFO_ATTEMPTS_HISTORY, Arrays.toString(currentAttempts)); //вывод текущих попыток

                if (num > secretNumber) {
                    ui.showMessage(Message.HINT_LESS);
                } else if (num < secretNumber) {
                    ui.showMessage(Message.HINT_MORE);
                } else if (num == secretNumber) {
                    isGuessed = true;

                    int remainingAttempts = (gameSettings.getAttemptsLimit() - i);

                    int scoring = scoreCalculator.scoring(gameSettings.getLevel(), remainingAttempts, gameSettings.getAttemptsLimit());

                    //ui.showWinMessage(num, i, scoring);
                    ui.showMessage(Message.WIN_MESSAGE, num, i);
                    ui.showMessage(Message.INFO_SCORE_END_GAME, scoring);
                    break;

                }
            }
            if (!isGuessed) {
                //ui.showGameOverMessage(secretNumber, attempts);// сообщение при проигрыше
                ui.showMessage(Message.LOSE_GAME_OVER, secretNumber);
                ui.showMessage(Message.INFO_ATTEMPTS_HISTORY, Arrays.toString(attempts));
                if (scoreCalculator.getBestResult() > 0) {
                    //ui.showBestScore(scoreCalculator.getBestResult());
                    ui.showMessage(Message.LOSE_END_GAME_SCORE, scoreCalculator.getBestResult());

                }
            }

            //ui.askReplay();
            ui.showMessage(Message.INFO_ASK_REPLAY);

            exitGame = inputValidation.askForReplay(scoreCalculator.getBestResult());
        }
    }
}

