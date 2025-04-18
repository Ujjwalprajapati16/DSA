import java.util.HashSet;
import java.util.Iterator;

public class Iteration_on_hashset {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");
        cities.add("Pune");
        cities.add("Mumbai");
        System.out.println(cities); // [Delhi, Mumbai, Bangalore, Pune]

        // advanced for loop
        for (String city : cities) {
            System.out.println(city);
        }

        // using iterator
        Iterator<String> it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
