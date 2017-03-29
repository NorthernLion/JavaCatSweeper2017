package catsweeper.logiikka;

import java.util.*;

public class MineField {

        private int size;
    private Tile[][] field;
    private int bombs;

    public MineField(int size) {
        this.size = size;
        this.bombs = size/8;
        this.field = new Tile[size][size];
        fieldInitializeBombs();
        fieldInitializeNumbers();
    }

    // Testi mielessä tehtyä koodia
    public void fieldInitializeBombs() {
        Random random = new Random();

        int count = 0;
        while (count < bombs) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            if (!field[x][y].isBomb()) {
                field[x][y].setBomb();
                count++;
            }

        }
    }

    public void fieldInitializeNumbers() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                field[x][y].setX(x);
                field[x][y].setY(y);
                field[x][y].setValue(countNeigborBombs(field[x][y]));
            }
        }

    }

    public int countNeigborBombs(Tile tile) {
        int x = tile.getX();
        int y = tile.getY();
        int value = 0;

        // TBD Pitää jotenkin tietää ketkä ovat naapureita, jotta
        // voidaan koodata ns. aalto efekti helposti
        // x y tilessä on varmaan paras, for future!
        return 0;
    }

    public Tile[][] getField() {
        return field;
    }
    
    

}
