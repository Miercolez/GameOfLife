import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void cell_with_2_or_3_neighbours_returns_isAlive_true(int neighbours) {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .createCell();

        cell.neighbours(neighbours);
        cell.checkExistence();
        assertTrue(cell.isAlive());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1})
    void cell_with_less_than_2_neighbours_returns_isAlive_false(int neighbours) {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .createCell();

        cell.neighbours(neighbours);
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
