public class Grid {

    private final int rows;
    private final int columns;
    private final Cell[][] cells;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];
    }

    public int size() {
        return rows * columns;
    }

    public void addCell(int row, int column) {
        this.cells[row - 1][column - 1] =  new Cell(row, column);
        this.cells[row - 1][column - 1].isAlive(true);

    }

    public Cell getCellFromList(int row, int column) {
        return this.cells[row - 1][column - 1];
    }

    public void addDeadCells() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new Cell(row + 1, column + 1);
            }
        }
    }
}
