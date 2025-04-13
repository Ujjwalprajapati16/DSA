import java.util.ArrayList;
import java.util.List;

public class Two_sum_BSTs {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inorder(Node root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static void twoSum(Node root1, Node root2, int x) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        int i = 0, j = list2.size() - 1;
        int count = 0;

        System.out.println("The pairs are:");
        while (i < list1.size() && j >= 0) {
            int val1 = list1.get(i);
            int val2 = list2.get(j);

            if (val1 + val2 == x) {
                System.out.println("(" + val1 + ", " + val2 + ")");
                count++;
                i++;
                j--;
            } else if (val1 + val2 < x) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println("Total pairs: " + count);
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(1);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        /*
         * 5
         * / \
         * 3 7
         * / \ / \
         * 1 4 6 8
         */

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        /*
         * 10
         * / \
         * 6 15
         * / \ / \
         * 3 8 11 18
         */

        int sum = 16;
        twoSum(root1, root2, sum);

        /*
         * The pairs are:
         * (1, 15)
         * (5, 11)
         * (6, 10)
         * (8, 8)
         * Total pairs: 4
         */
    }
}
