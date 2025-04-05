public class Kth_ancestor_of_node {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static int kthAncestor(Node root, int k, int node) {
        if (root == null) {
            return -1;
        }

        if (root.data == node) {
            return 0;
        }

        int left = kthAncestor(root.left, k, node);
        int right = kthAncestor(root.right, k, node);

        if (left == -1 && right == -1) {
            return -1;
        }

        int max = Math.max(left, right) + 1;
        if (max == k) {
            return root.data;
        }

        return max;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2;
        int node = 5;
        System.out.println("Kth ancestor of " + node + " is " + kthAncestor(root, k, node)); // OUTPUT : 1
    }
}
