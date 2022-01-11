public class CellBuilder {
    private Position position;
    private boolean isAlive;

    public CellBuilder position(Position position) {
        this.position = position;
        return this;
    }

    public CellBuilder isAlive(boolean isAlive) {
        this.isAlive = isAlive;
        return this;
    }

    public Cell createCell() {
        return new Cell(position, isAlive);
    }
}