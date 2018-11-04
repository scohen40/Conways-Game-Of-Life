package main.GUI;

import main.Grid;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeView extends JComponent {
    private Grid grid;
    private int canvasColWidth;
    private int canvasRowHeight;

    public GameOfLifeView(Grid grid, int canvasColWidth, int canvasRowHeight) {
        this.grid = grid;
        this.canvasColWidth = canvasColWidth;
        this.canvasRowHeight = canvasRowHeight;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D) graphics;

        paintGrid(g);

    }

    public void paintGrid(Graphics2D g) {
//        canvasColWidth = this.getWidth()/BoardProperties.BOARD_COLUMNS;
//        canvasRowHeight = this.getHeight()/BoardProperties.BOARD_ROWS;

//        Graphics2D g2 = (Graphics2D) g;
//        Color grey = new Color(180, 180, 180);
//        BasicStroke bs = new BasicStroke(3, 1, BasicStroke.CAP_ROUND);
//        g2.setStroke(bs);
//        g.setColor(Color.black);

        g.setColor(BoardProperties.gray);
        for( int r = 0; r < BoardProperties.BOARD_ROWS; r++) {
            for( int c = 0; c < BoardProperties.BOARD_COLUMNS; c++) {
//                g.drawLine(r * canvasColWidth, 0, r * canvasColWidth, grid.getColumns() * canvasColWidth);
//               g.drawLine(0,c * canvasRowHeight, grid.getRows() * canvasRowHeight , c * canvasRowHeight);

                g.drawLine(0, r * canvasColWidth, grid.getColumns() * canvasColWidth,r * canvasColWidth);
                g.drawLine(c * canvasRowHeight,0, c * canvasRowHeight, grid.getRows() * canvasRowHeight );
            }
        }


    }

}
