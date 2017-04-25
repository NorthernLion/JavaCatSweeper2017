package catsweeper.logiikka;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MineFieldTest {

    MineField readyMade;

    @Before
    public void setUp() {
        readyMade = new MineField(10);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                readyMade.fieldInitializeTiles(x, y);
            }
        }
        readyMade.forceMakeBomb(0, 0);
        readyMade.forceMakeBomb(1, 1);
        readyMade.forceMakeBomb(5, 6);
    }

    @Test
    public void countNeigborBombsReturnRightValueWhenMutiple() {
        Assert.assertTrue(2 == readyMade.countNeigborBombs(new Tile(1, 0)));
    }

    @Test
    public void countNeigborBombsReturnRightValueWhenOne() {
        Assert.assertTrue(1 == readyMade.countNeigborBombs(new Tile(6, 6)));
    }

    @Test
    public void countNeigborBombsReturnRightValueWhenOnEdge() {
        Assert.assertTrue(1 == readyMade.countNeigborBombs(new Tile(0, 0)));
    }

    @Test
    public void getsBoardRight() {
        Assert.assertTrue(readyMade.getBoard()[0][0].isBomb());
    }

    @Test
    public void iAmWinnerIfAllRevealed() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                readyMade.getBoard()[x][y].reveal();
            }
        }
        Assert.assertTrue(readyMade.checkWinner());
    }

    @Test
    public void iAmWinnerIfNoneReavlead() {
        Assert.assertTrue(!readyMade.checkWinner());
    }

    @Test
    public void numbersAreInitializedCorrectly() {
        readyMade.fieldInitializeNumbers();
        Assert.assertTrue(readyMade.getBoard()[1][0].getValue() == 2);
    }

    @Test
    public void allInitializeTested() {
        MineField initializeField = new MineField(10);
        initializeField.initialize();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (!initializeField.getBoard()[x][y].isBomb()) {
                    Assert.assertTrue(initializeField.getBoard()[x][y].getValue() == initializeField.countNeigborBombs(initializeField.getBoard()[x][y]));
                } else {
                    Assert.assertTrue(initializeField.getBoard()[x][y].getValue() == 9);
                }
            }
        }
    }
}
