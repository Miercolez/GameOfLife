import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    void cell_with_more_than_3_neighbours_returns_isAlive_false(int neighbours) {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .createCell();

        cell.neighbours(neighbours);
        cell.checkExistence();
        assertFalse(cell.isAlive());
    }
}
