
import java.util.ArrayList;

public class Multidimensional_array {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1);
            list2.add(i * 2);
            list3.add(i * 3);
        }

        list.add(list1);
        list.add(list2);
        list.add(list3);

        System.out.println(list);

        // nested loop to print
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }

        // // add elements
        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(10);
        // list1.add(20);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(30);
        // list2.add(40);

        // list.add(list1);
        // list.add(list2);

        // // get elements
        // System.out.println(list.get(0).get(0));
        // System.out.println(list.get(0).get(1));

        // System.out.println(list);
    }
}
