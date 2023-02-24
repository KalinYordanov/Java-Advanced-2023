package WorkshopLinkedList;

public class Node {
    public int value;
    public Node prev;
    public Node next;

    Node(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
    public String toString() {
        return value+" ";
    }
}
