package catsweeper.logiikka;

import catsweeper.gui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Luokka on ilmentymä miinaharava pelin logiikasta, joka huolehtii pelin
 * aloittamisesta ja resetoinnista.
 */
public class MineSweeperGame {

    private MineField field;
    private int size;
    private UserInterface gInterface;
    private String[] choices;

    /**
     * Luokka on konstruktori.
     */
    public MineSweeperGame() {
        this.choices = new String[]{"large", "medium", "small"};
        this.size = 15;
    }

    /**
     * Metodi alustaa pelilaudan ja graaffisen käyttöliittymän jos vanha ikkuna
     * on auki suljetaan se ennen uuden avaamista. Kysytään myös uuden
     * pelilaudan kokoa.
     */
    public void start() {
        if (gInterface != null) {
            gInterface.close();
        }
        String answer = (String) JOptionPane.showInputDialog(
                null,
                "Select Difficulty",
                "Difficulty selector",
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices,
                choices[0]);
        setAskedSizeFromAnswer(answer);
        fieldCreator();
        this.gInterface = new UserInterface(this);
        SwingUtilities.invokeLater(gInterface);
        field.initialize();
    }

    /**
     * Metodi luo uuden laudan.
     */
    public void fieldCreator() {
        this.field = new MineField(size);
    }

    /**
     * Metodi muutta laudan koon pelaajan haluamaksi.
     *
     * @param answer on halutun koon nimi.
     */
    public void setAskedSizeFromAnswer(String answer) {
        if (answer == null) {
            System.exit(0);
        }
        if (answer == "large") {
            this.size = 15;
        } else if (answer == "medium") {
            this.size = 10;
        } else if (answer == "small") {
            this.size = 5;
        }
    }

    public MineField getField() {
        return field;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
