public class Trie {
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

    public static boolean search(String word){ // O(L)
        Node curr = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public static boolean startsWith(String prefix){ // O(L)
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        // String[] words = {"the", "a", "there", "their", "any", "thee"};
        // for(String word : words){
        //     insert(word);
        // }

        // System.out.println(search("th")); // false
        // System.out.println(search("thee")); // true

        String[] words = {"apple", "app", "mago", "man", "women"};

        for(String word : words){
            insert(word);
        }

        String prefix1 = "app";
        String prefix2 = "moon";
        System.out.println(startsWith(prefix1)); // true
        System.out.println(startsWith(prefix2)); // false
    }
}
