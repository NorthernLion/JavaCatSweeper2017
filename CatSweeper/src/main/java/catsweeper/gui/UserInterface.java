/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catsweeper.gui;

import catsweeper.logiikka.MineField;
import catsweeper.logiikka.MineSweeperGame;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Pesonen
 */
public class UserInterface implements Runnable {

    private boolean gameActive;
    private ButtonMouseListener listener;
    private int size;
    private JFrame frame;
    private MineSweeperGame game;
    private MineField field;

    public UserInterface(MineSweeperGame game) {
        this.size = game.getSize();
        this.game = game;
        this.field = game.getField();
    }

    @Override
    public void run() {
        frame = new JFrame("CatSweeper");
        System.out.println("huhuhu");
    }

    private JPanel createButtons(JPanel panel) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("hi");
     /**
 *
 * buttoneiden luonti!
 */          
            }
        }
        return panel;
    }

}
