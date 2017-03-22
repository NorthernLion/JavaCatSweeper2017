/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catsweeper.logiikka;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Pesonen
 */
public class TileTest {

    Tile readyMade;

    @Before
    public void setUp() {
        readyMade = new Tile(3, 2);
    }

    @Test
    public void constructorSetsCoordinatesXAndYRight() {
        Tile tile = new Tile(1, 2);

        String answer = tile.toString();

        assertEquals("(1,2)", answer);
    }
    //Getterit ja setteri testit laajennetaan testaamaan rajatapauksia esim negatiivisia arvoja myöhemmin

    @Test
    public void setsCoordinatesRight() {
        readyMade.setX(1);
        readyMade.setY(5);

        String answer = readyMade.toString();

        assertEquals("(1,5)", answer);
    }

    @Test
    public void getsXRight() {
        assertTrue(readyMade.getY() == 2);
    }

    @Test
    public void getsYRight() {
        assertTrue(readyMade.getX() == 3);
    }

    @Test
    public void setsBombRight() {
        readyMade.setBomb();
        assertTrue(readyMade.isBomb());
    }

    @Test
    public void isBombIsFalseIfValueIsBelow9() {
        readyMade.setValue(8);
        assertTrue(!readyMade.isBomb());
    }

    @Test
    public void setValueNoWorksWithBadValue() {
        readyMade.setValue(10);
        assertTrue(readyMade.getValue() == 0);
    }

    @Test
    public void setValueWorksWithGoodValue() {
        readyMade.setValue(7);
        assertTrue(readyMade.getValue() == 7);
    }

    @Test
    public void revealedTileIsRevealed() {
        readyMade.reveal();
        assertTrue(readyMade.isRevealed());
    }

    @Test
    public void flaggedTileIsFlagged() {
        readyMade.flag();
        assertTrue(readyMade.isFlagged());
    }

}
