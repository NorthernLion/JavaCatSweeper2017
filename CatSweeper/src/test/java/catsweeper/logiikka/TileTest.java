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
    public void ConstructorSetsCoordinatesXAndYRight() {
        Tile tile = new Tile(1,2);
        
        String answer = tile.toString();
        
        assertEquals("(1,2)", answer);
    }
    //Getterit ja setteri testit laajennetaan testaamaan rajatapauksia esim negatiivisia arvoja
    
    @Test
    public void SetterSetsCoordinatesRight() {
        readyMade.setX(1);
        readyMade.setY(5);
        
        String answer = readyMade.toString();
        
        assertEquals("(1,5)", answer);
    }
    
    @Test
    public void GetterGetsXRight() {
        assertTrue(readyMade.getY() == 2);
    }
    
    @Test
    public void GetterGetsYRight() {
        assertTrue(readyMade.getX() == 3);
    }

    
}
