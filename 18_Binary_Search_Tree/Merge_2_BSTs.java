import java.util.ArrayList;

public class Merge_2_BSTs {
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

    private static Node createBST(ArrayList<Integer> BST, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;
        Node node = new Node(BST.get(mid));
        node.left = createBST(BST, st, mid - 1);
        node.right = createBST(BST, mid + 1, end);
        return node;
    }

    public static Node merge(Node root1, Node root2) {
        // BST1 inorder seq
        ArrayList<Integer> BST1 = new ArrayList<>();
        getInorder(root1, BST1);

        // BST2 inorder seq
        ArrayList<Integer> BST2 = new ArrayList<>();
        getInorder(root2, BST2);

        // merge both seqs into a new BST
        ArrayList<Integer> BST = new ArrayList<>();
        int i = 0, j = 0;
        while (i < BST1.size() && j < BST2.size()) {
            if (BST1.get(i) < BST2.get(j)) {
                BST.add(BST1.get(i));
                i++;
            } else {
                BST.add(BST2.get(j));
                j++;
            }
        }

        while (i < BST1.size()) {
            BST.add(BST1.get(i));
            i++;
        }

        while (j < BST2.size()) {
            BST.add(BST2.get(j));
            j++;
        }

        // sorted arr -> balanced BST
        return createBST(BST, 0, BST.size() - 1);
    }

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String args[]) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node merged = merge(root1, root2);

        preOrder(merged); // 3 1 2 9 4 12 
    }
}
