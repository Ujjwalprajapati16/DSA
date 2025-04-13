public class AVLTrees {
    public static class Node {
        int data, height;
        Node left, right;

        Node(int data){
            this.data = data;
            height = 1;
            left = null;
            right = null;
        }
    }

    public static Node root;

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    static int max(int a, int b){
        return a > b ? a : b;
    }

    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node rightRotate(Node root){
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.height = 1 + max(height(root.left), height(root.right));
        newRoot.height = 1 + max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }

    public static Node leftRotate(Node root){
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = 1 + max(height(root.left), height(root.right));
        newRoot.height = 1 + max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }

    public static Node insert(Node root, int data){
        if(root == null){
            return new Node(data);
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        }else if(data > root.data){
            root.right = insert(root.right, data);
        }
        root.height = 1 + max(height(root.left), height(root.right));

        int bf = getBalance(root);

        // Left left case
        if(bf > 1 && data < root.left.data){
            return rightRotate(root);
        }

        // Left right case
        if(bf > 1 && data > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right right case
        if(bf < -1 && data > root.right.data){
            return leftRotate(root);
        }

        // Right left case
        if(bf < -1 && data < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
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
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*          AVL Tree
         *              30
         *             /  \
         *           20    40
         *          /  \     \
         *         10   25    50
         */

        preorder(root);
    }
}
