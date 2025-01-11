import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue_reversal {
    public static void queueReversal(Queue<Integer> q) { // O(n)
        if (q.isEmpty()) {
            return;
        }
        int x = q.remove();
        queueReversal(q);
        q.add(x);
    }

    public static void reverse(Queue<Integer> q) { // O(n)
        if (q.isEmpty()) {
            return;
        }

        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            q.add(i);
        }

        queueReversal(q);
        // reverse(q);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
