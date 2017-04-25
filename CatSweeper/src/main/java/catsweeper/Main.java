package catsweeper;

import catsweeper.gui.UserInterface;
import catsweeper.logiikka.MineField;
import catsweeper.logiikka.MineSweeperGame;
import javax.swing.SwingUtilities;

public class Main {
/**
 * Luokka on Main.
 * 
     * @param args on args.
 */    
    public static void main(String[] args) {
        MineSweeperGame game = new MineSweeperGame();
        game.start();
    }
    
    
}
