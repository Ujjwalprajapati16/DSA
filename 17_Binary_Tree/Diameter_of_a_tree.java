public class Diameter_of_a_tree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    static int diameter(Node root) { // O(n^2)
        if (root == null) {
            return 0;
        }

        int ldiam = diameter(root.left);
        int rdiam = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        int selfDiam = lh + rh + 1;

        return Math.max(selfDiam, Math.max(ldiam, rdiam));
    }

    static class Info {
        int diam;
        int ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    static Info diameter2(Node root) { // O(n)
        if (root == null) {
            return new Info(0, 0);
        }

        Info left = diameter2(root.left);
        Info right = diameter2(root.right);

        int diam = Math.max(left.ht + right.ht + 1, Math.max(left.diam, right.diam));
        int ht = Math.max(left.ht, right.ht) + 1;
        return new Info(diam, ht);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.right = new Node(6);

        System.out.println("Diameter of the tree is " + diameter(root));

        Info res = diameter2(root);
        System.out.println("Diameter of the tree is " + res.diam);
    }
}
