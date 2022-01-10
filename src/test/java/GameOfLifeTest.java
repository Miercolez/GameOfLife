import org.junit.jupiter.api.Test;

public class GameOfLifeTest {

    @Test
    void create_grid_6_by_8_returns_48() {
        GameOfLife gameOfLife = new GameOfLife();

        int actual = gameOfLife.createGrid(6,8);
    }
}
