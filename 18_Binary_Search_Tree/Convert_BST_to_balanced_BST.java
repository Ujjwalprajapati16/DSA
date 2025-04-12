import java.util.ArrayList;

public class Convert_BST_to_balanced_BST {
    public static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    private static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    private static Node createBalancedBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBalancedBST(inorder, start, mid - 1);
        root.right = createBalancedBST(inorder, mid + 1, end);
        return root;
    }

    public static Node BalancedBST(Node root) {
        // inorder squenece
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder to Balanced BST
        return createBalancedBST(inorder, 0, inorder.size() - 1);
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
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        Node balancedRoot = BalancedBST(root);
        // Print the balanced BST in pre-order
        preOrder(balancedRoot);
    }
}
