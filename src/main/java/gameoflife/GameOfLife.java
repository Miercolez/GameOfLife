package gameoflife;

public class GameOfLife {

    private final Grid grid;

    public GameOfLife(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    public void renderNextRound() {
        grid.calculateNextRound();
    }
}
