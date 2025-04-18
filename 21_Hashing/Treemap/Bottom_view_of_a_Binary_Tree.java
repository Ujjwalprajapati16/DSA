import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Bottom_view_of_a_Binary_Tree {
    public static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static class Pair {
        Node node;
        int hd; // horizontal distance

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void bottomView(Node root) {
        if (root == null)
            return;

        // TreeMap to store HD vs Node data
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node node = temp.node;
            int hd = temp.hd;

            // Overwrite at each level (bottommost at this hd will remain)
            map.put(hd, node.data);

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Print the bottom view
        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("Bottom view of the binary tree:");
        bottomView(root);

        /*
         * Bottom view of the binary tree:
         * 5 10 3 14 25
         */
    }
}
