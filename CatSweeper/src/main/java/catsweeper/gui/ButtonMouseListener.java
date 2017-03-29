/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catsweeper.gui;

import catsweeper.logiikka.Tile;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Pesonen
 */
public class ButtonMouseListener implements MouseListener {

    private Tile tile;

    public ButtonMouseListener(Tile tile) {
        this.tile = tile;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (SwingUtilities.isLeftMouseButton(me)) {
            System.out.println("hi");
            //Reveal, pitää tehdä game tasolla?
        } else if (SwingUtilities.isRightMouseButton(me)) {
            System.out.println("hi");
            //flag tile tasolla?
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}

//Listeneri