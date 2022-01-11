import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {

    @Test
    void cell_with_3_neighbours_returns_isAlive_true() {
        Cell cell = new CellBuilder()
                .position(new Position(1,1))
                .createCell();

        cell.neighbours(3);
        assertEquals(true, cell.isAlive());
    }
}
