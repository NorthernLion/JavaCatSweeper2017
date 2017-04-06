package catsweeper.logiikka;

import catsweeper.gui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
/**
 * Luokka on ilmentymä miinaharavasta, joka huolehtii pelin aloittamisesta ja resetoinnista.
 */
public class MineSweeperGame {

    private boolean running;
    private int timer;
    private MineField field;
    private int size;

    public MineSweeperGame() {
        this.size = 10;
        //this.running = false;
        this.timer = 0;
        this.field = new MineField(size);
    }
 /**
 * Metodi alustaa pelilaudan arvot.
 */
    
    public void start() {        
        field.initialize();
    }
//
//    public void gameLoop() {
//        while (running) {
//            System.out.println("Olen paras");
//        }
//    }

    public MineField getField() {
        return field;
    }

    public int getSize() {
        return size;
    }

}
