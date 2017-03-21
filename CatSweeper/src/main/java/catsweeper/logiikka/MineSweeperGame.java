package catsweeper.logiikka;

import catsweeper.gui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class MineSweeperGame extends Timer implements ActionListener {
    
    private int leveys;
    private int korkeus;
    
    public MineSweeperGame(int leveys, int korkeus) {
        super(1000, null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //Game looppi?




    
    
    
}
