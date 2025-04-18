import java.util.LinkedHashSet;

public class LHS {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");
        cities.add("Pune");
        cities.add("Mumbai");

        System.out.println(cities); // [Delhi, Mumbai, Bangalore, Pune]
        System.out.println(cities.contains("Delhi")); // true
        cities.remove("Mumbai");
        System.out.println(cities); // [Delhi, Bangalore, Pune]
        System.out.println(cities.size()); // 3
        cities.clear();
        System.out.println(cities); // []
        System.out.println(cities.size()); // 0
    }
}
