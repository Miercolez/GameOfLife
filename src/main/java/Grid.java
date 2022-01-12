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

    public void calculateNextRound() {
        calculateNeighbours();
        checkExistence();
    }

    public void calculateNeighbours() {
        stream().forEach(this::increaseNeighbours);
    }

    private void increaseNeighbours(Cell activeCell) {
        int amountOfNeighbours = (int) stream()
                .filter(cell -> isPosNextToCurrent(cell.position(), activeCell.position()))
                .filter(cell -> cell.position() != activeCell.position())
                .filter(Cell::isAlive)
                .count();

        activeCell.addNeighbours(amountOfNeighbours);
    }

    public void checkExistence() {
        stream().forEach(Cell::existence);
    }

    private boolean isPosNextToCurrent(Position neighbourPos, Position currentPos) {
        return isRowNextToCurrent(neighbourPos,currentPos) && isColumnNextToCurrent(neighbourPos,currentPos);
    }

    private boolean isRowNextToCurrent(Position neighbourPos, Position currentPos) {
        return neighbourPos.row() >= currentPos.previousRow() && neighbourPos.row() <= currentPos.nextRow();
    }

    private boolean isColumnNextToCurrent(Position neighbourPos, Position currentPos) {
        return neighbourPos.column() >= currentPos.previousColumn() && neighbourPos.column() <= currentPos.nextColumn();
    }

}
