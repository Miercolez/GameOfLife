import java.util.Arrays;
import java.util.stream.Stream;

public class Grid {
    private final int MAX_ROWS;
    private final int MAX_COLUMNS;
    private final Cell[][] cells;

    public Grid(int rows, int columns) {
        this.MAX_ROWS = rows;
        this.MAX_COLUMNS = columns;
        this.cells = new Cell[rows][columns];
        addDeadCells();
    }

    public int size() {
        return MAX_ROWS * MAX_COLUMNS;
    }

    public void addCell(int row, int column) {
        this.cells[row - 1][column - 1] = new CellBuilder()
                .position(new Position(row, column))
                .isAlive(true)
                .createCell();
    }

    public Cell getCellFromList(int row, int column) {
        return this.cells[row - 1][column - 1];
    }

    public void addDeadCells() {
       for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_COLUMNS; column++) {
                cells[row][column] = new CellBuilder()
                        .position(new Position(row + 1, column + 1))
                        .createCell();
            }
        }
    }

    public Stream<Cell> stream() {
        return Arrays.stream(cells).flatMap(Arrays::stream);
    }

}
