package service;

import presentation.Menu;

public class HintProvider {
    static final int HINT_RANGE = 10;// Диапазон подсказки


    public static String provideHint( int maxNumber, int attemptsLimit, int secretNumber, int i) {
        if (i == attemptsLimit / 3) {
            return "число " + (secretNumber % 2 == 0 ? "четное" : "нечетное");
        } else if (i == attemptsLimit * 2 / 3) {
            int range = HINT_RANGE * maxNumber / 100;
            int lowerBound = Math.max(1, secretNumber - range);
            int upperBound = Math.min(maxNumber, secretNumber + range);
            return "число между " + lowerBound + " и " + upperBound;
        }
        return null;
    }
}
