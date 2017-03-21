/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catsweeper.logiikka;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
/**
 *
 * @author Pesonen
 */
public class EmptyTest {
    
    Empty readyMade;
    
    @Before
    public void setUp() {
        readyMade = new Empty(3, 2);
    }
    
    @Test
    public void ConstructorSetsCoordinatesXAndYRight() {
        Empty empty = new Empty(1,2);
        
        String answer = empty.toString();
        
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
