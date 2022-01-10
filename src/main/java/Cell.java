public class Cell {

    private final int row;
    private final int column;
    private boolean isAlive = false;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public int row() {
        return this.row;
    }

    public int column() {
        return this.column;
    }

    public void isAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
