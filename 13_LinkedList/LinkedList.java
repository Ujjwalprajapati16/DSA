
public class LinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        // temp -> prevNode
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        size--;
        return val;
    }

    public int itrSearch(int key) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == key) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    private int recurSearchHelper(Node head, int key, int index) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return index;
        }

        return recurSearchHelper(head.next, key, index + 1);
    }

    public int recurSearch(int key) {
        return recurSearchHelper(head, key, 0);
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public int deleteNthNodeFromEnd(int index) {
        // calcuulate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (index < 0 || index >= sz) {
            return -1;
        }
        if (index == 0) {
            return removeFirst();
        }

        // delete nth node from end
        Node prev = head;
        int i = 1;
        int idx = sz - index;
        while (i < idx - 1) {
            prev = prev.next;
            i++;
        }

        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // find mid
        Node mid = findMid(head);

        // reverse 2nd half
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        // check left half and right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            System.out.println("No cycle");
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // make the last node.next to null
        prev.next = null;
    }

    // merge sort in ll

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(0);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next;
        }

        while (head2 != null) {
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next;
        }

        temp.next = (head1 != null) ? head1 : head2;

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        // left & right ms
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    // Zig Zag linkedlist
    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow; 

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // alternate merging
        Node left = head;
        Node right = prev;
        Node nextLeft, nextRight;
         
        while(left != null && right != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            // updation
            left = nextLeft;
            right = nextRight;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.print();
        list.addFirst(10);
        list.addFirst(20);

        list.addLast(30);
        list.addLast(40);

        list.print();

        System.out.println("Deleted element is " + list.deleteNthNodeFromEnd(3));

        list.add(2, 50);
        list.print();

        System.out.println("index of 50 is " + list.itrSearch(50));
        System.out.println("index of 50 is " + list.recurSearch(30));

        System.out.println("size of list is " + list.size);

        list.removeFirst();
        list.print();

        System.out.println("size of list is " + list.size);

        list.removeLast();
        list.print();

        System.out.println("size of list is " + list.size);

        list.reverse();
        list.print();

        list.addLast(60);
        list.addLast(70);
        list.addLast(80);
        list.print();

        System.out.println("Deleted element is " + list.deleteNthNodeFromEnd(2));
        list.print();

        LinkedList list2 = new LinkedList();

        list2.addFirst(1);
        list2.addFirst(2);
        list2.addFirst(3);
        list2.addFirst(2);
        list2.addFirst(1);
        list2.print();

        System.out.println("Palindrome: " + list.checkPalindrome());

        // detect loop in linkedlist
        LinkedList list3 = new LinkedList();
        head = list3.new Node(1);
        head.next = list3.new Node(2);
        head.next.next = list3.new Node(3);
        head.next.next.next = list3.new Node(4);
        head.next.next.next.next = list3.new Node(5);
        head.next.next.next.next.next = head.next.next;

        System.out.println("Cycle: " + list.isCycle());
        list3.removeCycle();
        list3.print();
        System.out.println("Cycle: " + list.isCycle());

        // sorting in linkedlist
        LinkedList list4 = new LinkedList();
        list4.addFirst(10);
        list4.addFirst(20);
        list4.addFirst(30);
        list4.addFirst(40);
        list4.print();
        list4.head = list4.mergeSort(list4.head);
        list4.print();

        // Zig Zag linkedlist
        LinkedList list5 = new LinkedList();
        list5.addLast(1);
        list5.addLast(2);
        list5.addLast(3);
        list5.addLast(4);
        list5.addLast(5);
        list5.print();
        list5.zigZag();
        list5.print();
    }
}
