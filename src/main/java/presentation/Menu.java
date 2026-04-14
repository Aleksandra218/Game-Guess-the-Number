package presentation;

public class Menu implements UserInterface {
    @Override
    public void showMessage(Message message, Object... args) {
        MessageType type = message.getType();
        String color = type.getColorCode();
        String icon = type.getIcon();
        String reset = "\u001B[0m";

        String text = String.format(message.getTemplate(), args);

        System.out.println(color + icon + " " + text + reset);
    }



//    public void showBestScore(int bestRecord) {                               //1
//        System.out.println("Спасибо за игру! Игра завершена. Ваш рекорд: " + bestRecord);
//    }

//    public void showCurrentRecord(int bestResult) {
//        System.out.println("Текущий рекорд: " + (bestResult > 0 ? bestResult : "ещё нет"));
//    }

//    public void showGameOverMessage(int secretNumber, int[] attempts) {
//        System.out.println("К сожалению, вы не угадали число. Загаданное число было: " + secretNumber);
//        System.out.println("Ваши попытки: " + Arrays.toString(attempts));
//        здесь нужно понять как вычисляются попытки и привести к одному сообщению
//    }

//    public void showWinMessage(int num, int i, int scoring) {
//        System.out.println("Поздравляю! Вы угадали число " + num + " за " + i + " попыток!");
//        System.out.println("Количество очков: " + scoring);
//    }

//    public void showAttemptsHistory(int[] attempts, int i) {
//        System.out.println("Ваши попытки: " + Arrays.toString(Arrays.copyOf(attempts, i)));
//    }



}






//   public void showEndGame(int bestResult) {
//       System.out.println("Спасибо за игру! Игра завершена. Ваш рекорд:" + bestResult);
//   }


