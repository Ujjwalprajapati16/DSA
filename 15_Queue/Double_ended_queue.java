
import java.util.Deque;
import java.util.LinkedList;

public class Double_ended_queue {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);

        deque.addLast(40);
        deque.addLast(50);

        System.out.println(deque);

        // while (!deque.isEmpty()) {
        // System.out.print(deque.removeFirst() + " ");
        // }

        deque.removeFirst();
        deque.removeLast();

        System.out.println(deque);

        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
    }
}
