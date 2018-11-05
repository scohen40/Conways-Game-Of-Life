package main.GUI;

import main.Grid;
import main.GridBuilder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class GameOfLifeGUI extends JFrame {
    private JPanel panel;
    private Grid grid;
    private GameOfLifeView gameView;


    public GameOfLifeGUI() {
        panel = new JPanel();
        setTitle("Conway's Game of Life");
        setSize(600, 600);         //To Do - Figure out a way for the width and height to not be the same
        final GridBuilder builder = new GridBuilder(BoardProperties.BOARD_ROWS, BoardProperties.BOARD_COLUMNS);

        grid = (builder.getGrid());

        gameView = new GameOfLifeView(grid);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                builder.createNewGeneration(grid);
                gameView.setGrid(builder.getGrid());
                repaint();
            }
        };
        Timer timer = new Timer(2000, listener);
        timer.setRepeats(true);
        timer.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());

        panel.add(gameView, BorderLayout.CENTER);
        add(panel);


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOfLifeGUI().setVisible(true);
            }
        });
    }
}





