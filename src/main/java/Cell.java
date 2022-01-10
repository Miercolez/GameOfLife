public class Cell {

    private final int row;
    private final int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isAlive() {
        return true;
    }

    public int row() {
        return this.row;
    }

    public int column() {
        return this.column;
    }
}
