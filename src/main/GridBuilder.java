package src.main;

import java.util.Random;

public class GridBuilder {
    private Grid grid;
    private int rows;
    private int columns;

    public GridBuilder(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        grid = new Grid(rows, columns);
        buildGrid();

    }

    private void buildGrid() {
        int counter = 0;
        Random rand = new Random();
        for (int row = 0; row < grid.getGrid().length; row++) {
            for (int col = 0; col < grid.getGrid().length; col++) {
                grid.getGrid()[row][col] = new Cell(row, col);
                switch (rand.nextInt(2)) {
                    case 0:
                        grid.getGrid()[row][col].setState(Cell.State.alive);
                        break;
                    case 1:
                        grid.getGrid()[row][col].setState(Cell.State.dead);
                        break;
                    default:
                        grid.getGrid()[row][col].setState(Cell.State.neverLived);
                }
                grid.getGrid()[row][col].setId(counter);
                counter++;
            }
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

}
