package catsweeper.logiikka;


/**
 * Luokka on ilmentymä miinaharavan ruudusta.
 */

public class Tile {

    private int value;
    private int x;
    private int y;
    private boolean revealed;
    private boolean flagged;
/**
 * Metodi on konstruktori.
 * @param x on ruudun x akselilla sijainti laudalla.
 * @param y on ruudun y akselilla sijainti laudalla.
 */
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.revealed = false;
        this.flagged = false;
        this.value = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
/**
 * Metodi asettaa ruudun tilan merkatuksi, jos sitä ei ole vielä paljastettu.
 */
    public void flag() {
        if (!this.isRevealed()) {
            flagged = true;
        }
    }
/**
 * Metodi merkkaa ruudun liputtomaksi.
 */    
    public void unflag() {
        flagged = false;
    }

    public boolean isFlagged() {
        return flagged;
    }
/**
 * Metodi asettaa ruudun arvon.
 * Arvo 9 tarkoittaa miinaa 0-8 kuvaa viereisten miinojen määrää.
 * @param given on annettu arvo, joka kuvaa viereisten miinojen määrää.
 */
    public void setValue(int given) {
        if (0 <= given && given <= 9) {
            value = given;
        }

    }

    public boolean isRevealed() {
        return revealed;
    }
/**
 * Metodi paljastaa ruudun, jos se ei ole vielä paljastettu.
 * @return Epätosi jos pommi.
 */
    public boolean reveal() {
        if (!this.isRevealed()) {
            revealed = true;
            if (isBomb()) {
                return false;
            }
        }
        return true;
    }
    
    /**
 * Metodi kertoo onko ruudussa pommi.
 * 
     * @return true jos on, false jos ei ole.
 */
    public boolean isBomb() {
        if (value == 9) {
            return true;
        } else {
            return false;
        }
    }
/**
 * Metodi tekee ruudusta pommin.
 */
    public void setBomb() {
        value = 9;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

}
