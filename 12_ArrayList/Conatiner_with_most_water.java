import java.util.ArrayList;

public class Conatiner_with_most_water {
    // Brute force - O(n^2)
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;

        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wt = j - i;
                int water = ht * wt;
                maxWater = Math.max(maxWater, water);
            }
        }

        return maxWater;
    }

    // Two pointer approach - O(n)
    public static int storeWater2(ArrayList<Integer> height) {
        int maxWater = 0;

        int i = 0;
        int j = height.size() - 1;

        while (i < j) {
            int ht = Math.min(height.get(i), height.get(j));
            int wt = j - i;
            int water = ht * wt;
            maxWater = Math.max(maxWater, water);

            if (height.get(i) < height.get(j)) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 1, 8, 6, 2, 5, 4, 8, 3, 7
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        System.out.println("Maximum water: " + storeWater(list));
        System.out.println("Maximum water using two pointer: " + storeWater2(list));
    }
}
