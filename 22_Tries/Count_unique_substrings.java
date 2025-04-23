public class Count_unique_substrings {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){ // O(L)
        Node curr = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static int countNodes(Node root){
        if(root == null) {
            return 0;
        }

        int count = 0;
        for(Node child : root.children){
            count += countNodes(child);
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String str = "apple";
        for(int i=0; i<str.length(); i++){
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root)); // 15
    }
}
