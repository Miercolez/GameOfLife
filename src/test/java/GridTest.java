import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    @Test
    void add_cell_returns_cell_isAlive_true() {
        Grid grid = new Grid(4,8);

        Cell cell = grid.addCell();
    }
}
