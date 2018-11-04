package main.GUI;


import java.awt.*;

/**
 * Contains the details and parameters of the game, as well as some presets.
 */
class BoardProperties {


    // GameBoard.
    static final int BOARD_COLUMNS   = 10;//To Do - figure out a way for the rows and columns to not have to be the same
    static final int BOARD_ROWS      = 10;
    static final int SQUARE_SIZE     = 20;

    // Preset colors
    static Color green = new Color(36, 165, 107);
    static Color blue = new Color(42, 97, 203);
    static Color violet = new Color(150, 62, 238);
    static Color red = new Color(230, 61, 61);
    static Color orange = new Color(223, 150, 77);
    static Color yellow = new Color(230, 227, 67);
    static Color gray = Color.GRAY;

    static Color[] colors = {green, blue, violet, red, orange, yellow, gray};


}