public class Cell {

    private final Position position;
    private boolean isAlive = false;

    public Cell(Position position) {
        this.position = position;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void isAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Position position() {
        return position;
    }
}
