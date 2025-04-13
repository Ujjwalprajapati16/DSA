import java.util.ArrayList;

public class Find_kth_smallest_element_in_BST {
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

    private static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static int kthSmallest(Node root, int k){
        ArrayList<Integer> arr = new ArrayList<>();
        getInorder(root, arr);
        return arr.get(k - 1);
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

        int k = 3;
        int result = kthSmallest(root, k);
        System.out.println("Kth smallest element: " + result);

        k = 5;
        result = kthSmallest(root, k);
        System.out.println("Kth smallest element: " + result);
    }
}
 