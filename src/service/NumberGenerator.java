package service;

public class NumberGenerator {

    public static int guessANumber(int maxNumber) {
        return (int) (Math.random() * maxNumber) + 1;

    }
}
