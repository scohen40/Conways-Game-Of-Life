package test;

import main.Cell;
import main.Grid;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {
    @Test
    public void getAliveNeighborsTest() {
        //given
        Grid grid = new Grid(3, 3);

        //when
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                grid.getGrid()[row][col] = new Cell(row, col);
            }
        }

        grid.getGrid()[1][0].setState(Cell.State.alive);
        grid.getGrid()[1][1].setState(Cell.State.alive);
        grid.getGrid()[1][2].setState(Cell.State.alive);

        //


    }
}
