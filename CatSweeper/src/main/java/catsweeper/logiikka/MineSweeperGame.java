package catsweeper.logiikka;

import catsweeper.gui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MineSweeperGame {

    private int leveys;
    private int korkeus;
    private boolean running;
    private int timer;

    public MineSweeperGame(int leveys, int korkeus) {
        this.running = false;
        this.timer = 0;
    }

    public void gameLoop() {
        while (running) {
            System.out.println("Olen paras");
        }
    }

}
