public class Prefix_problem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node(){
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;

        for(int level = 0; level < word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];
        }
    }


    public static void prefixSum(Node root, String ans){
        if(root == null){
            return;
        }

        if(root.freq == 1){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null){
                prefixSum(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        String[] words = {"zebra", "dog", "duck", "dove"};
        for(String s : words){
            insert(s);
        }

        root.freq = -1;

        prefixSum(root, "");
    }
}
