public record Position(int row, int column) {

    public int previousRow(){
        return this.row - 1;
    }

    public int nextRow(){
        return this.row + 1;
    }

    public int previousColumn(){
        return this.column - 1;
    }

    public int nextColumn(){
        return this.column + 1;
    }
}
