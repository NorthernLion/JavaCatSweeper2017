package catsweeper.gui;

import catsweeper.logiikka.MineSweeperGame;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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
/**
 * Metodi on konstruktori.
     * @param game on peli.
 */
    public UserInterface(MineSweeperGame game) {
        this.game = game;
        this.squares = new JButton[game.getSize()][game.getSize()];
    }

    @Override
    public void run() {
        this.frame = new JFrame("Catsweeper");
        frame.setPreferredSize(new Dimension((60 * game.getSize()), (60 * game.getSize())));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
/**
 * Metodi luo jokaiselle Ruudulle oman nappulan ja lisää siihen ButtonMouseLitenerin.
 */
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
/**
 * Metodi sulkee Jframen.
 */
    public void close() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
