import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    void cell_with_3_neighbours_returns_isAlive_true() {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .createCell();

        cell.neighbours(3);
        cell.checkExistence();
        assertTrue(cell.isAlive());
    }

    @Test
    void cell_with_1_neighbours_returns_isAlive_false() {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .createCell();

        cell.neighbours(1);
        cell.checkExistence();
        assertFalse(cell.isAlive());
    }
}
