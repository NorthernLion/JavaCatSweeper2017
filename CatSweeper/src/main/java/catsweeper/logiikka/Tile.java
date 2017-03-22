/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catsweeper.logiikka;

/**
 *
 * @author Pesonen
 */
public class Tile {

    private int value;
    private int x;
    private int y;
    private boolean revealed;
    private boolean flagged;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.revealed = false;
        this.flagged = false;
        this.value = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void flag() {
        flagged = true;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setValue(int given) {
        if (0 <= given && given <= 9) {
            value = given;
        }

    }

    public boolean isRevealed() {
        return revealed;
    }

    public void reveal() {
        revealed = true;
    }

    public boolean isBomb() {
        if (value == 9) {
            return true;
        } else {
            return false;
        }
    }

    public void setBomb() {
        value = 9;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
