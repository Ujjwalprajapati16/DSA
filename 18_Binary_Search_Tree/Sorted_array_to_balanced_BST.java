public class Sorted_array_to_balanced_BST {
    public static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static Node createdBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = createdBST(arr, start, mid - 1);
        root.right = createdBST(arr, mid + 1, end);

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = createdBST(arr, 0, arr.length - 1);
        preOrder(root); // Output: 8 5 3 6 10 11 12
    }
}
