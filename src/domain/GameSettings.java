package domain;

public class GameSettings {
    private int level;
    private int maxNumber;
    private int attemptsLimit;

    public GameSettings(int level, int maxNumber, int attemptsLimit) {
        this.level = level;
        this.maxNumber = maxNumber;
        this.attemptsLimit = attemptsLimit;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getAttemptsLimit() {
        return attemptsLimit;
    }
}
