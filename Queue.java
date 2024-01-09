public class Queue extends LinkedList {

    public Queue() {
    }

    public void enqueue(Object data) {
        insertAtBack(data);
    }

    public Object dequeue() {
        return removeFromFront();
    }

    public Object getFront() {
        return peekFirst();
    }

    public Object getEnd() {
        Object data = removeFromBack();
        insertAtBack(data);
        return data;
    }
}