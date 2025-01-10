
import java.util.Stack;

public class Queue_using_two_stacks {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        public static void add(int data){ // O(n)
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.pop();
        }

        // peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.peek();
        }
    }
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Queue q = new Queue(); 
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
