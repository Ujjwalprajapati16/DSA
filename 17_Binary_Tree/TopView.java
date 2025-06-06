
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {

    public static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {

        Node node;
        int hd; // horizontal distance from the root

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node node) {
        //Level Order
        Queue<Info> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>(); // to store the first node at each horizontal distance

        int min = 0, max = 0;
        queue.add(new Info(node, 0));
        queue.add(null);

        while (!queue.isEmpty()) {
            Info curr = queue.remove();
            if (curr == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {

                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    queue.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    queue.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                System.out.print(map.get(i).data + " ");
            }
        }
        System.out.println();
    }

    public static void bottomView(Node root) {
        Queue<Info> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        queue.add(new Info(root, 0));
        queue.add(null);

        while (!queue.isEmpty()) {
            Info curr = queue.remove();
            if (curr == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                map.put(curr.hd, curr.node);
                if (curr.node.left != null) {
                    queue.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    queue.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }

            }
        }

        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                System.out.print(map.get(i).data + " ");
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        topView(root);
        bottomView(root);
    }
}
