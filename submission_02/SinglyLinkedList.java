public class SinglyLinkedList {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        System.out.println(data + " inserted");
    }

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        System.out.println(data + " inserted");
    }

    public void delete(int data) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println(data + " deleted");
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data != data) {

            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found");
            return;
        }

        current.next = current.next.next;

        System.out.println(data + " deleted");
    }

    public void display() {

        Node current = head;

        if (current == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("List: ");

        while (current != null) {

            System.out.print(current.data + " -> ");

            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);

        list.display();

        list.delete(20);

        list.display();
    }
}
