package catsweeper.gui;

import catsweeper.logiikka.MineSweeperGame;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Luokka on Interface, joka huolehtii projektin grafiikka puolesta. Se alustaa
 * pelin pää framen, sekä jokaisen ruudun omaksi buttonikseen.
 *
 */
public class UserInterface implements Runnable {

    private JFrame frame;
    private MineSweeperGame game;
    private JButton[][] squares;

    public UserInterface(MineSweeperGame game) {
        this.game = game;
        this.squares = new JButton[game.getSize()][game.getSize()];
    }

    @Override
    public void run() {
        this.frame = new JFrame("Catsweeper");
        frame.setPreferredSize(new Dimension((60 * game.getSize()), (60 * game.getSize())));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(game.getSize(), game.getSize()));

        for (int x = 0; x < game.getSize(); x++) {
            for (int y = 0; y < game.getSize(); y++) {
                JButton button = new JButton();
                squares[x][y] = button;
                button.addMouseListener(new ButtonMouseListener(x, y, squares, game));
                container.add(button);
            }
        }
    }
}
