
import java.util.Deque;
import java.util.LinkedList;

public class Stack_and_Queue_using_deque {
    static class Stack {
        static Deque<Integer> q = new LinkedList<>();

        public static void push(int data) {
            q.addLast(data);
        }

        public static int pop() {
            return q.removeLast();
        }

        public static int peek() {
            return q.getLast();
        }
    }

    static class Queue {
        static Deque<Integer> q = new LinkedList<>();

        public static void add(int data) {
            q.addLast(data);
        }

        public static int remove() {
            return q.removeFirst();
        }

        public static int peek() {
            return q.removeFirst();
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.peek());

        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println(q.peek());
    }
}
