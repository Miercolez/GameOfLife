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
    }

    public Cell getCellFromList(int row, int column) {
        return this.cells[row - 1][column - 1];
    }
}
