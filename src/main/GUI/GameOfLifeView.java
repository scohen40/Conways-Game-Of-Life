package main.GUI;

import main.Cell;
import main.Grid;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeView extends JComponent {


    private Grid grid;
    private int canvasColWidth;
    private int canvasRowHeight;

    public GameOfLifeView(Grid grid) {
        this.grid = grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;

        canvasColWidth = this.getWidth()/BoardProperties.BOARD_COLUMNS;
        canvasRowHeight = this.getHeight()/BoardProperties.BOARD_ROWS;

        paintBackground(g);
        paintGrid(g);
    }

    private void paintBackground(Graphics2D g) {
        setBackground(BoardProperties.gray);
        setOpaque(true);
    }

    public void paintGrid(Graphics2D g) {
        BasicStroke bs = new BasicStroke(3, 1, BasicStroke.CAP_ROUND);
        g.setStroke(bs);

        Cell cell;

        for( int r = 0; r < BoardProperties.BOARD_ROWS; r++) {
            for( int c = 0; c < BoardProperties.BOARD_COLUMNS; c++) {
                cell = grid.getGrid()[r][c];
                if ((cell.getState() == Cell.State.neverLived) || (cell.getState()== Cell.State.dead)) {
                    g.setColor(BoardProperties.white);
                }
                else if(cell.getState() == Cell.State.alive) {
                    g.setColor(BoardProperties.black);
                }
                g.fill3DRect(c * canvasColWidth + 7, r * canvasRowHeight + 7, (int)(canvasColWidth/1.3), (int)(canvasRowHeight/1.2), false);
            }
        }
    }
}
