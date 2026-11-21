import java.util.Stack;

public class DequeueFriendlyStackQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int value) {

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(value);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        System.out.println(value + " enqueued");
    }

    public int dequeue() {

        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return s1.pop();
    }

    public void display() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = s1.size() - 1; i >= 0; i--) {
            System.out.print(s1.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        DequeueFriendlyStackQueue q =
                new DequeueFriendlyStackQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Dequeued: " + q.dequeue());

        q.display();
    }
}
