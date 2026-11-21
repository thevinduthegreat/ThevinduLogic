public class ArrayCircularQueue {

    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int capacity) {

        this.capacity = capacity;
        arr = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {

        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % capacity;

        arr[rear] = value;
        size++;

        System.out.println(value + " enqueued");
    }

    public int dequeue() {

        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }

        int removed = arr[front];

        front = (front + 1) % capacity;
        size--;

        return removed;
    }

    public void display() {

        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % capacity;

            System.out.print(arr[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayCircularQueue q = new ArrayCircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());

        q.enqueue(50);
        q.enqueue(60);

        q.display();
    }
}
