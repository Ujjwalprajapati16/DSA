public class Min_distance_between_two_nodes {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        if (leftLca == null) {
            return rightLca;
        }

        if (rightLca == null) {
            return leftLca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else if (rightDist == -1) {
            return leftDist + 1;
        } else {
            return Math.min(leftDist, rightDist) + 1;
        }
    }

    public static int minDistance(Node root, int n1, int n2) {
        Node lcaNode = lca(root, n1, n2);
        int dist1 = lcaDist(lcaNode, n1);
        int dist2 = lcaDist(lcaNode, n2);

        return dist1 + dist2;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int node1 = 4;
        int node2 = 6;

        int distance = minDistance(root, node1, node2);
        System.out.println("Minimum distance between " + node1 + " and " + node2 + " is: " + distance);
    }
}
