
public class UnboundedArrayStack {

    private int[] arr;
    private int top;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            resize(capacity * 2);
        }

        arr[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int value = arr[top];
        top--;

        if (capacity > 2 && top + 1 <= capacity / 4) {
            resize(Math.max(2, capacity / 2));
        }

        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void resize(int newCapacity) {
        int[] newArr = new int[newCapacity];

        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
        capacity = newCapacity;
    }

    public static void main(String[] args) {

        UnboundedArrayStack stack = new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Stack Size: " + stack.size());
        System.out.println("Top Element: " + stack.peek());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Stack Size: " + stack.size());
        System.out.println("Top Element: " + stack.peek());
    }
}