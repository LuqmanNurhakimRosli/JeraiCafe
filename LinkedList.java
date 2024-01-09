public class LinkedList {
    private Node first;
    private Node last;


    public LinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertAtFront(Object data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    public void insertAtBack(Object data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public Object removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        Object removedData = first.data;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return removedData;
    }

    public int peekFirst() {
        if (isEmpty()) {
            return -1; // Or throw an exception
        }
        return (int) first.data;
    }

    public Object removeFromBack() {
        if (isEmpty()) {
            return null;
        }
        Object removedData = last.data;

        if (first == last) {
            first = null;
            last = null;
        } else {
            Node current = first;
            while (current.next != last) {
                current = current.next;
            }
            last = current;
            last.next = null;
        }
        return removedData;
    }

    public void display() {
        Node current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public Object getNext() {
        Node current = first;
        if (first == null || first == last) {
            return null;
        } else {
            current = current.next;
            return current.data;
        }
    }

    public Object getFirst() {
        Node current = first;
        if (first == null) {
            return null;
        } else {
            current = first;
            return current.data;
        }
    }
}