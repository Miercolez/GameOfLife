import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    void add_cell_row_2_column_4_returns_cell_row_2_column_4() {
        Grid grid = new Grid(4,8);

        grid.addCell(2,4);

        Cell cell = grid.getCellFromList(2,4);

        assertEquals(2, cell.position().row());
        assertEquals(4, cell.position().column());
    }

    @Test
    void add_dead_cells_to_list_returns_cell_isAlive_false() {
        Grid grid = new Grid(4,8);

        grid.addDeadCells();

        assertFalse(grid.getCellFromList(1, 1).isAlive());
    }

    @Test
    void add_two_cells_returns_two_cells_alive() {
        Grid grid = new Grid(4,8);

        grid.addCell(2,4);
        grid.addCell(2,6);

        assertTrue(grid.getCellFromList(2, 4).isAlive());
        assertTrue(grid.getCellFromList(2, 6).isAlive());
        assertEquals(2, grid.stream().filter(Cell::isAlive).count());
    }

}
