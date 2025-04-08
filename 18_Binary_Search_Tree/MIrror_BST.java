public class MIrror_BST {
    public static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }

        Node leftSubtree = mirror(root.left);
        Node rightSubtree = mirror(root.right);

        root.left = rightSubtree;
        root.right = leftSubtree;

        return root;
    }

    public static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        System.out.println("Original BST Inorder Traversal:");
        printInorder(root);
        System.out.println();

        root = mirror(root);

        System.out.println("Mirrored BST Inorder Traversal:");
        printInorder(root);
    }
}
