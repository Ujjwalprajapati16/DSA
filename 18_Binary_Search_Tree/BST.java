public class BST {
    public static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else if (root.data < val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    private static Node findInorderSuccessor(Node root) {
        Node current = root;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return root;
        }

        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else {
            // node with no child
            if (root.left == null && root.right == null) {
                return null;
            }
            // node with one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // node with two children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        int[] values = { 15, 10, 20, 8, 12, 17, 25 };
        for (int val : values) {
            root = insert(root, val);
        }
        System.out.println("Inorder traversal of the BST:");
        inorder(root);

        int[] valuesToInsert = { 6, 14, 16, 30 };
        for (int val : valuesToInsert) {
            root = insert(root, val);
        }
        System.out.println("\nInorder traversal after inserting more values:");
        inorder(root);

        System.out.println("\nSearching for values in the BST:");
        int[] searchValues = { 10, 30, 5, 25 };
        for (int val : searchValues) {
            boolean found = search(root, val);
            System.out.println("Value " + val + (found ? " found" : " not found"));
        }

        System.out.println("\nDeleting values from the BST:");
        int[] valuesToDelete = { 10, 20, 8 };
        for (int val : valuesToDelete) {
            root = delete(root, val);
            System.out.println("Deleted " + val + ", current inorder traversal:");
            inorder(root);
            System.out.println();
        }
        System.out.println("Final inorder traversal of the BST:");
        inorder(root);
    }
}
