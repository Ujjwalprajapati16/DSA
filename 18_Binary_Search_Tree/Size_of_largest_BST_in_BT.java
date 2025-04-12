public class Size_of_largest_BST_in_BT {
    public static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static class Info {
        int size;
        int min;
        int max;
        boolean isBST;

        public Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        Info left = largestBST(root.left);
        Info right = largestBST(root.right);

        int size = left.size + right.size + 1;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));
        boolean isBST = left.isBST && right.isBST && root.data > left.max && root.data < right.min;

        if (isBST) {
            maxBST = Math.max(maxBST, size);
        }

        return new Info(size, min, max, isBST);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(7);

        largestBST(root);
        System.out.println("Size of the largest BST in the given binary tree: " + maxBST); // Output: 3

        maxBST = 0;

        Node root1 = new Node(50);
        root1.left = new Node(30);
        root1.right = new Node(60);
        root1.left.left = new Node(5);
        root1.left.right = new Node(20);
        root1.right.left = new Node(45);
        root1.right.right = new Node(70);
        root1.right.right.right = new Node(80);
        root1.right.right.left = new Node(65);

        largestBST(root1);
        System.out.println("Size of the largest BST in the given binary tree: " + maxBST); // output : 5
    }
}
