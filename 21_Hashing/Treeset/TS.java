import java.util.TreeSet;

public class TS {
    public static void main(String[] args) {
        TreeSet<String> cities = new TreeSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");
        cities.add("Pune");
        cities.add("Mumbai");
        System.out.println(cities); // [Bangalore, Delhi, Mumbai, Pune]
    }
}
