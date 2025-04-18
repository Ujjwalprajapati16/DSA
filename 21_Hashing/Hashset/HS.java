import java.util.HashSet;

public class HS {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(3);
        set.add(6);
        set.add(5);
        set.add(8);
        set.add(6);
        set.add(1);
        System.out.println(set); // [1, 2, 3, 4, 5, 6, 8]
        System.out.println(set.contains(5)); // true
        set.remove(5);
        System.out.println(set); // [1, 2, 3, 4, 6, 8]
        System.out.println(set.size()); // 6
        set.clear();
        System.out.println(set); // []
        System.out.println(set.size()); // 0
    }
}
