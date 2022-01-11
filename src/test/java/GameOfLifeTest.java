import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

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

}
