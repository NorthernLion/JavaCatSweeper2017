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
        assertEquals(readyMade.getField().getSize(), readyMade.getSize());
    }
}
