public class Room {
    // Instance variables
    private char symbol; // Maze symbols: ., #, *, o
    private boolean visited;

    // Constructor
    public Room(char symbol) {
        this.symbol = symbol;
        this.visited = false;
    }

    // Getters and setters
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
