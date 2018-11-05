package main;

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

    public void createNewGeneration(Grid oldGrid) {
        Grid newGrid = oldGrid;

        for (int i = 0; i < newGrid.getRows(); i++) {
            for (int j = 0; j < newGrid.getColumns(); j++) {
                int aliveNeighbors = 0;
                Cell current = newGrid.getGrid()[i][j];
                try {
                    if (i != 0) {
                        if (newGrid.getGrid()[i - 1][j].getState() == Cell.State.alive) {
                            aliveNeighbors++;
                        }
                        if (j != 0) {
                            if (newGrid.getGrid()[i - 1][j - 1].getState() == Cell.State.alive) {
                                aliveNeighbors++;
                            }
                        }
                    }
                    if (j != newGrid.getColumns() - 1) {
                        if (newGrid.getGrid()[i][j + 1].getState() == Cell.State.alive) {
                            aliveNeighbors++;
                        }
                        if (i != 0) {
                            if (newGrid.getGrid()[i - 1][j + 1].getState() == Cell.State.alive) {
                                aliveNeighbors++;
                            }
                        }
                    }
                    if (i != newGrid.getRows() - 1) {
                        if (newGrid.getGrid()[i + 1][j].getState() == Cell.State.alive) {
                            aliveNeighbors++;
                        }
                        if (j != newGrid.getColumns() - 1) {
                            if (newGrid.getGrid()[i + 1][j + 1].getState() == Cell.State.alive) {
                                aliveNeighbors++;
                            }
                        }
                    }
                    if (j != 0) {
                        if (newGrid.getGrid()[i][j - 1].getState() == Cell.State.alive) {
                            aliveNeighbors++;
                        }
                        if (i != newGrid.getRows() - 1) {
                            if (newGrid.getGrid()[i + 1][j - 1].getState() == Cell.State.alive) {
                                aliveNeighbors++;
                            }
                        }
                    }
                    if (current.getState() == Cell.State.alive) {
                        if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                            current.setState(Cell.State.dead);
                        }
                    } else {
                        if (aliveNeighbors == 3) {
                            current.setState(Cell.State.alive);
                        }
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.toString());
                }
            }
        }

        this.grid = newGrid;
    }
}
