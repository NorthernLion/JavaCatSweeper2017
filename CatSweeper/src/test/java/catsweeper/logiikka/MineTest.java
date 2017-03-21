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
public class MineTest {

    
    Mine readyMade;
    
    @Before
    public void setUp() {
        readyMade = new Mine(3, 2);
    }
    
    @Test
    public void ConstructorSetsCoordinatesXAndYRight() {
        Mine mine = new Mine(1,2);
        
        String answer = mine.toString();
        
        assertEquals("(1,2)", answer);
    }
    
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
