package catsweeper.logiikka;

import java.util.*;

/**
 * Luokka on ilmentymä laudasta suurin osa kaikesta sovelluslogiikasta tehdään lauta tasolla.
 */
public class MineField {

    private int size;
    private Tile[][] board;
    private double chance;
    private Random random;
/**
 * @param size on pelilaudan leveyttä ja pituutta kuvaava arvo.
 * Pelilauta on siis neliö.
 */
    public MineField(int size) {
        this.size = size;
        this.chance = 0.15;
        this.board = new Tile[size][size];
        random = new Random();
        //printout();
    }
    
/**
 * Metodi on laudan alustukseen käytettävä apumetodi.
 */    
    public void initialize() {
        fieldInitializeBombs();
        fieldInitializeNumbers();
    }

//    public void printout(){
//        for (int x = 0; x < size; x++) {
//            for (int y = 0; y < size; y++) {
//                System.out.print(field[x][y].toString());
//            }
//            System.out.println("");
//        }        
//    }
    
/**
 * Metodi käy läpi laudan ja kutsuu Tilen alustavaa metodia ja asettaa pommit todennäköisyyden mukaan.
 */     
    public void fieldInitializeBombs() {
        Random random = new Random();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                fieldInitializeTiles(x, y);
                if (random.nextDouble() < chance) {
                    board[x][y].setBomb();
                    // System.out.println("pommi:" + x + y);
                }
            }
        }
    }
    //Täytyy jakaa useampaan osaan! Kaksi toiminnallisuutta!!!

    public void fieldInitializeTiles(int x, int y) {
        board[x][y] = new Tile(x, y);
    }
/**
 * Metodi tekee annetusta ruudusta pommin
     * @param x pommin sijainti x-akselilla.
     * @param y pommin sijainti y-akselilla.
 */     
    
    public void forceMakeBomb(int x, int y) {
        board[x][y].setBomb();
    }

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
 * Metodi laskee annetua ruutua ympäröivien ruutujen pommienmäärän
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

    public int getSize() {
        return size;
    }

}
