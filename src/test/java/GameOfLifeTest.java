import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

}
