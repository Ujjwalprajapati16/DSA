
import java.util.ArrayList;
import java.util.Collections;

public class Sorting_of_list {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // add elements
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        System.out.println("Before sorting: " + list);

        // sort list
        Collections.sort(list);

        System.out.println("After sorting: " + list);

        // sorting in descending order
        Collections.sort(list, Collections.reverseOrder());

        System.out.println("After sorting in descending order: " + list);
    }
}
