package factory;

import domain.GameSettings;
import service.InputValidation;


public class LevelSelector {
    private final InputValidation inputValidation;

    public LevelSelector(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public GameSettings selectLevel() {
        int levelNumber;

        levelNumber = inputValidation.validLevelSelection(); // Настраиваем параметры игры на основе выбора

        Level selected = Level.findByNumber(levelNumber);
        return new GameSettings(
                selected.getLevelNumber(),
                selected.getMaxNumber(),
                selected.getAttemptsLimit()
        );
    }
}
