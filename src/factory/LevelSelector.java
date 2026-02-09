package factory;

import domain.GameSettings;
import util.InputValidation;


public class LevelSelector {
    private final InputValidation inputValidation;

    public LevelSelector(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public GameSettings selectLevel() {
        int level;
        int maxNumber;
        int attemptsLimit;

        level = inputValidation.validLevelSelection(); // Настраиваем параметры игры на основе выбора
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
        return new GameSettings(level, maxNumber, attemptsLimit);
    }
}
