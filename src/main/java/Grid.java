public class Grid {

    private final int MAX_ROWS;
    private final int MAX_COLUMNS;
    private final Cell[][] cells;

    public Grid(int rows, int columns) {
        this.MAX_ROWS = rows;
        this.MAX_COLUMNS = columns;
        this.cells = new Cell[rows][columns];
    }

    public int size() {
        return MAX_ROWS * MAX_COLUMNS;
    }

    public void addCell(int row, int column) {
        this.cells[row - 1][column - 1] =  new Cell(row, column);
        this.cells[row - 1][column - 1].isAlive(true);

    }

    public Cell getCellFromList(int row, int column) {
        return this.cells[row - 1][column - 1];
    }

    public void addDeadCells() {
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_COLUMNS; column++) {
                cells[row][column] = new Cell(row + 1, column + 1);
            }
        }
    }
}
