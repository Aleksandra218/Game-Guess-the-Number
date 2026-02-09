package service;

public class ScoreCalculator {
    private int bestResult = 0;
    private int scoring = 0;

    public int getBestResult() {
        return bestResult;
    }

    public int scoring(int numberLevel, int remainingAttempts, int maxAttempts) {
        scoring = (int) ((numberLevel * 250) * (1 + (double) remainingAttempts / maxAttempts));
        if (scoring > bestResult) {
            bestResult = scoring;
        }
        return scoring;
    }
}