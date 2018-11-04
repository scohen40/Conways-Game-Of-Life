package main.GUI;

import main.Grid;
import main.GridBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class GameOfLifeGUI extends JFrame {
    private JPanel panel;
    private Grid grid;
    private GameOfLifeView gameView;



    public GameOfLifeGUI () {
        panel = new JPanel();
        setTitle("Conway's Game of Life");
        setSize(500, 500);
        grid = (new GridBuilder(BoardProperties.BOARD_ROWS, BoardProperties.BOARD_COLUMNS).getGrid());
        gameView = new GameOfLifeView(grid, this.getWidth() / BoardProperties.BOARD_COLUMNS, this.getHeight()/BoardProperties.BOARD_ROWS);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());

        panel.add(gameView, BorderLayout.CENTER);
        add(panel);


    }


    public static void main(String[] args) {
        new GameOfLifeGUI().setVisible(true);
    }
}





