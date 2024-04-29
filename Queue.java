public class Queue {
    // Instance variables
    private Node front;
    private Node rear;

    // Constructor
    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Methods
    public boolean isEmpty() {
        return front == null;
    }
    //Method to add node to queue
    public void enqueue(Room data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }
    Method to remove node from queue
    public Room dequeue() {
        if (isEmpty()) {
            return null;
        }
        Room data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return data;
    }
}
