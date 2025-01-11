
import java.util.ArrayList;

public class Stack_Implementation_using_ArrayList {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // isEmpty
        public static boolean isEmpty() {
            return list.isEmpty();
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Stack s = new Stack();

        // System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        // System.out.println(s.pop());
        // System.out.println(s.peek());
        // System.out.println(s.isEmpty());

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
