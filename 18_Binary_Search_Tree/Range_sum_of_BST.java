public class Range_sum_of_BST {
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

    public static int rangeSumBST(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.data < low) {
            return rangeSumBST(root.right, low, high);
        }

        if (root.data > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.data + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        /*
         *           8
         *         /   \
         *        5     11
         *       / \       \
         *      3   6       20
         *    
         */

        int low = 9;
        int high = 15;

        int sum = rangeSumBST(root, low, high);
        System.out.println("Range sum of BST: " + sum); // Output: 11
    }
}

