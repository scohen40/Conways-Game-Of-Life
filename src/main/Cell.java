package src.main;

public class Cell {
    private int rowLocation;
    private int columnLocation;
    private int id;

    public enum State{
        alive,
        dead,
        neverLived
    }

    private State state;

    public Cell(int rowLocation, int columnLocation) {
        this.rowLocation = rowLocation;
        this.columnLocation = columnLocation;
    }

    public int getRowLocation() {
        return rowLocation;
    }

    public void setRowLocation(int rowLocation) {
        this.rowLocation = rowLocation;
    }

    public int getColumnLocation() {
        return columnLocation;
    }

    public void setColumnLocation(int columnLocation) {
        this.columnLocation = columnLocation;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
