import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_by_frequency {
    public static String frequencySort(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ?
            a.getKey() - b.getKey() : 
            b.getValue() - a.getValue()
        );
        maxHeap.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(frequencySort(s));

        String s1 = "tree";
        System.out.println(frequencySort(s1));

        String s2 = "Aabb";
        System.out.println(frequencySort(s2));
    }
}

