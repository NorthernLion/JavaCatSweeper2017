package catsweeper.logiikka;

import java.util.*;

/**
 * Luokka on ilmentymä miinaharavan laudasta. Laudalla on lista kaikista ruuduista.
 */
public class MineField {

    private int size;
    private Tile[][] board;
    private double chance;
    private Random random;

    /**
     * Metodi on konstruktori.
     * @param size on pelilaudan leveyttä ja pituutta kuvaava arvo.
     */
    public MineField(int size) {
        this.size = size;
        this.chance = 0.15;
        this.board = new Tile[size][size];
        random = new Random();
    }

    /**
     * Metodi on laudan alustukseen käytettävä apumetodi.
     * Se alustaa ensin pommit ja sen jälkeen laskee ruuduille arvot.
     */
    public void initialize() {
        fieldInitializeBombs();
        fieldInitializeNumbers();
    }

    /**
     * Metodi käy läpi laudan ja kutsuu Tilen alustavaa metodia ja asettaa
     * pommit todennäköisyyden mukaan.
     */
    public void fieldInitializeBombs() {
        Random random = new Random();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                fieldInitializeTiles(x, y);
                if (random.nextDouble() < chance) {
                    board[x][y].setBomb();
                }
            }
        }
    }
    
     /**
     * Metodi alustaa Tilen annetuilla koordinaateilla ja sijoittaa sen laudalle.
     *
     * @param x ruudun sijainti x-akselilla.
     * @param y ruudun sijainti y-akselilla. 
     */   
    public void fieldInitializeTiles(int x, int y) {
        board[x][y] = new Tile(x, y);
    }

    /**
     * Metodi tekee annetusta ruudusta pommin.
     *
     * @param x pommin sijainti x-akselilla.
     * @param y pommin sijainti y-akselilla.
     */
    public void forceMakeBomb(int x, int y) {
        board[x][y].setBomb();
    }
    /**
     * Metodi käy läpi laudan kaikki ruudut ja laskee sen arvon apumetodilla.
     */
    public void fieldInitializeNumbers() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (!board[x][y].isBomb()) {
                    board[x][y].setValue(countNeigborBombs(board[x][y]));
                }
            }
        }
    }

    /**
     * Metodi laskee annetua ruutua ympäröivien ruutujen pommienmäärän.
     *
     * @param tile annettu ruutu.
     * @return naapurissa olevien pommien määrä.
     */
    public int countNeigborBombs(Tile tile) {
        int value = 0;
        for (Tile suroundingTile : getSuroundingTiles(tile)) {
            if (suroundingTile.isBomb()) {
                value++;
            }
        }
        return value;
    }
    /**
     * Metodi palauttaa annettua ruutua ympäröivät ruudut.
     *
     * @param tile annettu ruutu.
     * @return surounders ympäröivät ruudut listana.
     */
    public List<Tile> getSuroundingTiles(Tile tile) {
        ArrayList<Tile> surounders = new ArrayList<>();
        int x = tile.getX();
        int y = tile.getY();
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (x == j && y == i) {
                    continue;
                }
                if (i < 0 || i >= size) {
                    continue;
                }
                if (j < 0 || j >= size) {
                    continue;
                }
                surounders.add(board[j][i]);
            }
        }
        return surounders;
    }

    public Tile[][] getBoard() {
        return board;
    }
    /**
     * Metodi tarkistaa onko kaikki pommittomat ruudut avattu.
     * Jos on voitat pelin
     * @return true jos voittaja false jos ei.
     */
    public boolean checkWinner() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Tile current = board[x][y];
                if (!current.isBomb() && !current.isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

}
