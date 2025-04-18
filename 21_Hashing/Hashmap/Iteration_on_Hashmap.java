import java.util.HashMap;

public class Iteration_on_Hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 500);
        map.put("China", 100);
        map.put("US", 100);
        map.put("UK", 100);
        map.put("Nepal", 100);
        map.put("China", 200);

        // iteration
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
