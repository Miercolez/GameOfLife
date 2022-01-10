public class Grid {

    private final int rows;
    private final int columns;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int size() {
        return rows * columns;
    }
}
