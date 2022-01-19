package gameoflife;

public record GameOfLife(Grid grid) {

    public Grid getGrid() {
        return grid;
    }

    public void renderNextRound() {
        grid.calculateNextRound();
    }
}
