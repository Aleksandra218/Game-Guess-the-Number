package service;

import presentation.Message;
import presentation.UserInterface;

import java.util.Scanner;

public class InputValidation {
    private final Scanner SCANNER = new Scanner(System.in);
    private final UserInterface ui;

    public InputValidation(UserInterface ui) {
        this.ui = ui;
    }

    public boolean askForReplay(int bestResult) {
        boolean exitGame2 = false;
        String str;
        while (true) {
            str = SCANNER.nextLine();
            if (str.isEmpty()) continue;
            if (str.equalsIgnoreCase("нет")) {
                exitGame2 = true;
                ui.showMessage(Message.LOSE_END_GAME_RECORD, bestResult);
                break;
            } else if (str.equalsIgnoreCase("да")) {
                break;
            } else {
                ui.showMessage(Message.ERROR_TEXT_REPLAY);
            }
        }
        return exitGame2;
    }
    public int getValidNumber(int maxNumber) {
        ui.showMessage(Message.INFO_NUMBER_MAX_NUMBER, maxNumber);
        while (true) {
            if (!SCANNER.hasNextInt()) {
                ui.showMessage(Message.ERROR_NOT_NUMBER);
                SCANNER.next();
                continue;
            }
            int num = SCANNER.nextInt();
            SCANNER.nextLine();
            if (num < 0 || num > maxNumber) { //за пределами
                ui.showMessage(Message.ERROR_NUMBER_OUT_OF_BOUNDS, maxNumber);
                continue;
            }
            return num;
        }
    }

    public int validLevelSelection() {
        while (true) {
            if (!SCANNER.hasNextInt()) {
                ui.showMessage(Message.ERROR_NOT_NUMBER);
                SCANNER.next();
                continue;
            }
            int level = SCANNER.nextInt();
            SCANNER.nextLine();

            if (level < 1 || level > 4) { //за пределами
                ui.showMessage(Message.ERROR_OUT_OF_BOUNDS_LEVEL);
                continue;
            }
            return level;
        }
    }
}
