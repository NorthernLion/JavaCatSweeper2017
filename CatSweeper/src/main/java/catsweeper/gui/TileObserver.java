package catsweeper.gui;

import catsweeper.logiikka.Tile;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;

public class TileObserver extends JButton implements Observer {

    private Tile tile;

    public TileObserver(Tile tile) {
        super();
        this.tile = tile;
        super.setBackground(Color.gray);
        setOpaque(true);
    }

    @Override
    public void update(Observable o, Object o1) {

        this.setText(Integer.toString(tile.getValue()));
    }

}
