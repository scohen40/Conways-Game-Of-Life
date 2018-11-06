package main;

public class GameOfLife {
    public Grid grid;

    public GameOfLife(Grid grid) {
        Grid newGrid = grid;

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
