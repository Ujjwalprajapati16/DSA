public class WordBreak {
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

    public static void insert(String word){
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

    public static boolean search(String word){
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

    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }

        for(int i = 1; i<= key.length(); i++){
            String prefix = key.substring(0, i);
            String suffix = key.substring(i);

            if(search(prefix) && wordBreak(suffix)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(String word : words){
            insert(word);
        }

        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("ilike"));
        System.out.println(wordBreak("samsng"));
    }
}
