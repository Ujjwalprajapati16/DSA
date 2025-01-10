public class Queue_using_LinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;
        
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // add
        public static void enqueue(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // remove
        public static int dequeue() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = head.data;
            if(head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            return front;
        }

        // peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.dequeue();
        }

        q.enqueue(60);

        System.out.println(q.peek());
    }
}
