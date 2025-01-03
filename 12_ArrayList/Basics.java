
import java.util.ArrayList;

public class Basics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // get elements
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

        // set elements
        list.set(0, 100);
        list.set(1, 200);

        // remove elements
        list.remove(0);
        list.remove(1);

        // size of list
        System.out.println(list.size());

        // loop on list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // contains
        System.out.println(list.contains(10));

        // isEmpty
        System.out.println(list.isEmpty());

        // clear
        list.clear();

    }
}
