/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catsweeper.logiikka;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Pesonen
 */
public class MineSweeperGameTest {

    MineSweeperGame readyMade;

    @Before
    public void setUp() {
        readyMade = new MineSweeperGame();
    }

    @Test
    public void sizeInGameAndFieldAreTheSame() {
        readyMade.fieldCreator();
        assertEquals(readyMade.getField().getSize(), readyMade.getSize());
    }

    @Test
    public void SetSizeWorks() {
        readyMade.setSize(5);
        assertEquals(readyMade.getSize(), 5);
    }

    @Test
    public void settingSizeFromStringWorks() {
        readyMade.setAskedSizeFromAnswer("medium");
        assertEquals(readyMade.getSize(), 10);
        readyMade.setAskedSizeFromAnswer("small");
        assertEquals(readyMade.getSize(), 5);
        readyMade.setAskedSizeFromAnswer("large");
        assertEquals(readyMade.getSize(), 15);
    }
}
