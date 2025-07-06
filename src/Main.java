
//Проект: "Угадай число" (с расширенными возможностями)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputValidation validation = new InputValidation(scanner);

        Menu menu = new Menu(validation);
        menu.run();
    }
}