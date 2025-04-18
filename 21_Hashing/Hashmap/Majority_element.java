import java.util.HashMap;

public class Majority_element {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                System.out.println(key); // 1
            }
        }
    }
}
