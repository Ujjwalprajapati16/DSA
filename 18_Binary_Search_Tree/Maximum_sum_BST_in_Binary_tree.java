public class Maximum_sum_BST_in_Binary_tree {

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Info {
        boolean isBST;
        int sum;
        int min;
        int max;

        Info(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    static int maxSum = 0;

    public static Info maxSumBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = maxSumBST(root.left);
        Info right = maxSumBST(root.right);

        // Check if current subtree is BST
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int sum = root.data + left.sum + right.sum;
            maxSum = Math.max(maxSum, sum);
            return new Info(true, sum, Math.min(root.data, left.min), Math.max(root.data, right.max));
        }

        return new Info(false, 0, 0, 0); // not a BST
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.left.right = new Node(3);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);

        /*          5
         *         / \ 
         *        9   2 
         *       /     \ 
         *      6   3 
         *     / \ 
         *    8   7 
         */

        maxSumBST(root);
        System.out.println("Maximum sum of BST: " + maxSum);  // Output: 8
    }
}
