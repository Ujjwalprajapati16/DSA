
import java.util.LinkedList;
import java.util.Queue;

public class Stack_using_two_queues {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // add
        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // remove
        public static int pop() {
            if (q1.isEmpty() && q2.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            int top = -1;

            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (!q1.isEmpty()) {
                        q2.add(top);
                    }
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (!q2.isEmpty()) {
                        q1.add(top);
                    }
                }
            }
            return top;
        }

        // peek
        public static int peek() {
            if (q1.isEmpty() && q2.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            int top = -1;

            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
