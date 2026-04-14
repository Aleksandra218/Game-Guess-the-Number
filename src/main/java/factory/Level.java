package factory;

public enum Level {
    EASY(1, 50, 12, "Лёгкий"),
    MEDIUM(2, 100, 10, "Средний"),
    HARD(3, 200, 8, "Сложный"),
    EXTREME(4, 500, 6, "Эксперт");

    private final int levelNumber;
    private final int maxNumber;
    private final int attemptsLimit;
    private final String displayName;

    Level(int levelNumber, int maxNumber, int attemptsLimit, String displayName) {
        this.levelNumber = levelNumber;
        this.maxNumber = maxNumber;
        this.attemptsLimit = attemptsLimit;
        this.displayName = displayName;
    }
    public int getLevelNumber() {
        return levelNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getAttemptsLimit() {
        return attemptsLimit;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Level findByNumber(int number) {
        for (Level level : values()) {
            if (level.getLevelNumber() == number) {
                return level;
            }
        }
        return null;
    }
}
