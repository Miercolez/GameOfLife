import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    @Test
    void add_cell_returns_cell_isAlive_true() {
        Grid grid = new Grid(4,8);

        Cell cell = grid.addCell(2, 4);

        assertEquals(true, cell.isAlive());
    }

    @Test
    void add_cell_row_2_column_4_returns_cell_row_2_column_4() {
        Grid grid = new Grid(4,8);

        Cell cell = grid.addCell(2,4);

        assertEquals(2, cell.row());
        assertEquals(4, cell.column());
    }
}
