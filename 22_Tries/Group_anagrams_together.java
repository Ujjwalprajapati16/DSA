import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_anagrams_together {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        List<String> anagrams = new ArrayList<>();
    }

    public static TrieNode root = new TrieNode();

    // Insert a word into the Trie using its sorted version
    public static void insert(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        TrieNode node = root;

        for (char c : chars) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.anagrams.add(word); // Add original word to anagrams list
    }

    // DFS traversal to collect all anagram groups
    public static void collectAnagrams(TrieNode node, List<List<String>> result) {
        if (!node.anagrams.isEmpty()) {
            result.add(new ArrayList<>(node.anagrams));
        }

        for (TrieNode child : node.children.values()) {
            collectAnagrams(child, result);
        }
    }

    // Main method to group anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {
        for (String word : strs) {
            insert(word);
        }

        List<List<String>> result = new ArrayList<>();
        collectAnagrams(root, result);
        return result;
    }

    public static void main(String[] args) {
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input1));

        root = new TrieNode(); // Reset the Trie for next test case

        String[] input2 = {""};
        System.out.println(groupAnagrams(input2));

        root = new TrieNode(); // Reset the Trie for next test case

        String[] input3 = {"a"};
        System.out.println(groupAnagrams(input3));
    }
}
