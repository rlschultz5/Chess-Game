package org.schultz;

/**
 * Point switches the x,y coordinates to work with a 2D array
 *
 */
public class ChessPoint {
    private final int x;
    private final int y;

    /**
     * Point constructor that swaps the x,y coordinates to work with a 2D[][] array
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public ChessPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
