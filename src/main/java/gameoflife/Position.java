package gameoflife;

public record Position(int row, int column) {

    private int previousRow(){
        return this.row - 1;
    }

    private int nextRow(){
        return this.row + 1;
    }

    private int previousColumn(){
        return this.column - 1;
    }

    private int nextColumn(){
        return this.column + 1;
    }

    public boolean isPosNextToCurrent(Position neighbourPos) {
        return isRowNextToCurrent(neighbourPos) && isColumnNextToCurrent(neighbourPos);
    }

    private boolean isRowNextToCurrent(Position neighbourPos) {
        return neighbourPos.row() >= previousRow() && neighbourPos.row() <= nextRow();
    }

    private boolean isColumnNextToCurrent(Position neighbourPos) {
        return neighbourPos.column() >= previousColumn() && neighbourPos.column() <= nextColumn();
    }

}
