/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catsweeper.logiikka;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Pesonen
 */
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
        Assert.assertTrue(2 == readyMade.countNeigborBombs(new Tile(1,0)));
    }
    
    @Test
    public void countNeigborBombsReturnRightValueWhenOne() {
        Assert.assertTrue(1 == readyMade.countNeigborBombs(new Tile(6,6)));
    }
    
    @Test
    public void countNeigborBombsReturnRightValueWhenOnEdge() {
        Assert.assertTrue(1 == readyMade.countNeigborBombs(new Tile(0,0)));
    }       
    
    @Test
    public void getsBoardRight() {
        Assert.assertTrue(readyMade.getBoard()[0][0].isBomb());
    }
    
    @Test
    public void initializeProductTesting() {
        MineField minef = new MineField(10);
        minef.initialize();
    }
    
    // Pitää jakaa noita jotenkin!
    

    
    

    
}
