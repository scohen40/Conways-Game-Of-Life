package src.main.GUI;

<<<<<<< HEAD

import src.main.Grid;
import src.main.GridBuilder;
=======
import main.GameOfLife;
import main.Grid;
import main.GridBuilder;
>>>>>>> 73715f37979eba63125b870e7fc1c62576f96f18

import javax.swing.*;

import java.awt.*;
<<<<<<< HEAD

=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
>>>>>>> 73715f37979eba63125b870e7fc1c62576f96f18

public class GameOfLifeGUI extends JFrame {
    private JPanel panel;
    private Grid grid;
    private GameOfLifeView gameView;
    private GameOfLife game;

    public GameOfLifeGUI() {
        panel = new JPanel();
        setTitle("Conway's Game of Life");
        setSize(600, 600);         //To Do - Figure out a way for the width and height to not be the same
        grid = (new GridBuilder(BoardProperties.BOARD_ROWS,BoardProperties.BOARD_COLUMNS).getGrid());

        gameView = new GameOfLifeView(grid);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game = new GameOfLife(grid);
                gameView.setGrid(game.grid);
                repaint();
            }
        };
        Timer timer = new Timer(4000, listener);
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





