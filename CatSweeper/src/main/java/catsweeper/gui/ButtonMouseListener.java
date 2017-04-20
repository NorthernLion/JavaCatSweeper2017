package catsweeper.gui;

import catsweeper.logiikka.MineField;
import catsweeper.logiikka.MineSweeperGame;
import catsweeper.logiikka.Tile;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ButtonMouseListener implements MouseListener {

    private int y;
    private int x;
    private JButton[][] squares;
    private MineField field;
    private MineSweeperGame game;
    private JButton button;
    private Tile[][] board;

    ButtonMouseListener(int y, int x, JButton[][] squares, MineSweeperGame game) {
        this.y = y;
        this.x = x;
        this.squares = squares;
        this.game = game;
        this.button = squares[y][x];
        this.field = game.getField();
        this.board = field.getBoard();
    }

    public void handleButton(int y, int x) {
        Tile current = board[y][x];
        List<Tile> surroundingSquares = field.getSuroundingTiles(current);
        JButton button = squares[y][x];
        if (!current.isRevealed()) {
            if (current.isBomb()) {
                button.setText("c");
                current.reveal();
                JOptionPane.showMessageDialog(null, "Hävisit! Aloita alusta", "Info", JOptionPane.INFORMATION_MESSAGE);
                game.start();
            } else {
                if (current.getValue() == 0) {
                    button.setText("");
                } else {
                    button.setText(Integer.toString(current.getValue()));
                }
                current.reveal();
                for (Tile surroundingSquare : surroundingSquares) {
                    if (current.getValue() == 0 && surroundingSquare.getValue() >= 0 && !surroundingSquare.isFlagged() && !surroundingSquare.isBomb()) {
                        handleButton(surroundingSquare.getX(), surroundingSquare.getY());
                    }
                }
            }
            button.setEnabled(false);
            if (field.checkWinner()) {
                JOptionPane.showMessageDialog(null, "Voitit! Jee! Aloita alusta", "Info", JOptionPane.INFORMATION_MESSAGE);
                game.start();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (SwingUtilities.isLeftMouseButton(me)) {
            handleButton(y, x);
        } else if (SwingUtilities.isRightMouseButton(me)) {
            Tile current = board[y][x];
            if (!current.isRevealed()) {
                if (current.isFlagged()) {
                    button.setText("");
                    current.unflag();
                } else {
                    button.setText("F");
                    current.flag();
                }
            }

        }
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
