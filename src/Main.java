
//Проект: "Угадай число" (с расширенными возможностями)

import factory.LevelSelector;
import presentation.Menu;
import service.Game;
import service.ScoreCalculator;
import util.InputValidation;


public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        InputValidation inputValidation = new InputValidation();
        LevelSelector levelSelector = new LevelSelector(inputValidation);
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        Game game = new Game(menu, levelSelector, inputValidation, scoreCalculator);
        game.start();
    }
}