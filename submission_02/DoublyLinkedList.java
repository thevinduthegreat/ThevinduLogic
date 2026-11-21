public class DoublyLinkedList {

    class Node {

        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        System.out.println(data + " inserted");
    }

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println(data + " inserted");
    }

    public void delete(int data) {

        Node current = head;

        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        System.out.println(data + " deleted");
    }

    public void displayForward() {

        Node current = head;

        if (current == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Forward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public void displayBackward() {

        Node current = tail;

        if (current == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Backward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.displayForward();
        list.displayBackward();

        list.delete(20);

        list.displayForward();
        list.displayBackward();
    }
}
