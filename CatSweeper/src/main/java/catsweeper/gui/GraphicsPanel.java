package catsweeper.gui;

import catsweeper.logiikka.MineSweeperGame;
import java.*;
import javax.swing.JPanel;
import java.awt.Graphics;

public class GraphicsPanel extends JPanel {
    
    private MineSweeperGame game;
    private int size;

    public GraphicsPanel(MineSweeperGame game) {
        this.game = game;
    }
//Mitäköhän ihmetttä tänne...   
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);        
    }
    
    
    
    public void update() {
        repaint();
    }
    
}


