package gameoflife.builders;

import gameoflife.GameOfLife;
import gameoflife.Grid;

public class GameOfLifeBuilder {
    private Grid grid;

    public GameOfLifeBuilder createGrid(int row, int column) {
        this.grid = new Grid(row, column);
        return this;
    }

    public GameOfLifeBuilder addCell(int row, int column) {
        grid.addCell(row,column);
        return this;
    }

    public GameOfLife createGameOfLife() {
        return new GameOfLife(grid);
    }
}