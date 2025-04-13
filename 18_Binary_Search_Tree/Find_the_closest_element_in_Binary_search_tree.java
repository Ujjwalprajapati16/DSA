public class Find_the_closest_element_in_Binary_search_tree {
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

    public static int closestElement(Node root, int target) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int diff = Math.abs(root.data - target);
        int leftDiff = Math.abs(closestElement(root.left, target) - target);
        int rightDiff = Math.abs(closestElement(root.right, target) - target);

        if (diff < leftDiff && diff < rightDiff) {
            return root.data;
        }

        if (leftDiff < rightDiff) {
            return closestElement(root.left, target);
        }

        return closestElement(root.right, target);
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

        int target = 19;

        int closest = closestElement(root, target);
        System.out.println("Closest element: " + closest); // Output: 20

        target = 5;
        closest = closestElement(root, target);
        System.out.println("Closest element: " + closest); // Output: 5
    }
}
