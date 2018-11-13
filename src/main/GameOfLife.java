package main;

public class GameOfLife {
    private Grid grid;   //grid reference

    public GameOfLife(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    public void advanceGeneration() {
        int aliveNeighbors;
        Grid oldGrid = grid;
        Grid newGrid = new Grid(grid.getRows(), grid.getColumns());

        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getColumns(); j++) {
                Cell current = oldGrid.getGrid()[i][j];
                Cell newCell = new Cell(i, j);
                newGrid.getGrid()[i][j] = newCell;
                aliveNeighbors = getAliveNeighbors(current);

                if (current.getState() == Cell.State.alive) {
                    newCell.setState(Cell.State.alive);
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        newCell.setState(Cell.State.dead);
                    }
                } else {
                    newCell.setState(Cell.State.dead);
                    if (aliveNeighbors == 3) {
                        newCell.setState(Cell.State.alive);
                    }
                }


            }
        }
        this.grid = newGrid;
    }

    public int getAliveNeighbors(Cell cell) {
        int aliveNeighbors = 0;
        int row = cell.getRowLocation();
        int col = cell.getColumnLocation();

        try {
            //if not top row
            if (row != 0) {
                //if north neighbor is alive
                if (grid.getGrid()[row - 1][col].getState() == Cell.State.alive) {
                    aliveNeighbors++;
                }
                //if not left column
                if (col != 0) {
                    //if north-west neighbor is alive
                    if (grid.getGrid()[row - 1][col - 1].getState() == Cell.State.alive) {
                        aliveNeighbors++;
                    }
                }
            }
            //if not right column
            if (col != grid.getColumns() - 1) {
                //if east neighbor is alive
                if (grid.getGrid()[row][col + 1].getState() == Cell.State.alive) {
                    aliveNeighbors++;
                }
                //if not top column
                if (row != 0) {
                    //if northeaster neighbor is alive
                    if (grid.getGrid()[row - 1][col + 1].getState() == Cell.State.alive) {
                        aliveNeighbors++;
                    }
                }
            }
            //if not bottom row
            if (row != grid.getRows() - 1) {
                //if south neighbor is alive
                if (grid.getGrid()[row + 1][col].getState() == Cell.State.alive) {
                    aliveNeighbors++;
                }
                //if not right column
                if (col != grid.getColumns() - 1) {
                    //if southeast neighbor is alive
                    if (grid.getGrid()[row + 1][col + 1].getState() == Cell.State.alive) {
                        aliveNeighbors++;
                    }
                }
            }
            //if not left column
            if (col != 0) {
                //if western neighbor is alive
                if (grid.getGrid()[row][col - 1].getState() == Cell.State.alive) {
                    aliveNeighbors++;
                }
                //if not bottom row
                if (row != grid.getRows() - 1) {
                    //if south-west neighbor is alive
                    if (grid.getGrid()[row + 1][col - 1].getState() == Cell.State.alive) {
                        aliveNeighbors++;
                    }
                }
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }

        return aliveNeighbors;

    }

}
