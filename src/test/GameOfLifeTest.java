package test;

import main.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameOfLifeTest{

    Grid grid = new Grid(3, 3);


    @Test
    public void testGetAliveNeighbors() {
        //given
        for(int row = 0; row < grid.getGrid().length; row++) {
            for (int col = 0; col < grid.getGrid().length; col++) {
                grid.getGrid()[row][col] = new Cell(row, col);
                grid.getGrid()[row][col].setState(Cell.State.dead);
            }
        }

        for(int col = 0; col < grid.getGrid().length; col++){
            grid.getGrid()[1][col].setState(Cell.State.alive);
        }

        GameOfLife game = new GameOfLife(grid);
        //then
        //check 0,0 cell
        assertEquals(2, game.getAliveNeighbors(grid.getGrid()[0][0]));

        //check 0,1 cell
        assertEquals(3, game.getAliveNeighbors(grid.getGrid()[0][1]));

        //check 1,1 cell
        assertEquals(2, game.getAliveNeighbors(grid.getGrid()[1][1]));

        //check 2,2 cell
        assertEquals(2, game.getAliveNeighbors(grid.getGrid()[2][2]) );
    }

    @Test
    public void testAdvanceGeneration(){
        //given
        for(int row = 0; row < grid.getGrid().length; row++) {
            for (int col = 0; col < grid.getGrid().length; col++) {
                grid.getGrid()[row][col] = new Cell(row, col);
                grid.getGrid()[row][col].setState(Cell.State.dead);
            }
        }

        for(int col = 0; col < grid.getGrid().length; col++){
            grid.getGrid()[1][col].setState(Cell.State.alive);
        }

        GameOfLife game = new GameOfLife(grid);
        game.advanceGeneration();

        //then
        assertEquals(Cell.State.alive, game.getGrid().getGrid()[0][1].getState());
        assertEquals(Cell.State.alive, game.getGrid().getGrid()[1][1].getState());
        assertEquals(Cell.State.alive, game.getGrid().getGrid()[2][1].getState());
    }

}

