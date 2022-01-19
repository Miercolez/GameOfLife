package gameoflife;

public class Cell {

    private final Position position;
    private boolean isAlive;
    private int neighbours;

    public Cell(Position position, boolean isAlive) {
        this.position = position;
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public Position position() {
        return position;
    }

    public void neighbours(int neighbours) {
        this.neighbours = neighbours;
    }

    public void checkCellLife() {
        this.isAlive = neighbours == 3 || (neighbours == 2 && this.isAlive);
    }
}
