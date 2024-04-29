public class Node {
    // Declare instance variables
    private Room data;
    private Node next;

    // Constructor
    public Node(Room data) {
        this.data = data;
        this.next = null;
    }

    // Getters and setters
    public Room getData() {
        return data;
    }

    public void setData(Room data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
