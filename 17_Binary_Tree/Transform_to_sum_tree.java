public class Transform_to_sum_tree {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static int transform(Node root){
        if(root == null)
            return 0;

        int left = transform(root.left);
        int right = transform(root.right);

        int data = root.data;
        int totalLeft = root.left != null ? root.left.data : 0;
        int totalRight = root.right != null ? root.right.data : 0;
        root.data = left + right + totalLeft + totalRight;

        return data;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        /*
         *           1
         *     2             3
         *  4     5       6     7
         * 
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transform(root);
        preorder(root); // OUTPUT : 27 9 0 0 13 0 0 
    }
}
