package gameoflife;

import gameoflife.builders.CellBuilder;

import java.util.Arrays;
import java.util.stream.Stream;

public class Grid {
    private final int MAX_ROWS;
    private final int MAX_COLUMNS;
    private final Cell[][] cells;

    public Grid(int rows, int columns) {
        this.MAX_ROWS = rows;
        this.MAX_COLUMNS = columns;
        this.cells = new Cell[rows][columns];
        addDeadCells();
    }

    public int size() {
        return MAX_ROWS * MAX_COLUMNS;
    }

    public void addCell(int row, int column){
        try{
            this.cells[row - 1][column - 1] = new CellBuilder()
                    .position(new Position(row, column))
                    .isAlive(true)
                    .createCell();
        }catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("The position of the cell is outside the grid.");
        }
    }

    public Cell getCellFromList(int row, int column) {
        return this.cells[row - 1][column - 1];
    }

    public void addDeadCells() {
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_COLUMNS; column++) {
                cells[row][column] = new CellBuilder()
                        .position(new Position(row + 1, column + 1))
                        .createCell();
            }
        }
    }

    public void calculateNextRound() {
        calculateNeighbours();
        checkExistence();
    }

    public void calculateNeighbours() {
        this.stream().forEach(this::increaseNeighbours);
    }

    private void increaseNeighbours(Cell activeCell) {
        int amountOfNeighbours = (int) this.stream()
                .filter(cell -> activeCell.position().isPosNextToCurrent(cell.position()))
                .filter(cell -> cell.position() != activeCell.position())
                .filter(Cell::isAlive)
                .count();

        activeCell.addNeighbours(amountOfNeighbours);
    }

    public void checkExistence() {
        stream().forEach(Cell::existence);
    }

    public Stream<Cell> stream() {
        return Arrays.stream(cells).flatMap(Arrays::stream);
    }


}
