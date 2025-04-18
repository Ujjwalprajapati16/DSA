import java.util.HashMap;

public class HM {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // insert - O(1)
        map.put("India", 500);
        map.put("China", 100);
        map.put("US", 100);
        map.put("UK", 100);
        map.put("Nepal", 100);
        map.put("China", 200);
        System.out.println(map); // {China=200, UK=100, US=100, Nepal=100, India=500}

        // search - O(1)
        System.out.println(map.get("China")); // 200

        // delete - O(1)
        map.remove("UK");
        System.out.println(map); // {China=200, US=100, Nepal=100, India=500}

        // contains - O(1)
        System.out.println(map.containsKey("China")); // true

        // size - O(1)
        System.out.println(map.size()); // 4

        // clear - O(1)
        map.clear();
        System.out.println(map); // {}

        // isEmpty - O(1)
        System.out.println(map.isEmpty()); // true
    }
}
