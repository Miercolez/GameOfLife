public class Cell {

    private final Position position;
    private boolean isAlive = false;
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

    public void checkExistence(){
        if (neighbours == 2 || neighbours == 3){
            isAlive = true;
        }else {
            isAlive = false;
        }
    }
}
