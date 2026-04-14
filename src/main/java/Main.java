
//Проект: "Угадай число" (с расширенными возможностями)

import factory.LevelSelector;
import presentation.Menu;
import presentation.UserInterface;
import service.Game;
import service.ScoreCalculator;
import service.InputValidation;


public class Main {
    public static void main(String[] args) {

        UserInterface ui = new Menu();
        InputValidation inputValidation = new InputValidation(ui);
        LevelSelector levelSelector = new LevelSelector(inputValidation);
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        Game game = new Game(ui, levelSelector, inputValidation, scoreCalculator);
        game.start();
    }
}