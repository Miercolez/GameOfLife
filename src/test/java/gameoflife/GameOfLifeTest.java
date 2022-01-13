package gameoflife;

import gameoflife.builders.GameOfLifeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    @Test
    void create_grid_6_by_8_returns_48() {
        GameOfLife gameOfLife = new GameOfLifeBuilder()
                .createGrid(6,8)
                .createGameOfLife();

        Grid grid = gameOfLife.getGrid();

        assertEquals(48, grid.size());
    }

    @Test
    void create_grid_4_by_8_returns_32() {
        GameOfLife gameOfLife = new GameOfLifeBuilder()
                .createGrid(4,8)
                .createGameOfLife();

        Grid grid = gameOfLife.getGrid();

        assertEquals(32, grid.size());
    }

    @Test
    void add_one_cell_returns_all_cells_isAlive_false_next_round() {
        GameOfLife gameOfLife = new GameOfLifeBuilder()
                .createGrid(4,8)
                .addCell(2,6)
                .createGameOfLife();

        gameOfLife.renderNextRound();

        Grid grid = gameOfLife.getGrid();
        assertFalse(grid.getCellFromList(2, 6).isAlive());
        assertEquals(0, grid.stream().filter(Cell::isAlive).count());
    }

    @Test
    void three_cells_in_a_row_returns_three_alive_cells_next_round() {
        GameOfLife gameOfLife = new GameOfLifeBuilder()
                .createGrid(4,8)
                .addCell(2,6)
                .addCell(2,5)
                .addCell(2,4)
                .createGameOfLife();

        gameOfLife.renderNextRound();

        Grid grid = gameOfLife.getGrid();
        assertFalse(grid.getCellFromList(2, 6).isAlive());
        assertEquals(3, grid.stream().filter(Cell::isAlive).count());
    }

    @Test
    void three_cells_in_a_row_returns_two_new_cells_alive() {
        GameOfLife gameOfLife = new GameOfLifeBuilder()
                .createGrid(4,8)
                .addCell(2,3)
                .addCell(2,4)
                .addCell(2,5)
                .createGameOfLife();

        gameOfLife.renderNextRound();

        Grid grid = gameOfLife.getGrid();
        assertTrue(grid.getCellFromList(1, 4).isAlive());
        assertTrue(grid.getCellFromList(2, 4).isAlive());
        assertTrue(grid.getCellFromList(3, 4).isAlive());
    }

    @Test
    void four_cells_in_a_triangle_returns_seven_cells_alive() {
        GameOfLife gameOfLife = new GameOfLifeBuilder()
                .createGrid(4,8)
                .addCell(2,4)
                .addCell(3,3)
                .addCell(3,4)
                .addCell(3,5)
                .createGameOfLife();

        gameOfLife.renderNextRound();

        Grid grid = gameOfLife.getGrid();
        assertEquals(7, grid.stream().filter(Cell::isAlive).count());
    }


}
