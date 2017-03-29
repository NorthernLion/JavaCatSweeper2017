package catsweeper;

import catsweeper.gui.UserInterface;
import catsweeper.logiikka.MineField;
import catsweeper.logiikka.MineSweeperGame;

public class Main {
    
    public static void main(String[] args) {
        MineSweeperGame game = new MineSweeperGame();
        UserInterface inteface = new UserInterface(game);
        
    }
    
    
}
