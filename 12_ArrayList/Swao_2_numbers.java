
import java.util.ArrayList;

public class Swao_2_numbers {
    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // add elements
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        // swap 2 numbers
        swap(list, 1, 3);
        System.out.println(list);
    }
}
